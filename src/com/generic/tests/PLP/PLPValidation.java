package com.generic.tests.PLP;

import java.text.MessageFormat;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.PLP;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;
import com.generic.util.dataProviderUtils;

public class PLPValidation extends SelTestCase {

	// used sheet in test
	public static final String testDataSheet = SheetVariables.plpSheet;

	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
	}
	
	@DataProvider(name = "PLP", parallel = true)
	// concurrency maintenance on sheet reading
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@Test(dataProvider = "PLP")
	public void verifyPLP(String caseId, String runTest, String desc, String proprties, String PLPView,
			String PLPFacets, String PLPFilter, String QuickShop) throws Exception {

		Testlogs.set(new SASLogger("PLP " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName("PLP Case");
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc));

		try {
			String url = PagesURLs.getPLP();
			getDriver().get(url);

			if (!"".equals(PLPView)) {

				if (PLPView.contains("Grid")) {
					sassert().assertTrue(PLP.checkGridViewSelected(), "Grid view is not selected by default");
					sassert().assertTrue(PLP.checkGridViewProducts(), "Products are not displayed as expected");
					sassert().assertTrue(PLP.checkGridViewQuickshop(), "Quickshop button is displayed as expected");
					sassert().assertTrue(PLP.checkGridViewProductDes(), "Product Name is not displayed as expected");
					sassert().assertTrue(PLP.checkGridViewProductPrice(), "Product price is not displayed as expected");
					PLP.clickGridViewQuickshop();
					Thread.sleep(3000);
					sassert().assertTrue(PLP.checkQuickshopModalContent(), "Quickshop modal is not displayed as expected");
				}
				if (PLPView.contains("List")) {
					sassert().assertTrue(PLP.checkGridViewSelected(), "Grid view is not selected by default");
					PLP.clickListView();
					sassert().assertTrue(PLP.checkListViewSelected(), "List view is not selected as expected");
					sassert().assertTrue(PLP.checkListViewProducts(), "Products are not displayed as expected");
					sassert().assertTrue(PLP.checkListViewQuickshop(), "Quickshop button is displayed as expected");
					sassert().assertTrue(PLP.checkListViewProductTitle(), "Product Name is not displayed as expected");
					sassert().assertTrue(PLP.checkListViewProductPrice(), "Product price is not displayed as expected");
					PLP.clickListViewQuickshop();
					Thread.sleep(3000);
					sassert().assertTrue(PLP.checkQuickshopModalContent(), "Quickshop modal is not displayed as expected");
					// TODO: update getPLP function to add a url variable
					// url = PagesURLs.getPLP();
					url = PagesURLs.getPLP();
					getDriver().get(url);
					sassert().assertTrue(PLP.checkListViewSelected(), "Listview is not persist for all categories");
				}
			}
			if (!"".equals(PLPFacets)) {

				if (PLPFacets.contains("Style")) {
					if (PLP.isStyleFilterAvailable()) {
						int itemsNumber = PLP.countProductsInPage();
						PLP.clickFirstStyleFilter();
						Thread.sleep(2000);
						sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Style Fiter is not applied correctly");
					}

				}
				if (PLPFacets.contains("Fit")) {
					if (PLP.isFitFilterAvailable()) {
						int itemsNumber = PLP.countProductsInPage();
						PLP.clickFirstFitFilter();
						Thread.sleep(2000);
						sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Fit Fiter is not applied correctly");
					}
				}
				if (PLPFacets.contains("Color")) {
					if (PLP.isColorFilterAvailable()) {
						int itemsNumber = PLP.countProductsInPage();
						PLP.clickFirstColorFilter();
						Thread.sleep(2000);
						sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Color Fiter is not applied correctly");
					}
				}
				if (PLPFacets.contains("Size")) {
					if (PLP.isSizeFilterAvailable()) {
						int itemsNumber = PLP.countProductsInPage();
						PLP.clickFirstSizeFilter();
						Thread.sleep(2000);
						sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Size Fiter is not applied correctly");
					}
				}
				if (PLPFacets.contains("Pattern")) {
					int itemsNumber = PLP.countProductsInPage();
					PLP.clickFirstPatternFilterIfAvaiable();
					Thread.sleep(2000);
					sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Pattern Fiter is not applied correctly");
				}
				if (PLPFacets.contains("Collection")) {
					int itemsNumber = PLP.countProductsInPage();
					PLP.clickFirstCollectionFilterIfAvaiable();
					Thread.sleep(2000);
					sassert().assertTrue(PLP.countProductsInPage() <= itemsNumber, "Collection Fiter is not applied correctly");
				}
			}
			if (!"".equals(PLPFilter)) {
				if (PLPFilter.contains("Price") || PLPFilter.contains("Rating")) {
					sassert().assertTrue(PLP.sortAndValidate(PLPFilter), PLPFilter + " sorting is not OK");
					Thread.sleep(3000);
				} else {
					sassert().assertTrue(PLP.sortAndValidate(PLPFilter), "Sorting is not OK.");
					Thread.sleep(3000);
				}
			}
			if (!"".equals(QuickShop)) {
				if (QuickShop.contains("TRUE")) {
					sassert().assertTrue(PLP.checkQuickshopModalContent(), "Quickshop modal is not displayed as expected");
					PLP.clickQuickshopBtn();

				}
			}
			sassert().assertAll();
			Common.testPass();
		} catch (Throwable t) {
			setTestCaseDescription(getTestCaseDescription());
			Testlogs.get().debug(MessageFormat.format(LoggingMsg.DEBUGGING_TEXT, t.getMessage()));
			t.printStackTrace();
			String temp = getTestCaseReportName();
			Common.testFail(t, temp);
			ReportUtil.takeScreenShot(getDriver());
			Assert.assertTrue(false, t.getMessage());
		}

	}

}
