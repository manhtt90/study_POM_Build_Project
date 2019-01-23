/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataProvider;

import org.testng.annotations.DataProvider;

/**
 *
 * @author manhtt
 */
public class productList_mobileGame {
    @DataProvider(name="productList_mobile")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
        	{"//*[contains(text(),'Võ Lâm Truyền Kỳ Mobile')]"},					// 1.ok        --	
        	//{"//*[contains(text(),'Kiáº¿m Tháº¿ Mobile')]"},						// 2.ok
        };
}
}
