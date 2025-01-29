package Pharmacy_Management;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import ObjectRepository.PurchaseOrderPage;

public class PurchaseOrderTest extends BaseClass {
	@Test
	public void userAbleToVerifyThePurchaseOrderTest() {
		
		PurchaseOrderPage pp = new PurchaseOrderPage(driver);
		
	}

}
