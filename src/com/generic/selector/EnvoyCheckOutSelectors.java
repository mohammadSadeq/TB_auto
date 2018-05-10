<<<<<<< HEAD
package com.generic.selector;

public class EnvoyCheckOutSelectors
{
	
	public static String envoyCheckoutURL = "borderFreeCheckoutURL";
	public static String internationalHomepage = "internationalHomepage";
	public static final String mainLogo = ".component-banner>a>img";
	public static final String sessionExpired = ".modal-header.ng-scope>h3";
	public static final String returnToShoppingCart = ".modal-footer.ng-scope>.btn.btn-primary.ng-binding";
	
	// Add New Address

	// Guest Checkout
	public static final String firstNameInput = "css,#shipping-first-name";
	public static final String lastNameInput = "css,#shipping-last-name";
	public static final String addressline1Input = "css,#shipping-address-line1";
	public static final String cityInput = "css,#shipping-city";
	public static final String regionInput = "css,#shipping-region";
	public static final String postalCode = "css,#shipping-postal-code";
	public static final String phoneNumbeInput = "css,#shipping-tel";
	public static final String emailInput = "iframeenvoy,#shipping-email";
	public static final String prepaidLabel = "css,#input-EXPRESS_DDP-prepaid";
	public static final String unpaidLabel = "css,#input-EXPRESS_DDP-unpaid";
	public static final String visaLogo = "css,#payment-method>div>label>img";
	public static final String masterCardLogo = "css,#payment-method>div>label>img";
	public static final String amexLogo = "css,#payment-method>div>label>img";
	public static final String paypalRadiButton = "payment-method-PAYPAL_PAYMENT";
	public static final String paypalLogo = "paypal-express-btn";
	public static final String continueButton = "css,#continue-btn-left";
	
	//Payment
	public static final String checkSame = "css,#same-billing-address";
	public static final String billingEmail = "css,#billing-email";
	public static final String billingFirstName = "css,#billing-first-name";
	public static final String billingLastName = "css,#billing-last-name";
	public static final String billingAddressLine1 = "css,#billing-address-line1";
	public static final String billingPostalCode = "css,#billing-postal-code";
	public static final String billingCountry = "css,#billing-country";
	public static final String billingState = "css,#billing-state";
	public static final String billingCity = "css,#billing-city";
	public static final String billingTel = "css,#billing-tel";
	public static final String creditCardNumberInput = "iframecc-frame,#cc-num";
	public static final String creditCardCVVInput = "css,#cc-sec-num";
	public static final String expiryDateInput = "css,#cc-exp-date";
	
	// PayPal Section
	public static final String paypalEmail = "email";
	public static final String paypalPassword = "password";
	public static final String paypalLogin = "btnLogin";
	public static final String paypalPayNow = "confirmButtonTop";
	
	public static final String placeOrder ="parentiframe,#submit-order-btn-right";
	public static final String orderID ="orderId";
	////////// Order Confirmation
	public static final String orderReviewHeader = "css,#review-page>header>div>div>h1";
	public static final String orderRevieSubmitButton = "submit-order-right-btn";
	public static final String orderConfirmationHeader = "css,#receipt-original>h1";
	public static final String orderConfirmationNumber = "order-num-temp";
	public static final String billing = "billing";
	
	
	public static final String shippingAddressSection = "shippingAddress";
	public static final String orderSummarytable = "css,.order-summary.ng-scope";
	public static final String shippingMethodsSection = "shipping-methods";
	public static final String billingSection = "billing";
	public static final String itemsSection = "items";

	
	
}
=======
package com.generic.selector;

public class EnvoyCheckOutSelectors
{
	
	public static String envoyCheckoutURL = "borderFreeCheckoutURL";
	public static String internationalHomepage = "internationalHomepage";
	public static final String mainLogo = ".component-banner>a>img";
	public static final String sessionExpired = ".modal-header.ng-scope>h3";
	public static final String returnToShoppingCart = ".modal-footer.ng-scope>.btn.btn-primary.ng-binding";
	
	// Add New Address

	// Guest Checkout
	public static final String firstNameInput = "css,#shipping-first-name";
	public static final String lastNameInput = "css,#shipping-last-name";
	public static final String addressline1Input = "css,#shipping-address-line1";
	public static final String cityInput = "css,#shipping-city";
	public static final String regionInput = "css,#shipping-region";
	public static final String postalCode = "css,#shipping-postal-code";
	public static final String phoneNumbeInput = "css,#shipping-tel";
	public static final String emailInput = "iframeenvoy,#shipping-email";
	public static final String prepaidLabel = "css,#input-EXPRESS_DDP-prepaid";
	public static final String unpaidLabel = "css,#input-EXPRESS_DDP-unpaid";
	public static final String visaLogo = "css,#payment-method>div>label>img";
	public static final String masterCardLogo = "css,#payment-method>div>label>img";
	public static final String amexLogo = "css,#payment-method>div>label>img";
	public static final String paypalRadiButton = "payment-method-PAYPAL_PAYMENT";
	public static final String paypalLogo = "paypal-express-btn";
	public static final String continueButton = "css,#continue-btn-left";
	
	//Payment
	public static final String checkSame = "css,#same-billing-address";
	public static final String billingEmail = "css,#billing-email";
	public static final String billingFirstName = "css,#billing-first-name";
	public static final String billingLastName = "css,#billing-last-name";
	public static final String billingAddressLine1 = "css,#billing-address-line1";
	public static final String billingPostalCode = "css,#billing-postal-code";
	public static final String billingCountry = "css,#billing-country";
	public static final String billingState = "css,#billing-state";
	public static final String billingCity = "css,#billing-city";
	public static final String billingTel = "css,#billing-tel";
	public static final String creditCardNumberInput = "iframecc-frame,#cc-num";
	public static final String creditCardCVVInput = "css,#cc-sec-num";
	public static final String expiryDateInput = "css,#cc-exp-date";
	
	// PayPal Section
	public static final String paypalEmail = "email";
	public static final String paypalPassword = "password";
	public static final String paypalLogin = "btnLogin";
	public static final String paypalPayNow = "confirmButtonTop";
	
	public static final String placeOrder ="parentiframe,#submit-order-btn-right";
	public static final String orderID ="orderId";
	public static final String totalSalePrice = "text-right ng-binding ng-scope";
	public static final String shippingCost  = "text-success ng-binding ng-scope";
	public static final String duties = "css,#duties>.text-right.ng-scope>span";
	public static final String taxes = "css,#taxes>.text-right.ng-scope>span";
	public static final String totalAmount = "css,.total-amount";
	
	////////// Order Confirmation
	public static final String orderReviewHeader = "css,#review-page>header>div>div>h1";
	public static final String orderRevieSubmitButton = "submit-order-right-btn";
	public static final String orderConfirmationHeader = "css,#receipt-original>h1";
	public static final String orderConfirmationNumber = "order-num-temp";
	public static final String billing = "billing";
	
	
	public static final String shippingAddressSection = "shippingAddress";
	public static final String orderSummarytable = "css,.order-summary.ng-scope";
	public static final String shippingMethodsSection = "shipping-methods";
	public static final String billingSection = "billing";
	public static final String itemsSection = "items";

	
	
}
>>>>>>> f023b3a0da90933cdd35577be79aafde1f84097e
