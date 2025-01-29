package Pharmacy_Management;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.RTVDeliveryChallanPage;

public class RTVDeliveryChallanTest extends BaseClass {
	@Test
	public void useraabletoRTVDeliveryChallan () throws Throwable{
		
		RTVDeliveryChallanPage RTVDeliveryChallanPage = new RTVDeliveryChallanPage(driver);
		String page = "rtv";
		String store = "DALVKOT PHARMA - (A UNIT OF DAlvkot Utility Enterprise pvt ltd)";
		String  name = "khair International";
		String returntype = "EXPIRED ITEMS";
		String remark = "Dalvkot";
		String item = "ADRIM 10MG INJECTION--107";
		String batch = "87220253AA";
		String returnQuantity = "3";
		
		
		RTVDeliveryChallanPage.clickonThehamberBtn(driver);
		RTVDeliveryChallanPage.enterThesearchForPageText(driver,page);
		RTVDeliveryChallanPage.clickOnTherTVDeliveryChallanText(driver);
		RTVDeliveryChallanPage.clickonThehamberBtn(driver);
		RTVDeliveryChallanPage.clickonTheaddBtnText(driver);
		RTVDeliveryChallanPage.clickonThestoreNameText(driver, store);
		RTVDeliveryChallanPage.clickOnthevendorNameText(driver, name);
		RTVDeliveryChallanPage.clickOnThereturnText(driver, returntype);
		RTVDeliveryChallanPage.enterTheremarkText(driver, remark);
		
		RTVDeliveryChallanPage.clickOnTheitemsdetailsText(driver, item);
		RTVDeliveryChallanPage.clickOnThebatchNumberText(driver, batch);
		RTVDeliveryChallanPage.enterthereturnQuantityText(driver, returnQuantity);
		RTVDeliveryChallanPage.clickOntheplusBtn(driver);
		RTVDeliveryChallanPage.clickOnThesubmitBtn(driver);
		RTVDeliveryChallanPage.closetheJaserReport(driver);
		RTVDeliveryChallanPage.clickOnTheokBtn(driver);
		RTVDeliveryChallanPage.clickOnThetableRTVChallanNumber(driver);
		RTVDeliveryChallanPage.closetheJaserReport(driver);


		
		
	}

}
