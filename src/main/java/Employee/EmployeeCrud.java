package Employee;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class EmployeeCrud {
public Connection getConnection() throws SQLException, IOException
{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	FileInputStream fileInputStream=new FileInputStream("config.properties");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
	return connection;	
}
public Employee addEmployee(Employee employee) throws SQLException, IOException
{
Connection connection=getConnection();	

PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
preparedStatement.setInt( 1,employee.getId());
preparedStatement.setString(2,employee.getNm());
preparedStatement.setLong(3,employee.getPh());
preparedStatement.setString(4,employee.getEm());
preparedStatement.setString(5,employee.getPass());
preparedStatement.setLong(6,employee.getSal());
preparedStatement.execute();
connection.close();
System.out.println("Added record");
return employee;
}
public void updateEmployee(Employee employee) throws SQLException, IOException {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = 
            (PreparedStatement) connection.prepareStatement("update employee set name=?,phone=?,email=?,password=?,salary=? where id=?");
    preparedStatement.setString(1, employee.getNm());
    preparedStatement.setLong(2, employee.getPh());
    preparedStatement.setString(3, employee.getEm());
    preparedStatement.setString(4, employee.getPass());
    preparedStatement.setLong(5, employee.getSal());
    preparedStatement.setInt(6, employee.getId());
    preparedStatement.executeUpdate();
    connection.close();
    System.out.println("Updated record");
}
public void deleteEmployee(int id) throws SQLException, IOException {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = 
            (PreparedStatement) connection.prepareStatement("delete from employee where id=?");
    preparedStatement.setInt(1, id);
    preparedStatement.executeUpdate();
    connection.close();
    System.out.println("Deleted record");
}
public Employee getEmployeeById(int id) throws SQLException, IOException {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = 
            (PreparedStatement) connection.prepareStatement("select * from employee where id=?");
    preparedStatement.setInt(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    Employee employee = null;
    if(resultSet.next()) {
        employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setNm(resultSet.getString("name"));
        employee.setPh(resultSet.getLong("phone"));
        employee.setEm(resultSet.getString("email"));
        employee.setPass(resultSet.getString("password"));
        employee.setSal(resultSet.getLong("salary"));
    }
    
    connection.close();
    return employee;
}
public Employee allEmployee() throws SQLException, IOException
{
	
	Connection connection =getConnection();
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select * from employee");
	Employee employee=null;
	while(resultSet.next()){
		
		employee = new Employee();
		System.out.print("\t");
		System.out.print(resultSet.getInt("ID"));
		System.out.print("\t");
		System.out.print(resultSet.getString("NAME"));
		System.out.print("\t");
		System.out.print(resultSet.getLong("PHONE"));
		System.out.print("\t");
		System.out.print(resultSet.getString("EMAIL"));
		System.out.print("\t");
		System.out.print(resultSet.getString("PASSWORD"));
		System.out.print("\t");
		System.out.println(resultSet.getLong("SALARY"));
	}
	
	connection.close();
	return employee;
}
}
/*public Employee getEmployee(int id) throws SQLException, IOException {
    Connection connection = getConnection();    
    PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
    preparedStatement.setInt(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    
    Employee employee = null;
    if (resultSet.next()) {
        employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setNm(resultSet.getString("name"));
        employee.setPh(resultSet.getLong("phone"));
        employee.setEm(resultSet.getString("email"));
        employee.setPass(resultSet.getString("password"));
        employee.setSal(resultSet.getLong("salary"));
    }
    
    connection.close();
    return employee;
}*/

