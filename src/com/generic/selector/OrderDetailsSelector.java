package com.generic.selector;

public class OrderDetailsSelector {
	//public static final String orderId = "test_orderDetail_overviewOrderID_label_$ span:eq(1)";
	public static final String orderdetails = "css,.account-order-details>dl>dd";
	//public static final String orderStatus = "test_orderDetail_overviewOrderStatus_label_$";
	public static final String orderStatus = "css,.account-order-details>dl>dd";
//	public static final String datePlaced = "test_orderDetail_overviewStatusDate_label_$";
	public static final String datePlaced = "item-value";
	//public static final String orderTotal = "test_orderDetail_overviewOrderTotal_label_$";
	public static final String orderTotal = "css,.account-order-payment-details>dl>dd";
	public static final String cancelOrderButton = "cancelOrderButton";
	public static final String returnOrderButton = "returnOrderButton";
	
	public static final String itemlistHeader = "item__list--header";
	public static final String nthResponsiveItemslist = "item__list--item";
	
	public static final String itemPrice = "test_orderDetails_productItemPrice_label_$";
	public static final String itemQty = "qtyValue";
	public static final String itemTotalPrice = "test_orderDetails_productTotalPrice_label_$";
	public static final String itemImages = "css,li>div>div>a>img";
	public static final String itemLink = "css,li>div>div>a";
	public static final String itemDetails = "css,div.account-line-item-description > div.order-detail-item-desc > dl";
	public static final String itemNumbers = "account-line-item-numbers";
	
	public static final String DeliveryAddress = "account-delivery-address";
	public static final String BillingAddress = "account-payment-details";
	public static final String PaymentDetails = "account-order-payment-details";
	public static final String DeliveryOptions = "account-delivery-method";
	
	public static final String OrderSumaryOrderTotal = "test_orderTotal_totalPrice_label_$";
	public static final String OrderSumaryOrderTax = "test_orderTotal_includesTax_label_$";
	public static final String OrderSumaryShippingCost = "test_orderTotal_devlieryCost_label_$";
	public static final String OrderSumaryOrderDiscount = "	test_orderTotal_discount_label_$";
	public static final String OrderSumaryOrderSubtotal = "test_orderTotal_subTotal_label_$";
	

}
