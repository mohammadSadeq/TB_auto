package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.generic.selector.CartSelectors;
import com.generic.selector.CheckOutSelectors;
import com.generic.selector.OrderDetailsSelector;
import com.generic.selector.OrderHistorySelector;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class OrderDetails extends SelTestCase {

	public static class keys {
		public static final String caseId = "caseId";

	}

	public static String getOrderNumber() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.orderdetails);
		getCurrentFunctionName(false);
		String ordersNum = SelectorUtil.getText(subStrArr);
		return ordersNum;

	}

	public static String getOrderStatus() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.orderdetails);
		getCurrentFunctionName(false);
		return SelectorUtil.getTextOfItemNumber(subStrArr, 2);

	}

	public static String getOrderDatePlaced() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.datePlaced);
		valuesArr.add("index,2");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();

	}

	public static String getOrderTotal() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.orderTotal);
		getCurrentFunctionName(false);
		return SelectorUtil.getTextOfItemNumber(subStrArr, 6);
	}

	public static String clickCancelOrderBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.cancelOrderButton);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(SelectorUtil.textValue.get());
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}

	public static boolean vifyCancelOrderBtnIsNotDisplayed() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.cancelOrderButton);
		boolean isNotDiplayed = SelectorUtil.isNotDisplayed(subStrArr);
		logs.debug("cancelOrderButton check result is " + isNotDiplayed);
		getCurrentFunctionName(false);
		return isNotDiplayed;
	}

	public static boolean vifyCancelOrderBtnIsDisplayed() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.cancelOrderButton);

		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("cancel Order Button check result is " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static String clickReturnOrderBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.returnOrderButton);
		valuesArr.add("noClick");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();

	}

	public static boolean vifyReturnOrderBtnIsNotDisplayed() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.returnOrderButton);
		boolean isNotDiplayed = SelectorUtil.isNotDisplayed(subStrArr);
		logs.debug("return Order Button check result is " + isNotDiplayed);
		getCurrentFunctionName(false);
		return isNotDiplayed;
	}

	public static boolean vifyReturnOrderBtnIsDisplayed() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.returnOrderButton);

		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("return Order Button check result is " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static class itemsTable {

		public static boolean checkItemImage() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemImages);

			boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			logs.debug("images check result is " + isDisplayed);
			getCurrentFunctionName(false);
			return isDisplayed;
		}

		public static boolean checkProductLink(String PLink) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemLink);
			String attrValue = SelectorUtil.getAttr(subStrArr, "href");
			logs.debug("links check result is: " + attrValue);
			logs.debug("links is: " + PLink);
			getCurrentFunctionName(false);
			return PLink.contains(attrValue);
		}

		public static String getItemPrice() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemPrice);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		}

		public static boolean checkProductQty(String PQty) throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemQty);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			String actualQty = SelectorUtil.textValue.get();
			logs.debug("Qty check result is: " + actualQty);
			logs.debug("Expected Qty is: " + PQty);
			getCurrentFunctionName(false);
			return PQty.contains(actualQty);
		}

		public static String getItemQty() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemQty);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		}

		public static String getItemTotalPrice() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.itemTotalPrice);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		}
	}

	public static class orderSumary {

		public static String getOrderSubtotal() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.OrderSumaryOrderSubtotal);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		}

		public static String getOrderTotal() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.OrderSumaryOrderTotal);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		}

		public static String getOrderTax() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.OrderSumaryOrderTax);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug("Order tax: " + SelectorUtil.textValue.get());
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}

		public static String getShippingCost() throws Exception {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			List<String> valuesArr = new ArrayList<String>();
			subStrArr.add(OrderDetailsSelector.OrderSumaryShippingCost);
			valuesArr.add("");
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();

		}
	}

	public static String getBillingAddrerssDetails() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.BillingAddress);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();

	}

	public static String getDeliveryAddrerssDetails() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.DeliveryAddress);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}
	public static String getAccountPaymentDetails() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.PaymentDetails);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}

	public static String getDeliveryOptions() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.DeliveryOptions);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}

	public static String getPaymentDetails() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.PaymentDetails);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}

	public static LinkedHashMap<String, String> getNthItemDetails(int i) throws Exception {

		getCurrentFunctionName(true);
		String details = "";
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(OrderDetailsSelector.itemDetails);
		valuesArr.add("index," + i);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		subStrArr.add(OrderDetailsSelector.itemNumbers);
		valuesArr.add("index," + i);
		details = details + SelectorUtil.textValue.get() + "\n";
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, SelectorUtil.textValue.get()));
		getCurrentFunctionName(false);
		details = "\n" + details + SelectorUtil.textValue.get();

		return splitItemDetails(details);
	}

	public static LinkedHashMap<String, String> splitItemDetails(String details) {

		LinkedHashMap<String, String> Details = new LinkedHashMap<>();

		String[] SplitDetails = details.split("\n");
		Details.put("title", SplitDetails[1]);
		Details.put("id", SplitDetails[3].split("-")[0]);
		Details.put("color", SplitDetails[7]);
		Details.put("size", SplitDetails[5]);
		if (SplitDetails[8].split(" ").length > 2) {
			Details.put("price", SplitDetails[8].split(" ")[0]);
			Details.put("qty", SplitDetails[8].split(" ")[1]);
			Details.put("total", SplitDetails[8].split(" ")[2]);
		} else {
			Details.put("wasPrice", SplitDetails[8]);
			Details.put("price", SplitDetails[9].split(" ")[0]);
			Details.put("qty", SplitDetails[9].split(" ")[1]);
			Details.put("total", SplitDetails[9].split(" ")[2]);
		}
		return Details;
	}

}
