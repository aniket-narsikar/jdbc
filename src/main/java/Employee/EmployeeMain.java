package Employee;
import java.sql.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class EmployeeMain
{
public static void main(String[] args) { 
	Scanner sc=new Scanner(System.in);
	Employee emp=new Employee();
	EmployeeCrud Ecr= new EmployeeCrud();
	boolean exit = true;
	while(exit) {
	System.out.println("Select Operation");
	System.out.println("1.ADD Record");
	System.out.println("2.UPDATE Record");
	System.out.println("3.DELETE Record");
	System.out.println("4.GET Selected Record");
	System.out.println("5.All Records");
	System.out.println("6.Exit");
	System.out.println("Enter no");
	int sw=sc.nextInt();
	switch(sw)
	{
	case 1:
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String nm=sc.next();
		System.out.println("Enter Phone");
		long ph=sc.nextLong();
		System.out.println("Enter Email");
		String em=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		System.out.println("Enter Salary");
		long sal=sc.nextLong();
		
		emp.setId(id);
		emp.setNm(nm);
		emp.setPh(ph);
		emp.setEm(em);
		emp.setPass(pass);
		emp.setSal(sal);
		try {
			Ecr.addEmployee(emp);
		}  catch ( SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		break;
	 case 2:
         System.out.println("Enter Id to Update");
         int updateId = sc.nextInt();
         System.out.println("Enter Name");
         String updateName = sc.next();
         System.out.println("Enter Phone");
         long updatePhone = sc.nextLong();
         System.out.println("Enter Email");
         String updateEmail = sc.next();
         System.out.println("Enter Password");
         String updatePassword = sc.next();
         System.out.println("Enter Salary");
         long updateSalary = sc.nextLong();

         emp.setId(updateId);
         emp.setNm(updateName);
         emp.setPh(updatePhone);
         emp.setEm(updateEmail);
         emp.setPass(updatePassword);
         emp.setSal(updateSalary);
         try {
             Ecr.updateEmployee(emp);
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         break;
	 case 3:
         System.out.println("Enter Id to Delete");
         int deleteId = sc.nextInt();
         try {
             Ecr.deleteEmployee(deleteId);
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         break;
	 case 4:
		 System.out.println("Enter Id to Get");
         int getId = sc.nextInt();
         try {
             Employee getEmployee = Ecr.getEmployeeById(getId);
             System.out.println("Id: " + getEmployee.getId());
             System.out.println("Name: " + getEmployee.getNm());
             System.out.println("Phone: " + getEmployee.getPh());
             System.out.println("Email: " + getEmployee.getEm());
             System.out.println("Password: " + getEmployee.getPass());
             System.out.println("Salary: " + getEmployee.getSal());
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         break;
	 case 5:
		{
			try {
				Employee allEmployee =Ecr.allEmployee();
				
				break;
			} catch (SQLException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
		}
	break;
	 case 6:
		{
	   exit = false;
		}
	break;
	 default:
         System.out.println("Invalid Operation!");
         break;
	}
	}
	System.out.println("Operation exit success");
	System.out.println("pls re-execute");
}
}
