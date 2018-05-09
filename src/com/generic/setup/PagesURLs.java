package com.generic.setup;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class PagesURLs extends SelTestCase {
//	public static String env = "env";
	public static String HP = "HomePage";
	public static String driversPath = "driversPath";
	public static String personalDetailsPage = "personalDetailsPage";
	public static String myAccountPage = "myAccountPage";
	public static String loginPage = "loginPage";
	public static String kioskPage = "kioskPage";
	public static String paymentDetailsPage = "paymentDetailsPage";
	public static String passwordPage = "passwordPage";
	public static String orderHistoryPage = "orderHistoryPage";
	public static String addressBookPage = "addressBookPage";
	public static String savedCartsPage = "savedCartsPage";
	public static String consentManagementPage = "consentManagementPage";
	public static String supportTicketsPage = "supportTicketsPage";
	public static String returnHistoryPage = "returnHistoryPage";
	public static String shoppingCartPage = "shoppingCartPage";
	public static String signOutPage = "signOutPage";
	public static String storeFinderPage = "storeFinderPage";
	public static String errorPage = "errorPage";
	public static String PLP = "PLP";
	public static String CLP = "CLP";
	
	public static String getDriversPath(String driverName) {
		try {
			String driverFolder = getCONFIG().getProperty(driversPath);
			String driverFullPath = "";
			if(driverFolder.endsWith("\\")) {
				driverFullPath = driverFolder + driverName + "Driver.exe";
			} else {
				driverFullPath = driverFolder + "\\" + driverName + "Driver.exe";
			}
		return driverFullPath;
		} catch(Throwable t) {
			throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, driversPath));
		}
	}
	public static void setDriversPath(String newDriversPath) {
		try {
			getCONFIG().setProperty(driversPath,newDriversPath);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, driversPath));
			}
	}
	public static String getLoginPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(loginPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, loginPage));
			}
	}
	public static void setLoginPage(String newLoginPage) {
		try {
			getCONFIG().setProperty(loginPage,newLoginPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, loginPage));
			}
	}
	public static String getKioskPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(kioskPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, kioskPage));
			}
	}
	public static void setKioskPage(String newKioskPage) {
		try {
			getCONFIG().setProperty(kioskPage,newKioskPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, kioskPage));
			}
	}
	public static String getMyAccountPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(myAccountPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, myAccountPage));
			}
	}
	public static void setMyAccountPage(String newMyAccountPage) {
		try {
			getCONFIG().setProperty(myAccountPage,newMyAccountPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, myAccountPage));
			}
	}
	public static String getOrderHistoryPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(orderHistoryPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, orderHistoryPage));
			}
	}
	public static void setOrderHistoryPage(String newOrderHistoryPage) {
		try {
			getCONFIG().setProperty(orderHistoryPage,newOrderHistoryPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, orderHistoryPage));
			}
	}
	public static String getReturnHistoryPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(returnHistoryPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, returnHistoryPage));
			}
	}
	public static void setReturnHistoryPage(String newReturnHistoryPage) {
		try {
			getCONFIG().setProperty(returnHistoryPage,newReturnHistoryPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, returnHistoryPage));
			}
	}
	public static String getShoppingCartPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(shoppingCartPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, shoppingCartPage));
			}
	}
	public static void setShoppingCartPage(String newShoppingCartPage) {
		try {
			getCONFIG().setProperty(shoppingCartPage,newShoppingCartPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, shoppingCartPage));
			}
	}
	public static String getSignOutPage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(signOutPage));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, signOutPage));
			}
	}
	public static void setSignOutPage(String newSignOutPage) {
		try {
			getCONFIG().setProperty(signOutPage,newSignOutPage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, signOutPage));
			}
	}
	public static String getPLP() {
		try {
			return selectEnvironment(getCONFIG().getProperty(PLP));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, PLP));
			}
	}
	public static void setPLP(String newPLP) {
		try {
			getCONFIG().setProperty(PLP,newPLP);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, PLP));
			}
	}
	public static String getHomePage() {
		try {
			return selectEnvironment(getCONFIG().getProperty(HP));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, HP));
			}
	}
	public static void setHomePage(String newHomePage) {
		try {
			getCONFIG().setProperty(HP,newHomePage);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, HP));
			}
	}
	public static String getCLP() {
		try {
			return selectEnvironment(getCONFIG().getProperty(CLP));
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, CLP));
			}
	}
	public static void setCLP(String newCLP) {
		try {
			getCONFIG().setProperty(CLP,newCLP);
			} catch(Throwable t) {
				throw new NoSuchElementException(MessageFormat.format(LoggingMsg.PROPERTY_ERROR_MSG, CLP));
			}
	}
	public static String selectEnvironment(String url) {
	        logs.debug("Current URL: " + url);
		    String env = getCONFIG().getProperty("testEnvironment").split("\\.")[0];
		    String currentenv = url.split("\\.")[0];
			String newURL = url.replaceAll(currentenv, env);
		    logs.debug("Expected URL: " + newURL);
			return newURL;
	}
}
