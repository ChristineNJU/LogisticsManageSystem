package test.Driver.businesslogic;

import test.Stub.businesslogic.UserBlService_Stub;

public class User_Driver {
  public void drive(UserBlService_Stub userbl){
	  System.out.println(userbl.login(null, null));
	  
	  System.out.println(userbl.reset(null, null, null));
  }
  
  public static void main(String[] args){
	  User_Driver driver=new User_Driver();
	  driver.drive(new UserBlService_Stub());
  }
}
