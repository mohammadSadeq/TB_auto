/**
 * this generic test for cart regression that will pull tests from cartRegression tab from
 * datasheet.xlsx. 
*/
package com.generic.tests.ordersHistory;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.OrderDetails;
import com.generic.page.OrderHistory;
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

public class OrderHistoryValidation extends SelTestCase {

	private static LinkedHashMap<String, Object> addresses = null;
	private static LinkedHashMap<String, Object> invintory;
	private static LinkedHashMap<String, Object> users;
	private static LinkedHashMap<String, Object> paymentCards = null;

	// user types
	public static final String guestUser = "guest";
	public static final String loggedInUser = "loggedin";
	String Pemail = "";
	// used sheet in test
	public static final String testDataSheet = SheetVariables.orderSheet;
	private static ThreadLocal<String> products = new ThreadLocal<String>();
	private static XmlTest testObject;
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
	LinkedHashMap<String, Object> productDetails;

	@BeforeClass
	public static void initialSetUp(XmlTest test) throws Exception {
		testCaseRepotId = SheetVariables.cartCaseId;
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
		addresses = Common.readAddresses();
		paymentCards = Common.readPaymentcards();
		invintory = Common.readLocalInventory();
		users = Common.readUsers();
	}

	@DataProvider(name = "ordersHistory", parallel = true)
	// concurrency maintenance on sheet reading
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "ordersHistory")
	public void verifyOrderHistory(String caseId, String runTest, String desc, String email, String products,
			String shippingMethod, String payment, String shippingAddress, String billingAddress, String url,
			String orderNumToBeClicked) throws Exception {
		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("ordersdetails" + getBrowserName()));
		setTestCaseReportName("ordersdetails");
		logCaseDetailds(MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc));

		LinkedHashMap<String, Object> userdetails = (LinkedHashMap<String, Object>) users.get(email);
		Testlogs.get().debug(email);
		LinkedHashMap<String, Object> deliveryaddressDetails = (LinkedHashMap<String, Object>) addresses
				.get(shippingAddress);
		LinkedHashMap<String, Object> paymentDetails = (LinkedHashMap<String, Object>) paymentCards.get(payment);
		LinkedHashMap<String, Object> billAddressDetails = (LinkedHashMap<String, Object>) addresses
				.get(billingAddress);

		getDriver().get(
				"file:///C:/Users/Brain/Downloads/Order%20Details%20page/Order%20Details%20page/Order%20History.html");

		try {

			String OrderNumber = OrderHistory.getOrderNumber();
			String OrderStatus = OrderHistory.getOrderStatus();
			String OrderTotal = OrderHistory.getOrderTotal();

			// Click on first order on order history page
			// OrderHistory.clickOrder(); instead use this
			getDriver().get(
					"file:///C:/Users/Brain/Downloads/Order%20Details%20page/Order%20Details%20page/Order%20History%20-%20Order%20Details%20%20%20TommyBahama.com.html");

			String DetailsOrderNumber = OrderDetails.getOrderNumber();
			String DetailsOrderStatus = OrderDetails.getOrderStatus();
			String DetailsOrderTotal = OrderDetails.getOrderTotal();

			sassert().assertEquals(OrderNumber, DetailsOrderNumber, "<br><font color=#f442cb>order numbers are not equal</font>");
			sassert().assertEquals(OrderStatus, DetailsOrderStatus, "<br><font color=#f442cb>status is not the same</font>");
			sassert().assertEquals(OrderTotal, DetailsOrderTotal, "<br><font color=#f442cb>the totals are not equal</font>");

			// get Delivery address details and split String[] Deliveydetails =
			String[] Deliveydetails = OrderDetails.getDeliveryAddrerssDetails().split("\n");

			String Dname = Deliveydetails[1].trim();
			String DadddressLine = Deliveydetails[2].trim();
			String DCity = Deliveydetails[3].trim();
			String Dcountry = Deliveydetails[4].trim();
			String Dpostal = Deliveydetails[5].trim();

			sassert().assertTrue(
					Dname.contains((String) deliveryaddressDetails.get(CheckOut.shippingAddress.keys.firstName) + " "
							+ deliveryaddressDetails.get(CheckOut.shippingAddress.keys.lastName)),
					"<br><font color=#f442cb>delivery:the names are not the same</font>");

			sassert().assertTrue(DadddressLine.trim().contains(
					((String) deliveryaddressDetails.get(CheckOut.shippingAddress.keys.adddressLine)).trim()));
			sassert().assertTrue(
					DCity.contains((String) deliveryaddressDetails.get(CheckOut.shippingAddress.keys.city)),
					"<br><font color=#f442cb>Address line of delivery do not match</font>");
			sassert().assertTrue(
					Dcountry.equalsIgnoreCase(
							(String) deliveryaddressDetails.get(CheckOut.shippingAddress.keys.countery)),
					"<br><font color=#f442cb>delivery:not the same contry</font>");
			sassert().assertEquals(Dpostal, (String) deliveryaddressDetails.get(CheckOut.shippingAddress.keys.postal),
					"<br><font color=#f442cb>delivery:not the same postal</font>");

			// get Delivery options details and split
			String[] DeliveyOptions = OrderDetails.getDeliveryOptions().split("\n");
			String DOption = DeliveyOptions[1].trim(); // to map the shipping method name with its "name"
			// this should be a func or a // hashmap
			if (shippingMethod.contains("FDXGROUND"))
				sassert().assertTrue(DOption.contains("Fed Ex Ground"));
			else if (shippingMethod.equals("")) {

				// .........

			}

			// get Payment Detail Billing address details and split
			String[] Billingdetails = OrderDetails.getBillingAddrerssDetails().split("\n");
			String cardNumber = Billingdetails[1].trim();
			String card = Billingdetails[2].trim();
			String EXP = Billingdetails[3].trim();
			String amount = Billingdetails[4].trim();

			// check payment detail
			sassert().assertTrue(
					cardNumber.replace("*", "").equals(
							((String) paymentDetails.get(CheckOut.paymentInformation.keys.number)).substring(12)),
					"<br><font color=#f442cb>card number do not match</font>");
			sassert().assertTrue(card.toLowerCase().contains(payment),"<br><font color=#f442cb>Cards do not match</font>");

			sassert().assertTrue(
					EXP.contains((String) paymentDetails.get(CheckOut.paymentInformation.keys.expireMonth) + "/"
							+ paymentDetails.get(CheckOut.paymentInformation.keys.expireYear)),
					"<br><font color=#f442cb>expire date do not match</font>");

			sassert().assertEquals(amount, DetailsOrderTotal, "<br><font color=#f442cb>the totals are not the same</font>");

			// billing address check
			String Bname = Billingdetails[6];
			String BadddressLine = Billingdetails[7];
			String Bcity = Billingdetails[8];
			String Bcountry = Billingdetails[9];
			String Bpostal = Billingdetails[10];

			sassert().assertEquals(Bname,
					(String) billAddressDetails.get(CheckOut.shippingAddress.keys.firstName) + " "
							+ deliveryaddressDetails.get(CheckOut.shippingAddress.keys.lastName),
					"<br><font color=#f442cb>billing:the names are not the same</font>");

			sassert().assertTrue(
					BadddressLine.equalsIgnoreCase(
							(String) billAddressDetails.get(CheckOut.shippingAddress.keys.adddressLine)),
					"<br><font color=#f442cb>address line of billing do not match</font>");

			sassert().assertTrue(Bcity.toLowerCase()
					.contains(((String) billAddressDetails.get(CheckOut.shippingAddress.keys.city)).toLowerCase()));

			sassert().assertTrue(
					Bcountry.toLowerCase().contains(
							((String) billAddressDetails.get(CheckOut.shippingAddress.keys.countery)).toLowerCase()),
					"<br><font color=#f442cb>Billing: not the same country</font>");
			sassert().assertEquals(Bpostal, (String) billAddressDetails.get(CheckOut.shippingAddress.keys.postal),
					"<br><font color=#f442cb>billing:not the same postal</font>");

			// test log
			// logs.debug(DadddressLine + "..." + fat + "......" + Bcity + "......." +
			// Bcountry + "......" + Bpostal);

			int i = 0;
			LinkedHashMap<String, String> ItemDetails;

			for (String product : products.split("\n")) {

				ItemDetails = OrderDetails.getNthItemDetails(i++);
				Testlogs.get().debug(MessageFormat.format(LoggingMsg.TESTING_PRODUCT, product));
				productDetails = (LinkedHashMap<String, Object>) invintory.get(product);

				sassert().assertEquals((String) ItemDetails.get("id"), (String) productDetails.get("id"),
						"<br><font color=#f442cb>product id do not match in product: " + i+"</font>");
				sassert().assertEquals((String) ItemDetails.get("title"), (String) productDetails.get("title"),
						"<br><font color=#f442cb>product title do not match in product: " + i+"</font>");
				sassert().assertEquals((String) ItemDetails.get("color"), (String) productDetails.get("color"),
						"<br><font color=#f442cb>product color do not match in product: " + i+"</font>");
				sassert().assertEquals((String) ItemDetails.get("size"), (String) productDetails.get("size"),
						"<br><font color=#f442cb>product size do not match in product: " + i+"</font>");
				sassert().assertEquals((String) ItemDetails.get("qty"), (String) productDetails.get("qty"),
						"<br><font color=#f442cb>product qty do not match in product: " + i+"</font>");

				if (((String) productDetails.get("price")).contains("was"))
					sassert().assertEquals(ItemDetails.get("wasPrice"),
							((String) productDetails.get("price")).split("was")[1],
							"<br><font color=#f442cb>product was price do not match in product: " + i+"</font>");

				sassert().assertEquals(ItemDetails.get("price"), ((String) productDetails.get("price")).split("was")[0],
						"<br><font color=#f442cb>product price do not match in product: " + i+"</font>");

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
