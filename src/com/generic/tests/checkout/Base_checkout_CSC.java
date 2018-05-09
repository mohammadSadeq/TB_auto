package com.generic.tests.checkout;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.util.LinkedHashMap;

import com.generic.page.CSC;
import com.generic.page.CheckOut;
import com.generic.page.PDP;
import com.generic.page.Registration;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.TestUtilities;
import com.generic.util.dataProviderUtils;
import com.generic.util.RandomUtilities;
import com.generic.util.ReportUtil;
import com.generic.util.SASLogger;

public class Base_checkout_CSC extends SelTestCase {

	private static LinkedHashMap<String, Object> addresses = null ;
	private static  LinkedHashMap<String, Object> invintory = null ;
	private static  LinkedHashMap<String, Object> paymentCards = null;
	private static  LinkedHashMap<String, Object> users =null ;

	// user types
	public static final String guestUser = "guest";
	public static final String freshUser = "fresh";
	public static final String loggedInUser = "loggedin";
	public static final String loggedDuringChcOt = "logging During Checkout";

	// used sheet in test
	public static final String testDataSheet = SheetVariables.CSCcheckoutSheet;

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
		//concurrency mentainance on sheet reading 
		getBrowserWait(testObject.getParameter("browserName"));
		
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Orders")
	public void checkOutBaseTest(String caseId, String runTest, String desc, String proprties, String products,
			String shippingMethod, String payment, String shippingAddress, String billingAddress, String coupon,
			String email) throws Exception {
		//Important to add this for logging/reporting 
		Testlogs.set(new SASLogger("checkout_"+getBrowserName()));
		setTestCaseReportName("Checkout Case");
		logCaseDetailds(MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), payment, shippingMethod));
		
		String Pemail;
		String orderTotal;
		String orderSubtotal;
		String orderTax;
		String orderShipping;
		String orderConfirmationOrderId;
		String orderConfirmationDeliveryAddress;
		String orderConfirmationDeliveryMethod;
		String orderConfirmationPaymentMethod;
		String orderConfirmationBillingAddress;
		
		Pemail = getSubMailAccount(email);
		
		try {
			getDriver().get("https://qa-csc.tbahama.com/ytbcscockpit/index.zul");
			Thread.sleep(2000);
			CSC.logIn("etabib", "passw0rd");
			
			if (proprties.contains(loggedInUser)) {
				//you need to maintain the concurrency and get the main account information and log in in browser account 
				LinkedHashMap<String, Object> userdetails = (LinkedHashMap<String, Object>) users.get(email);
				Testlogs.get().debug(Pemail);
				Testlogs.get().debug((String) userdetails.get(Registration.keys.password) );
			//	getDriver().get("https://10.30.50.17:9002/en/login");
				CSC.selectCustomer(Pemail);
			}
			
//			if (proprties.contains(freshUser)) {
//				Pemail = RandomUtilities.getRandomEmail();
//
//				// take any user as template
//				LinkedHashMap<String, Object> userdetails = (LinkedHashMap<String, Object>) users.entrySet().iterator()
//						.next().getValue();
//
//				Registration.fillAndClickRegister(Pemail, Pemail, (String) userdetails.get(Registration.keys.firstName), (String) userdetails.get(Registration.keys.lastName),
//						(String) userdetails.get(Registration.keys.country), (String) userdetails.get(Registration.keys.postalCode), (String) userdetails.get(Registration.keys.password),
//						(String) userdetails.get(Registration.keys.password), true);
//			}

			for (String product : products.split("\n")) {
				Testlogs.get().debug(MessageFormat.format(LoggingMsg.ADDING_PRODUCT, product));
				LinkedHashMap<String, Object> productDetails = (LinkedHashMap<String, Object>) invintory.get(product);
				CSC.addProductsToCartAndClickCheckOut((String) productDetails.get(PDP.keys.id), (String) productDetails.get(PDP.keys.size),
						(String) productDetails.get(PDP.keys.qty));
			}

			// flow to support coupon validation
//			if (!"".equals(coupon)) {
//				CSC.applyCoupon(coupon);
//				if (coupon.contains(CSC.keys.invalidCoupon)) {
//					CSC.validateCoupon();
//				}
//			}
			//Cart.getNumberOfproducts();
//			orderSubtotal = Cart.getOrderSubTotal();
//			orderTax = Cart.getOrderTotal();


		//	getDriver().get("https://10.30.50.17:9002/en/cart/checkout");

			if (proprties.contains(guestUser)) {
				Pemail = RandomUtilities.getRandomEmail();
				CSC.fillAndClickCreate(Pemail);
			}

			Thread.sleep(1000);
			// Validate the order sub total in shipping address form section
//			sassert().assertEquals(CheckOut.shippingAddress.getOrdersubTotal(), orderSubtotal);

			// checkout- shipping address
			LinkedHashMap<String, Object> addressDetails = (LinkedHashMap<String, Object>) addresses
					.get(shippingAddress);
			
			if (proprties.contains(CSC.keys.isSavedShipping) && !proprties.contains(freshUser)
					&& !proprties.contains(guestUser)) {
				//CheckOut.shippingAddress.fillAndClickNext(true);
				CSC.selectDeliveryAddress("emad tabib");
				Thread.sleep(1000);
			} else {
			
				// in case guest the save shipping check-box is not exist
					CSC.addNewShippingAddress(
							(String) addressDetails.get(CSC.keys.firstName),
							(String) addressDetails.get(CSC.keys.lastName),
							(String) addressDetails.get(CSC.keys.adddressLine),
							(String) addressDetails.get(CSC.keys.city),
							(String) addressDetails.get(CSC.keys.state),
							(String) addressDetails.get(CSC.keys.postal),
							(String) addressDetails.get(CSC.keys.phone));
			}

		
			// Shipping method
			
			CSC.selectDeliveryMode(shippingMethod);
			
			// Validate the order sub total in shipping method section
//			sassert().assertEquals(CheckOut.shippingMethod.getOrderSubTotal(), orderSubtotal);
//			orderShipping = CheckOut.shippingMethod.getOrderShipping();
//			orderTax = CheckOut.shippingMethod.getOrderTax();
//			orderTotal = CheckOut.shippingMethod.getOrderTotal();
//			CheckOut.shippingMethod.clickNext();
//			
//			// Validate the order sub total in billing form section
//			sassert().assertEquals(CheckOut.paymentInnformation.getOrderSubTotal(), orderSubtotal);
//			sassert().assertEquals(CheckOut.paymentInnformation.getOrdershipping(), orderShipping);
//			sassert().assertEquals(CheckOut.paymentInnformation.getOrderTax(), orderTax);
//			sassert().assertEquals(CheckOut.paymentInnformation.getOrderTotal(), orderTotal);
			// checkout- payment
			
			LinkedHashMap<String, Object> paymentDetails = (LinkedHashMap<String, Object>) paymentCards
					.get(payment);
			
			if (proprties.contains(CSC.keys.isSavedPayement) && !proprties.contains(freshUser)
					&& !proprties.contains(guestUser)) {
				
				CSC.typeCV((String) paymentDetails.get(CSC.keys.CVCC));				
				
			} else {

				// do not save address if scenario is guest user
	
//				LinkedHashMap<String, Object> paymentDetails = (LinkedHashMap<String, Object>) paymentCards
//						.get(payment);
				LinkedHashMap<String, Object> billAddressDetails = (LinkedHashMap<String, Object>) addresses
						.get(billingAddress);

					CSC.addPaymentInnformation(
							(String) paymentDetails.get(CSC.keys.name),
							(String) paymentDetails.get(CSC.keys.number),
							(String) paymentDetails.get(CSC.keys.expireMonth),
							(String) paymentDetails.get(CSC.keys.expireYear),
							(String) paymentDetails.get(CSC.keys.CVCC),
							billingAddress.equalsIgnoreCase(shippingAddress),
							(String) billAddressDetails.get(CSC.keys.firstName),
							(String) billAddressDetails.get(CSC.keys.lastName),
							(String) billAddressDetails.get(CSC.keys.adddressLine),
							(String) billAddressDetails.get(CSC.keys.countery),
							(String) billAddressDetails.get(CSC.keys.city),
							(String) billAddressDetails.get(CSC.keys.state),
							(String) billAddressDetails.get(CSC.keys.postal));

			}
			//Waiting payment to be processed
			if(getBrowserName().equals("firefox"))
			Thread.sleep(1000);
			
			// Validate the order sub-total in order review section
//			sassert().assertEquals(CheckOut.reviewInformation.getSubtotal(), orderSubtotal);
//			sassert().assertEquals(CheckOut.reviewInformation.shippingCost(), orderShipping);
//			sassert().assertEquals(CheckOut.reviewInformation.getOrderTax(), orderTax);
//			sassert().assertEquals(CheckOut.reviewInformation.getOrderTotal(), orderTotal);
			
//			CheckOut.reviewInformation.acceptTerms(true);
			CSC.clickPlaceOrder();

			// Validate the order sub total in order review section
//			sassert().assertEquals(CheckOut.orderConfirmation.getSubTotal(), orderSubtotal);
//			sassert().assertEquals(CheckOut.orderConfirmation.getShippingCost(), orderShipping);
//			sassert().assertEquals(CheckOut.orderConfirmation.getOrderTax(), orderTax);
//			sassert().assertEquals(CheckOut.orderConfirmation.getOrderTotal(), orderTotal);
//			
//			orderTotal = CheckOut.orderConfirmation.getOrderTotal();
//			orderShipping = CheckOut.orderConfirmation.getShippingCost();
//			orderConfirmationOrderId = CheckOut.orderConfirmation.getOrderId();
//			orderConfirmationDeliveryAddress = CheckOut.orderConfirmation.getShippingAddrerss();
//			orderConfirmationDeliveryMethod = CheckOut.orderConfirmation.getDeliveryMethod();
//			orderConfirmationPaymentMethod = CheckOut.orderConfirmation.getPaymentMethod();
//			orderConfirmationBillingAddress = CheckOut.orderConfirmation.getBillingAddrerss();
	    	// TODO: compare addresses

//			Testlogs.get().debug(MessageFormat.format(LoggingMsg.CHECKOUT_RESULT , Pemail,orderConfirmationOrderId,orderTotal,orderSubtotal, orderTax, orderShipping));
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
