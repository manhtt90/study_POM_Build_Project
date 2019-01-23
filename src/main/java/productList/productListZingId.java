package productList;

import org.testng.annotations.DataProvider;

public class productListZingId {
    @DataProvider(name="ProductList_zingId")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
        	{"//*[contains(text(),'Võ Lâm Truyền Kỳ Mobile')]"},					// 1.ok        --	
        	{"//*[contains(text(),'Kiếm Thế Mobile')]"},						// 2.ok
 /*       	{"https://pay.zing.vn/wplogin/mobile/ca3d"},					// 3.ok
        	{"https://pay.zing.vn/wplogin/mobile/cack"}, //6				// 4.ok, chon serverGroup, chon server, roi jump directly to payment page   --
        	{"https://pay.zing.vn/wplogin/mobile/tlbbm"}, //31				// 5.ok, chon serverGroup, serverName, roleId o payment page
        	{"https://pay.zing.vn/wplogin/mobile/kvm"}, //18				// 6.ok, chon serverGroup, serverName, roleId o payment page
        	{"https://pay.zing.vn/wplogin/mobile/nlmb"}, //24				// 7.ok, chon server, chon roleId
        	{"https://pay.zing.vn/wplogin/mobile/tsq"}, //32				// 8.ok, chon serverGroup, chon server, auto-select roleId, roi jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/dmz"}, //9					// 9.ok, khong chon server, jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/ptm"}, //27				// 10.ok, chon server, auto-select roleId	
        	{"https://pay.zing.vn/wplogin/mobile/omg"}, //26				// 11.ok, chon serverGroup, chon server, chon roleId
        	{"https://pay.zing.vn/wplogin/mobile/hpqt"}, //14				// 12.ok, chon server, auto-select roleId
        	//{"https://pay.zing.vn/wplogin/mobile/3qmobile"}, //3			// 13.game da dong, chon server, auto-select roleId
        	{"https://pay.zing.vn/wplogin/mobile/aum"}, //4					// 14.ok, khong chon server, jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/bbm"}, //5					// 15.ok, no server, auto-select roleId
        	{"https://pay.zing.vn/wplogin/mobile/cfmobile"}, //7			// 16.ok, khong chon server, jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/cuuduong"}, //8			// 17.ok, chon server, roi jump directly to payment page
	       	{"https://pay.zing.vn/wplogin/mobile/gnm"}, //10				// 18.ok, khong chon server, jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/gunga"}, //11				// 19.ok, chon roleId, roi jump directly to payment page
        	{"https://pay.zing.vn/wplogin/mobile/hltq"}, //13				// 20.ok, chon server, auto-select roleId
        	{"https://pay.zing.vn/wplogin/mobile/hpt"}, //15				// 21.ok, chon serverGroup, serverName, roleId
        	{"https://pay.zing.vn/wplogin/mobile/jxm"}, //17				// 22.ok, chon serverGroup, serverName, roleId
        	{"https://pay.zing.vn/wplogin/mobile/mum"}, //21				// 23.ok, chon server, auto-select roleId
        	{"https://pay.zing.vn/wplogin/mobile/ztm"}, //35				// 24.ok, chon serverGroup, server, roleId
 			{"https://pay.zing.vn/wplogin/mobile/yugi"}, //33				// 25.login vo trag thanh toan, chon server o tai day, k co Submit, id=roleList, id = serverList -> pending
        	{"https://pay.zing.vn/wplogin/mobile/360mobikiemkhach"}, //2	// 26.login vo trag thanh toan, chon server o tai day, k co Submit, id=roleList, id = serverList -> pending
        	{"https://pay.zing.vn/wplogin/mobile/mangah5"}, //20			// 27.login vo trag thanh toan, chon server o tai day, k co Submit, id=roleList, id = serverList -> pending
        	{"https://pay.zing.vn/wplogin/mobile/ngaokiemh5"}, //22			// 28.login vo trag thanh toan, chon server o tai day, k co Submit, id=roleList, id = serverList -> pending
        	{"https://pay.zing.vn/wplogin/mobile/nsbd"}, //25				// 29.login vo trag thanh toan, chon server o tai day, k co Submit, id=roleList, id = serverList -> pending

        	
/*         	{"https://pay.zing.vn/wplogin/mobile/stct"}, //30				// 30.chua tao dc acc sv1     	
     		{"https://pay.zing.vn/wplogin/mobile/hkh5"}, //12				// 31.chua tao duoc acc sv1 de check do acc loi
        	{"https://pay.zing.vn/wplogin/mobile/sgm"}, //29				// 32.ko ho tro login ZingId, gio chi con Login Fb trong game
        	{"https://pay.zing.vn/wplogin/mobile/ros"}, //28				// 33.ko ho tro login ZingId	
        	{"https://pay.zing.vn/wplogin/mobile/nikki"}, //23				// 34.ko ho tro login ZingId		
        	{"https://pay.zing.vn/wplogin/mobile/360live"}, //1 			// 35.ko ho tro login ZingId
        	{"https://pay.zing.vn/wplogin/mobile/lgr"}, //19				// 36.ko ho tro login ZingId
        	{"https://pay.zing.vn/wplogin/mobile/ica"}, //16				// 37.ko ho tro login ZingId
        	{"https://pay.zing.vn/wplogin/mobile/yugi-zl"}, //34			// 38.ko ho tro login ZingId
*/	    
        	
/*        	{"//h3[contains(text(),'Võ Lâm Truyền Kỳ Mobile')]"},//5
        	{"//h3[contains(text(),'Võ Lâm Truyền Kỳ H5')]"},//1
        	{"//h3[contains(text(),'Cửu Âm 3D')]"},//2
        	{"//h3[contains(text(),'Thiên Long Bát Bộ 3D')]"},//3
        	{"//h3[contains(text(),'Cửu Âm')]"},//4
        	{"//h3[contains(text(),'Trường Sinh Quyết')]"},//6
        	{"//h3[contains(text(),'360mobi Kiếm Khách')]"},//7
        	{"//h3[contains(text(),'OMG 3Q')]"},//8
        	{"//h3[contains(text(),'Crossfire: Legends')]"},//9
        	{"//h3[contains(text(),'360mobi Cờ Tỷ Phú')]"},//10
        	{"//h3[contains(text(),'Dragon Nest VNG')]"},//11
        	{"//h3[contains(text(),'MU Strongest')]"},//12
        	{"//h3[contains(text(),'360mobi Mộng Hoàng Cung')]"},//13
        	{"//h3[contains(text(),'Quân Sư Liên Minh Tam Quốc')]"},//14
        	{"//h3[contains(text(),'Rules Of Survival')]"},//15
        	{"//h3[contains(text(),'Cửu Dương VNG')]"},//16
        	{"//h3[contains(text(),'Đấu Tiên Đài')]"},//17
        	{"//h3[contains(text(),'Bóng rổ Mobi')]"},//18
        	{"//h3[contains(text(),'Hiệp Khách H5')]"},//19
        	{"//h3[contains(text(),'Gunny Mobi')]"},//20
        	{"//h3[contains(text(),'Gun Pow')]"},//21
        	{"//h3[contains(text(),'360mobi Ngôi Sao Bóng Đá')]"},//22
        	{"//h3[contains(text(),'Yugi H5')]"},//23
        	{"//h3[contains(text(),'iCá')]"},//24
        	{"//h3[contains(text(),'Khu Vườn Trên Mây')]"},//25
        	{"//h3[contains(text(),'Ngôi Sao Hoàng Cung 360mobi')]"},//26
        	{"//h3[contains(text(),'3Q 360Mobi')]"},//27
        	{"//h3[contains(text(),'Kiếm Vũ Mobile')]"},//28
        	{"//h3[contains(text(),'Ngạo Kiếm H5')]"},//29
        	{"//h3[contains(text(),'Ngọa Long Mobile')]"},//30
        	{"//h3[contains(text(),'Manga H5')]"},//31
        	{"//h3[contains(text(),'Ngôi Sao Thời Trang')]"},//32
        	{"//h3[contains(text(),'Reign Of Warlords')]"},//33
        	{"//h3[contains(text(),'Au MOBI')]"},//34
        	{"//h3[contains(text(),'360mobi Ngôi Sao Bộ Lạc')]"},//35
        	{"//h3[contains(text(),'360Live')]"},//36
        	{"//h3[contains(text(),'Chinh Đồ 1 Mobile')]"},//37
*/        	
        };
    }
}
