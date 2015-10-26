package test.Driver.businesslogic;

import test.Stub.businesslogic.AdminBlService_Stub;
import test.Stub.businesslogic.BusinessLobbyBlService_Stub;
import test.Stub.businesslogic.CourierBlService_Stub;
import test.Stub.businesslogic.FinanceBlService_Stub;
import test.Stub.businesslogic.InquiryBlService_Stub;
import test.Stub.businesslogic.ManageBlService_Stub;
import test.Stub.businesslogic.MediumCenterBlService_Stub;
import test.Stub.businesslogic.ReponsitoryBlService_Stub;
import test.Stub.businesslogic.UserBlService_Stub;

public class MainDriver {
	public static void main(String[] args){
		System.out.println("admin");
		new Admin_Driver().drive(new AdminBlService_Stub());
		System.out.println("finish");
		System.out.println();
		
		System.out.println("businesslb");
	    new BusinessLb_Driver().drive(new BusinessLobbyBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("courier");
	    new Courier_Driver().drive(new CourierBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("finance");
	    new Finance_Driver().drive(new FinanceBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("inquiry");
	    new Inquiry_Driver().drive(new InquiryBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("manage");
	    new Manage_Driver().drive(new ManageBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("medium");
	    new Medium_Driver().drive(new MediumCenterBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("reponsitory");
	    new Repository_Driver().drive(new ReponsitoryBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	    System.out.println("user");
	    new User_Driver().drive(new UserBlService_Stub());
	    System.out.println("finish");
		System.out.println();
		
	}
}
