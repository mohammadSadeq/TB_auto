package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import com.generic.selector.EnvoyCheckOutSelectors;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class EnvoyCheckOut extends SelTestCase {

	public static class keys {
		public static final String caseId = "caseId";
	}

	public static class shippingAddress {
		public static class keys {
			public static final String firstName = "firstName";
			public static final String lastName = "lastName";
			public static final String adddressLine = "adddressLine";
			public static final String postal = "postal";
			public static final String country = "countery";
			public static final String state = "state";
			public static final String city = "city";
			public static final String phone = "phone";
		}

		public static void typeEmail(String email) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
		//	List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.emailInput);
	//		valuesArr.add(email);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Shipping Email", email));
			SelectorUtil.typeText(subStrArr, email);
			getCurrentFunctionName(false);
		}
		
		public static void typeFirstName(String firstName) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.firstNameInput);
			valuesArr.add(firstName);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "first name", firstName));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			}

		public static void typeLastName(String lastName) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.lastNameInput);
			valuesArr.add(lastName);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Last Name", lastName));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typeAddressline(String addressline1) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.addressline1Input);
			valuesArr.add(addressline1);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Address line1", addressline1));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typePostalCode(String postalCode) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.postalCode);
			valuesArr.add(postalCode);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "PostalCode", postalCode));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typeCity(String city) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.cityInput);
			valuesArr.add(city);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "City", city));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typeRegion(String region) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.regionInput);
			valuesArr.add(region);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Region", region));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typePhone(String phone) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.phoneNumbeInput);
			valuesArr.add(phone);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Phone", phone));
			SelectorUtil.typeText(subStrArr, phone);
			getCurrentFunctionName(false);
		}

		public static void fillAndClickNext(String email, String firstName, String lastName, String address,
				String city, String state, String postal, String phone, String iframeID) throws Exception {
			getCurrentFunctionName(true);

			if (!"".equals(email))
				typeEmail(email);
			Thread.sleep(3000);
			
			if (!"".equals(firstName))
				typeFirstName(firstName);
			Thread.sleep(3000);

			if (!"".equals(lastName))
				typeLastName(lastName);
			Thread.sleep(3000);

			if (!"".equals(address))
				typeAddressline(address);
			Thread.sleep(3000);

			if (!"".equals(postal))
				typePostalCode(postal);
			Thread.sleep(3000);

			if (!"".equals(city))
				typeCity(city);
			Thread.sleep(3000);

			if (!"".equals(state))
				typeRegion(state);
			Thread.sleep(3000);

			if (!"".equals(phone))
				typePhone(phone);
			
			getCurrentFunctionName(false);
		}
	}
	
	
	public static class deliveryMethod{
		
		public static void selectDHLExpressMethod() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.prepaidLabel);
			valuesArr.add("");
			logs.debug(MessageFormat.format(LoggingMsg.CLICK_ELEMENT_SEL, EnvoyCheckOutSelectors.prepaidLabel));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}
		
		public static void clickContinue() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.continueButton);
			valuesArr.add("");
			logs.debug(MessageFormat.format(LoggingMsg.CLICK_ELEMENT_SEL, EnvoyCheckOutSelectors.continueButton));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}
		
	}
	public static class payment{
		public static class keys {
			public static final String number = "number";
			public static final String expireDate = "expireDate";
			public static final String CVCC = "CVCC";
		}
		public static void fillAndclickNext(boolean billSameShip, String email,String firstName,
				String lastName, String address,String postal, String country, String state, String city,String phone, String cardNumber, String expDate,
				String CVC) throws Exception {
			getCurrentFunctionName(true);
			
			checkBillingAddressSameshipping(billSameShip);

			if (!billSameShip) {
				fillBillingAddress(email, firstName, lastName, address,postal, country, state, city,phone);
			}
			if (!"".equals(cardNumber))
				typeCardNumber(cardNumber);
			if (!"".equals(expDate))
				typeExpDate(expDate);
			if (!"".equals(CVC))
				typeSecNumber(CVC);
			orderDetails.clickPlaceOrder();
			Thread.sleep(1000);
			getCurrentFunctionName(false);
		}
		public static void fillBillingAddress(String email, String firstName, String lastName,
				String address, String postal, String country,String state,String city,String phone) throws Exception {
			getCurrentFunctionName(true);
			
			if (!"".equals(email))
				typeEmail(email);
			if (!"".equals(firstName))
				typeFirstName(firstName);
			if (!"".equals(lastName))
				typeLastName(lastName);
			if (!"".equals(address))
				typeAddress(address);
			if (!"".equals(country))
				selectCountery(country);
			if (!"".equals(postal))
				typePostalCode(postal);
			if (!"".equals(state))
				selectState(state);
			if (!"".equals(city))
				typeCity(city);
			if (!"".equals(phone))
				typePhone(phone);

			getCurrentFunctionName(false);
		}
		public static void typeEmail(String email) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "firstname ", email));
			subStrArr.add(EnvoyCheckOutSelectors.billingEmail);
			valuesArr.add(email);
			SelectorUtil.typeText(subStrArr, email);
			getCurrentFunctionName(false);

		}
		public static void selectCountery(String country) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "Country ", country));
			subStrArr.add(EnvoyCheckOutSelectors.billingCountry);
			valuesArr.add(country);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			Thread.sleep(1500);
			getCurrentFunctionName(false);

		}

		public static void selectState(String state) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE, "state ", state));
			subStrArr.add(EnvoyCheckOutSelectors.billingState);
			valuesArr.add(state);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}

		public static void typeFirstName(String firstName) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "firstname ", firstName));
			subStrArr.add(EnvoyCheckOutSelectors.billingFirstName);
			valuesArr.add(firstName);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}

		public static void typeAddress(String address) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "address ", address));
			subStrArr.add(EnvoyCheckOutSelectors.billingAddressLine1);
			valuesArr.add(address);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}

		public static void typeLastName(String lastName) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "lastname ", lastName));
			subStrArr.add(EnvoyCheckOutSelectors.billingLastName);
			valuesArr.add(lastName);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}

		public static void typeCity(String city) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "city ", city));
			subStrArr.add(EnvoyCheckOutSelectors.billingCity);
			valuesArr.add(city);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}

		public static void typePostalCode(String postal) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "postal", postal));
			subStrArr.add(EnvoyCheckOutSelectors.billingPostalCode);
			valuesArr.add(postal);
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}

		public static void typePhone(String phone) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "phone", phone));
			subStrArr.add(EnvoyCheckOutSelectors.billingTel);
			valuesArr.add(phone);
			SelectorUtil.typeText(subStrArr, phone);
			getCurrentFunctionName(false);

		}
		public static void checkBillingAddressSameshipping(boolean billSameShip) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.checkSame);
			valuesArr.add(String.valueOf(billSameShip));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);

		}
		public static void typeCardNumber(String cardNumber) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.creditCardNumberInput);
			valuesArr.add(cardNumber);
	//		SelectorUtil.switchToFrame("parentFrame");
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Card Number", cardNumber));
			SelectorUtil.typeText(subStrArr, cardNumber);
			getCurrentFunctionName(false);
		}
		
		public static void typeExpDate(String expDate) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.expiryDateInput);
			valuesArr.add(expDate);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Exp Date", expDate));
			SelectorUtil.typeText(subStrArr, expDate);
			getCurrentFunctionName(false);
		}
		
		public static void typeSecNumber(String secNumber) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.creditCardCVVInput);
			valuesArr.add(secNumber);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "Sec Number", secNumber));
			SelectorUtil.typeText(subStrArr, secNumber);
			getCurrentFunctionName(false);
		}
		
	}
	public static class orderDetails{
		
		public static void clickPlaceOrder() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.placeOrder);
			valuesArr.add("");
		//	SelectorUtil.returnHTMLDoc("parentframe");
	//		logs.debug(MessageFormat.format(LoggingMsg.CLICK_ELEMENT_SEL, EnvoyEnvoyCheckOutSelectors.continueButton));
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
		}
		
		public static String getOrderID() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.orderID);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
		
		public static String getTotalSalePrice() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.totalSalePrice);
			valuesArr.add("index,3");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
		
		public static String getShippingCost() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.shippingCost);
			valuesArr.add("index,3");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
		
		public static String getDuties() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.duties);
			valuesArr.add("index,3");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
		
		public static String getTaxes() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.taxes);
			valuesArr.add("index,3");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
		
		public static String getTotalAmount() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(EnvoyCheckOutSelectors.totalAmount);
			valuesArr.add("index,3");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}	
		
	}
}
