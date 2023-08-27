package SecondUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.ExprParser;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public class UserCrud {
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
public User signUpUser(User user) throws SQLException, IOException 
{
Connection connection=getConnection();
PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("insert into user values(?,?,?,?)");
preparedStatement.setInt(1,user.getUSERID());
preparedStatement.setString(2,user.getUSERNAME());
preparedStatement.setString(3,user.getUSEREMAIL());
preparedStatement.setString(4,user.getUSERPASSWORD());
preparedStatement.execute();
connection.close();
System.out.println("Sign up SSf");
return user;

}
}
/*
public User SelectUser(User user) throws SQLException, IOException
{
	Connection connection=getConnection();
	PreparedStatement preparedStatement=(PreparedStatement) connection.createStatement();
    ResultSet resultSet=preparedStatement.executeQuery("select *from user where id=?");
	preparedStatement.setInt(1, user.getUSERID());
	/* while(ResultSet.next())
	 {
		 System.out.print(resultSet.getInt("USERID"));
			System.out.print(resultSet.getString("USERNAME"));
			System.out.print(resultSet.getString("USEREMAIL"));
			System.out.println(resultSet.getInt("USERPASSWORD"));
	 }*/
	//preparedStatement.execute();
	//connection.close();
	//return user;
	
