package com.generic.page;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.generic.selector.PDPSelectors;
import com.generic.selector.PLPSelectors;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PLP extends SelTestCase {

	public static class keys {
		public static final String caseId = "caseId";
	}

	public static int countProductsInPage() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		logs.debug("counting the products ");
		subStrArr.add(PLPSelectors.productLink);
		int itemsNumber = SelectorUtil.getAllElements(subStrArr).size();
		logs.debug("product count is :" + itemsNumber);
		getCurrentFunctionName(false);
		return itemsNumber;
	}

	public static void selectSortOptions(String sortOptions) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.sortOptions);
		valuesArr.add(sortOptions);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);

	}

	public static String getRating() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.GET_ELEMENT_BY_LOCATOR, PDPSelectors.ratingValue));
		subStrArr.add(PLPSelectors.productsRating);
		String dataRating = SelectorUtil.getAttr(subStrArr, "data-rating");
		logs.debug("data-rating is: " + dataRating);
		getCurrentFunctionName(false);
		return dataRating;
	}

	public static String getSelectedSort() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.GET_ELEMENT_BY_LOCATOR, PLPSelectors.sortOptions));
		subStrArr.add(PLPSelectors.sortOptions);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue.get();
	}

	public static boolean validateSorting(String sortType) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		if (sortType.contains("Price")) {
			logs.debug("verifiing the PLP pricing");
			subStrArr.add(PLPSelectors.productsPrices);
			String Price1 = SelectorUtil.getNthElement(subStrArr, 0).getText();
			String Price2 = SelectorUtil.getNthElement(subStrArr, 1).getText();
			String Price3 = SelectorUtil.getNthElement(subStrArr, 2).getText();
			logs.debug("Prices for first 3 products is " + Price1 + ", " + Price2 + ", " + Price3);

			double valuePrice1 = Double.parseDouble(Price1.trim().replace("$", ""));
			double valuePrice2 = Double.parseDouble(Price2.trim().replace("$", ""));
			double valuePrice3 = Double.parseDouble(Price3.trim().replace("$", ""));

			getCurrentFunctionName(false);
			if (sortType.contains("Low-High"))
				return ((valuePrice1 <= valuePrice2) && (valuePrice2 <= valuePrice3));
			else
				return ((valuePrice1 >= valuePrice2) && (valuePrice2 >= valuePrice3));
		}
		if (sortType.contains("Rating")) {
			subStrArr.add(PLPSelectors.productsRating);
			String Rate1 = SelectorUtil.getAttr(subStrArr, "alt", 0).split(" ")[2].replaceAll("_", ".");
			String Rate2 = SelectorUtil.getAttr(subStrArr, "alt", 1).split(" ")[2].replaceAll("_", ".");
			String Rate3 = SelectorUtil.getAttr(subStrArr, "alt", 2).split(" ")[2].replaceAll("_", ".");
			logs.debug("Rating for first 3 products is " + Rate1 + ", " + Rate2 + ", " + Rate3);

			double valueRate1 = Double.parseDouble(Rate1);
			double valueRate2 = Double.parseDouble(Rate2);
			double valueRate3 = Double.parseDouble(Rate3);

			getCurrentFunctionName(false);
			if (sortType.contains("Low-High"))
				return ((valueRate1 <= valueRate2) && (valueRate2 <= valueRate3));
			else
				return ((valueRate1 >= valueRate2) && (valueRate2 >= valueRate3));
		} else {
//			subStrArr.add(PLPSelectors.productLink);
//			String Product1 = SelectorUtil.getAttr(subStrArr, "onclick", 0);
//			return Product1.contains("new");
			logs.debug("Expected sorting is:" + sortType);
			logs.debug("Acual sorting is:" + getSelectedSort());
			return getSelectedSort().contains(sortType);
		}
	}

	public static boolean sortAndValidate(String sortType) throws Exception {
		getCurrentFunctionName(true);
		logs.debug("Sorting: " + sortType);

		selectSortOptions(sortType);

		boolean validation = validateSorting(sortType);

		getCurrentFunctionName(false);
		return validation;
	}

	public static void clickGridView() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.gridView));
		subStrArr.add(PLPSelectors.gridView);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static void clickListView() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.listView));
		subStrArr.add(PLPSelectors.listView);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static void clickQuickshopBtn() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.quickShopBtn));
		subStrArr.add(PLPSelectors.quickShopBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean checkGridViewSelected() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.gridViewSelected);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Grid view is selected by default " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkListViewSelected() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.listViewSelected);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("List view is selected as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkGridViewProducts() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.gridViewProducts);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Products are displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkListViewProducts() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.listViewProducts);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Products are displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkListViewQuickshop() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.listViewQuickshop);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("list view Quickshop is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickListViewQuickshop() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.listViewQuickshop));
		subStrArr.add(PLPSelectors.listViewQuickshop);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean checkListViewProductTitle() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.listViewProductTitle);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Product Title is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkListViewProductPrice() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.listViewProductPrice);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Product price is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkGridViewQuickshop() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.gridViewQuickshop);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Grid view Quickshop is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickGridViewQuickshop() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.gridViewQuickshop));
		subStrArr.add(PLPSelectors.gridViewQuickshop);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean checkGridViewProductDes() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.gridViewProductDes);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Product Name is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkGridViewProductPrice() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.gridViewProductPrice);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Product price is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean checkQuickshopModalContent() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.quickshopModalContent);
		boolean isDisplayed = SelectorUtil.isDisplayed(subStrArr);
		logs.debug("Quickshop modal is displayed as expected " + isDisplayed);
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static boolean isStyleFilterAvailable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.sizeFilter);
		boolean isDisplayed = false;
		try {
			isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			logs.debug("Style filter is availabe for this category");
		} catch (NoSuchElementException e) {
			logs.debug("Style filter is not availabe for this category");
		}
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickFirstStyleFilter() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.sizeFilter));
		subStrArr.add(PLPSelectors.sizeFilter);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean isFitFilterAvailable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.fitFilter);
		boolean isDisplayed = false;
		try {
			isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			logs.debug("Fit filter is availabe for this category");
		} catch (NoSuchElementException e) {
			logs.debug("Fit filter is not availabe for this category");
		}
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickFirstFitFilter() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.fitFilter));
		subStrArr.add(PLPSelectors.fitFilter);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean isColorFilterAvailable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.colorFilter);
		boolean isDisplayed = false;
		try {
			isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			logs.debug("Color filter is availabe for this category");
		} catch (NoSuchElementException e) {
			logs.debug("Color filter is not availabe for this category");
		}
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickFirstColorFilter() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.colorFilter));
		subStrArr.add(PLPSelectors.colorFilter);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static boolean isSizeFilterAvailable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.sizeFilter);
		boolean isDisplayed = false;
		try {
			isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			logs.debug("Size filter is availabe for this category");
		} catch (NoSuchElementException e) {
			logs.debug("Size filter is not availabe for this category");
		}
		getCurrentFunctionName(false);
		return isDisplayed;
	}

	public static void clickFirstSizeFilter() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.sizeFilter));
		subStrArr.add(PLPSelectors.sizeFilter);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static void clickFirstPatternFilterIfAvaiable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.patternFilter));
		subStrArr.add(PLPSelectors.patternFilter);
		valuesArr.add("");
		try {
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug("Clicking first Pattern filter");
		} catch (NoSuchElementException e) {
			logs.debug("Pattern filter is not availabe for this category");
		}
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}

	public static void clickFirstCollectionFilterIfAvaiable() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.collectionFilter));
		subStrArr.add(PLPSelectors.collectionFilter);
		valuesArr.add("");
		try {
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
			logs.debug("Clicking first collection filter");
		} catch (NoSuchElementException e) {
			logs.debug("Collection filter is not availabe for this category");
		}
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
}
