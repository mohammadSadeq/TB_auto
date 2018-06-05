/**
 * this generic test for cart regression that will pull tests from cartRegression tab from
 * datasheet.xlsx. 
*/
package com.generic.tests.Cart;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.Cart;
import com.generic.page.PDP;
import com.generic.page.Registration;
import com.generic.page.SignIn;
import com.generic.selector.PDPSelectors;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PagesURLs;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;
import com.generic.util.dataProviderUtils;

public class Mini_Cart extends SelTestCase {

	private static LinkedHashMap<String, Object> invintory;
	private static LinkedHashMap<String, Object> users;

	// user types
	public static final String guestUser = "guest";
	public static final String loggedInUser = "loggedin";
	String Pemail = "";
	// used sheet in test
	public static final String testDataSheet = SheetVariables.miniCartSheet;
	private static ThreadLocal<String> products = new ThreadLocal<String>();
	private static XmlTest testObject;
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
	LinkedHashMap<String, Object> productDetails;

	@BeforeClass
	public static void initialSetUp(XmlTest test) throws Exception {
		testCaseRepotId = SheetVariables.cartCaseId;
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
		invintory = Common.readLocalInventory();
		users = Common.readUsers();
	}

	@DataProvider(name = "Carts", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency mentainance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "Carts")
	public void CartBaseTest(String caseId, String runTest, String desc, String proprties, String products,
			String email, String OrderSubtotal, String ValidationMSG) throws Exception {
		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("cart_" + getBrowserName()));
		setTestCaseReportName("cart Case");
		logCaseDetailds(MessageFormat.format(LoggingMsg.CARTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), OrderSubtotal));

		// String CaseMail = "";
	//	String Pemail = "";
		LinkedHashMap<String, Object> userdetails = null;
		//String url = PagesURLs.getShoppingCartPage();
		if (!email.equals("")) {
			userdetails = (LinkedHashMap<String, Object>) users.get(email);
			 Pemail = getSubMailAccount(email);
			// CaseMail = (String) userdetails.get(Registration.keys.email);
			// Testlogs.get().debug("Mail will be used is: " + Pemail);
			Testlogs.get().debug("Mail will be used is: " + email);

		}
		try {

			if (proprties.contains("Loggedin"))
			{
				logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, userdetails));
				logs.debug(Pemail);
				logs.debug((String) userdetails.get(Registration.keys.password));
				SignIn.logIn(Pemail,(String) userdetails.get(Registration.keys.password));
			}
		
			
			
			
			if (proprties.contains("add to bag")) {
				logs.debug("\n..................\n");
				// navigate back to cart
			
			//	PDP.addProductsToCart("https://www.tommybahama.com/en/Boardwalk-Reversible-Sweatshirt/p/T219911-5478", PDPSelectors.color, PDPSelectors.size, PDPSelectors.qty);
				productDetails = (LinkedHashMap<String, Object>) invintory.get(products);
				PDP.addProductsToCart((String) productDetails.get(PDP.keys.url),
						(String) productDetails.get(PDP.keys.color), (String) productDetails.get(PDP.keys.size),
						(String) productDetails.get(PDP.keys.qty));
			}
			if (proprties.contains("Verify mini_cart image")) {
				// navigate back to cart
				String Main_url=PDP.getImageUrl().split("[?]")[0];
				String mini_url=PDP.getMiniImageUrl().split("[?]")[0];			
				logs.debug(Main_url);
				String Msg = "<font color=#f442cb>Main URL: " + Main_url +
						"<br>Mini URL: "+ mini_url+"</font>" ; 
				sassert().assertTrue(Main_url.equals(mini_url) , "FAILED: the images should be matched: <br>"+Msg);

				
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
		} // catch

	}// test


}
