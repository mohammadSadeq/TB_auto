package com.generic.tests.checkout;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.util.LinkedHashMap;

import com.generic.page.PDP;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.EnvoyCheckOut;
import com.generic.page.HomePage;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.dataProviderUtils;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

public class Base_EnvoyCheckout extends SelTestCase {

	private static LinkedHashMap<String, Object> addresses = null ;
	private static  LinkedHashMap<String, Object> invintory = null ;
	private static  LinkedHashMap<String, Object> paymentCards = null;
	private static  LinkedHashMap<String, Object> users =null ;
	String expireDate = "06 / 22";
	// used sheet in test
	public static final String testDataSheet = SheetVariables.envoyCheckoutSheet;

	private static XmlTest testObject;
	
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>() ; 
	
	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger("checkout_setup"));
		testObject = test;
		addresses = Common.readAddresses();
		invintory = Common.readLocalInventory();
		paymentCards = Common.readPaymentcards();
		users = Common.readUsers();
	}

	@DataProvider(name = "Orders", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		getBrowserWait(testObject.getParameter("browserName"));	
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Orders")
	public void checkOutUSBaseTest(String caseId, String runTest, String desc, String proprties, String products,
			String shippingMethod, String payment, String shippingAddress, String billingAddress,
			String email) throws Exception {
		//Important to add this for logging/reporting 
		Testlogs.set(new SASLogger("checkout_"+getBrowserName()));
		setTestCaseReportName("Checkout Case");
		logCaseDetailds(MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), payment, shippingMethod));
		LinkedHashMap<String, Object> addressDetails = (LinkedHashMap<String, Object>) addresses
				.get(shippingAddress);	
		String Pemail;
		String cartID;
		String orderTotal;
		String orderSubtotal;
		String country = (String) addressDetails.get(CheckOut.shippingAddress.keys.countery);
		Pemail = getSubMailAccount(email);
		
		try {
			HomePage.changeCountry(country);
			
			for (String product : products.split("\n")) {
				Testlogs.get().debug(MessageFormat.format(LoggingMsg.ADDING_PRODUCT, product));
				LinkedHashMap<String, Object> productDetails = (LinkedHashMap<String, Object>) invintory.get(product);
				PDP.addProductsToCartAndClickCheckOut((String) productDetails.get(PDP.keys.url),
						(String) productDetails.get(PDP.keys.color), (String) productDetails.get(PDP.keys.size),
						(String) productDetails.get(PDP.keys.qty));
			}

			//Cart.getNumberOfproducts();
			orderSubtotal = Cart.getOrderSubTotal();
			orderTotal = Cart.getOrderTotal();
			cartID = Cart.getCartId();
			Testlogs.get().debug("Cart ID: " + cartID);
			Cart.clickCheckout();
			Thread.sleep(6000);
			// checkout- shipping address	
				EnvoyCheckOut.shippingAddress.fillAndClickNext(
						Pemail,
						(String) addressDetails.get(CheckOut.shippingAddress.keys.firstName),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.lastName),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.adddressLine),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.city),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.state),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.postal),
						(String) addressDetails.get(CheckOut.shippingAddress.keys.phone), "");
	//			EnvoyCheckOut.deliveryMethod.selectDHLExpressMethod("");
				EnvoyCheckOut.deliveryMethod.clickContinue();
				
				LinkedHashMap<String, Object> billAddressDetails = (LinkedHashMap<String, Object>) addresses
						.get(billingAddress);
				LinkedHashMap<String, Object> paymentDetails = (LinkedHashMap<String, Object>) paymentCards
						.get(payment);
				
				EnvoyCheckOut.payment.fillAndclickNext(
						billingAddress.equalsIgnoreCase(shippingAddress),
						Pemail,
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.firstName),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.lastName),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.adddressLine),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.postal),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.country),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.state),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.city),
						(String) billAddressDetails.get(EnvoyCheckOut.shippingAddress.keys.phone),
						(String) paymentDetails.get(CheckOut.paymentInformation.keys.number),
						expireDate,
						(String) paymentDetails.get(CheckOut.paymentInformation.keys.CVCC));
				String orderID = EnvoyCheckOut.orderDetails.getOrderID();
				Testlogs.get().debug("Order ID: " + orderID);
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
}// class
