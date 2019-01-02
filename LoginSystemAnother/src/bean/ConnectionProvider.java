package bean;
import bean.Provider;
import java.sql.*;

public class ConnectionProvider {

private static Connection con = null;
	
	
static {
	try {
		
		Class.forName(Provider.driver);
		con=DriverManager.getConnection(Provider.ConnectionUrl,Provider.username,Provider.password);
		
		
	}catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
}
	
public static Connection getcon()
{
	return con;
}
	


}
