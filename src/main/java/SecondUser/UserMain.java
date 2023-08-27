package SecondUser;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMain
{
public static void main(String[] args) throws SQLException {
	User us=new User();
	UserCrud uc=new UserCrud();
	Scanner sc=new Scanner(System.in);
	System.out.println("Select Operation");
	System.out.println("1 Select");
	System.out.println("2 Insert");
	System.out.println("3 Delete");
	System.out.println("4 Update");
	System.out.println("Enter no");
	int sw=sc.nextInt();
	switch(sw)
	{
	case 1:
		System.out.println("enter 32");
		/*System.out.println(" et user id");
		int USERID1=sc.nextInt();
		us.setUSERID(USERID1);
		 try {
			while(ResultSet.next())
			 {
				 System.out.print(resultSet.getInt("USERID"));
					System.out.print(resultSet.getString("USERNAME"));
					System.out.print(resultSet.getString("USEREMAIL"));
					System.out.println(resultSet.getInt("USERPASSWORD"));
			 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			uc.SelectUser(us);
		} catch (Exception e) {
			// TODO: handle exception
		}
		break; */
	case 2:
		
	System.out.println(" et user id");
	int USERID=sc.nextInt();
	System.out.println("et username");
	String USERNAME=sc.next();
	System.out.println("et email");
	String USEREMAIL=sc.next();
	System.out.println("et pass");
	String USERPASSWORD=sc.next();
	
	
	us.setUSERID(USERID);
	us.setUSERNAME(USERNAME);
	us.setUSEREMAIL(USEREMAIL);
	us.setUSERPASSWORD(USERPASSWORD);
	
	//UserCrud uc=new UserCrud();
	try {
		uc.signUpUser(us);
	} catch ( SQLException e) 
	{
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	break;
	
	}
}
}
