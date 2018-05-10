package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.generic.selector.CSCSelectors;
import com.generic.selector.CheckOutSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class CSC extends SelTestCase {
	
	public static class keys {
		public static final String caseId = "caseId";
		public static final String userName = "userName";
		public static final String password = "password";
		public static final String email = "mail";
		public static final String invalidCoupon = "invalid";
		public static final String isSavedShipping = "saved-shipping";
		public static final String countery = "countery";
		public static final String state = "state";
		public static final String lastName = "lastName";
		public static final String firstName = "firstName";
		public static final String adddressLine = "adddressLine";
		public static final String city = "city";
		public static final String postal = "postal";
		public static final String phone = "phone";
		public static final String isSavedPayement = "saved-payment";
		public static final String name = "name";
		public static final String number = "number";
		public static final String expireYear = "expireYear";
		public static final String expireMonth = "expireMonth";
		public static final String CVCC = "CVCC";
	}
	
	
	public static void logIn(String userName, String Password) throws Exception {
		getCurrentFunctionName(true);
		typeUsername(userName);
		typePassword(Password);
		clickLogin();
		Thread.sleep(1000);
//		if(!checkUserAccount())
//		{
//			throw new Exception("Login failed");
//		}
		getCurrentFunctionName(false);
	}

	public static void clickLogin2() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.loginBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);

	}
	
	public static void clickLogin() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.loginBtn);
		SelectorUtil.clickButton(subStrArr);
		getCurrentFunctionName(false);
	}

	public static void typePassword(String password) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.password);
		valuesArr.add(password);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static void typeUsername(String userName) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.userName);
		valuesArr.add(userName);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void selectCustomer(String email) throws Exception {
		getCurrentFunctionName(true);
		clickFindCustomerBtn();
		Thread.sleep(5000);
		typeCustomerEmail(email);
		clickCustomersSearchBtn();
		clickCustomersSelectBtn();
		getCurrentFunctionName(false);
	}
	public static void clickFindCustomerBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.findCustomer);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
	//	SelectorUtil.clickButton(subStrArr);
		getCurrentFunctionName(false);
	}
	
	public static void typeCustomerEmail(String userName) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.searchForCustomersEmail);
		valuesArr.add(userName);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCustomersSearchBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.searchForCustomersSearch);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCustomersSelectBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.searchForCustomersSelect);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCartTab() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCart);
		valuesArr.add("index,1");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void addProductsToCartAndClickCheckOut(String searchText,String itemSize, String itemQty) throws Exception {
		getCurrentFunctionName(true);
		typeSearchText(searchText);
		clickCartSearchBtn();
		selectSize(itemSize);
		selectQty(itemQty);
		clickAddToCartBtn();
		clickCheckoutBtn();
		getCurrentFunctionName(false);
	}
	
	
	public static void typeSearchText(String searchText) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCartSearchBox);
		valuesArr.add(searchText);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCartSearchBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCartSearchBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void selectSize(String itemSize) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "itemSize ", itemSize));
		subStrArr.add(CSCSelectors.CSCCart_SelectColor);
		valuesArr.add(itemSize);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void selectQty(String itemQty) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "itemQty ", itemQty));
		subStrArr.add(CSCSelectors.CSCCart_SelectQty);
		valuesArr.add(itemQty);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickAddToCartBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCart_AddToCart);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCheckoutBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCart_CheckoutBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void typeGuestEmail(String email) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCart_GuestEmail);
		valuesArr.add(email);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickCreateBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCart_GuestCreateBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void selectDeliveryAddress(String deliveryAddress) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "deliveryAddress ", deliveryAddress));
		subStrArr.add(CSCSelectors.CSCCheckout_DeliveryAddress);
		valuesArr.add(deliveryAddress);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void selectDeliveryMode(String deliveryMode) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "deliveryMode ", deliveryMode));
		subStrArr.add(CSCSelectors.CSCCheckout_DeliveryMode);
		valuesArr.add(deliveryMode);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void pickFirstpaymentsaved(String cv) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCheckout_CV);
		valuesArr.add(cv);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void typeCV(String cv) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCheckout_CV);
		valuesArr.add(cv);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickUseThisCard() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCheckout_UseThisCard);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void clickPlaceOrder() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCheckout_PlaceOrder);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
	
	public static void useSuggestedAddress() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(CSCSelectors.CSCCheckout_ContinueCheckoutButton);
		valuesArr.add("");
		try {
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		} catch (Exception e) {
			logs.debug("Address suggest modal is not displayed");
		}
	}

	public static void addNewShippingAddress(String string, String string2, String string3, String string4,
			String string5, String string6, String string7) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public static void addPaymentInnformation(String string, String string2, String string3, String string4,
			String string5, boolean equalsIgnoreCase, String string6, String string7, String string8, String string9,
			String string10, String string11, String string12) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public static void fillAndClickCreate(String pemail) throws Exception{
		typeGuestEmail(pemail);
		clickCreateBtn();
	}
	
//	public static boolean checkUserAccount() throws Exception {
//		getCurrentFunctionName(true);
//		boolean LoggedUser = true;
//		try {
//
//			List<String> subStrArr = new ArrayList<String>();
//			List<String> valuesArr = new ArrayList<String>();
//			subStrArr.add(SignInSelectors.WelcomeMsg);
//			valuesArr.add("getCurrentValue");
//			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
//		} catch (Exception e) {
//			LoggedUser = false;
//		}
//		getCurrentFunctionName(false);
//		return LoggedUser;
//	}

}
