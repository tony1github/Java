package bean;
//import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


public class LoginDao {

	private static SecretKeySpec secretkey;
	private static byte[] key;
	static String password;
	
	
	static int userId;
	static String userName;
	static String userSurname;
	static String userPassword;
	static String userLocation;
	static long userPhone;
	
	public int checkNumber=0;
	
	public static boolean validate(LoginBean bean)
	{
		
		
		try {
			Connection con= ConnectionProvider.getcon();
			String Query="select * from login where email= ? ";
			
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, bean.getEmail());
			ResultSet result= ps.executeQuery();
			
			while(result.next())
			{				
				password= result.getString("password");
			}			
			
			String userpassword= bean.getPassword();
			String decryptedPassword = LoginDao.decrypted(password, "RamHariGovinda");
			
			if(userpassword.equals(decryptedPassword))
			{
				return true;
			}
							
						
			 }catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
		}
	
	
	
	
	public static String decrypted(String data ,String secret)
	{
		setKey(secret);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretkey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "";
	}
	
	public static void setKey(String mykey)
	{
		MessageDigest sha = null;
		
		try {
			key = mykey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-256");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		key=sha.digest(key);
		key=Arrays.copyOf(key, 16);
		secretkey = new SecretKeySpec(key,"AES");
	}
	
	public static ArrayList<Userdetails> getUserInfo(String email)
	{
		
		Connection con = ConnectionProvider.getcon();
		
		String Query = "select * from login where email =?";
		
		
		System.out.println(email);
		
		Userdetails user = new Userdetails();
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(Query);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			
			
			while(result.next())
			{
											
				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setLocation(result.getString("surname"));
				user.setSurname(result.getString("location"));
				user.setPhoneNumber(result.getLong("phoneNumber"));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Userdetails> sendData = new ArrayList<> ();
		sendData.add(new Userdetails(user.getId(),user.getName(),user.getSurname(),user.getLocation(),user.getPhoneNumber()));
		
		printdata(sendData);
		
		return sendData;
	}
	
	
	public static void printdata(ArrayList<Userdetails> data)
	{
		
		for(int i=0;i<1;i++)
			{		
				Userdetails user = data.get(i);
				
				userId=user.id;
				userName=user.name;
				userSurname=user.surname;
				userLocation=user.location;
				userPhone = user.phoneNumber;
				System.out.println(user.id+""+user.location+""+user.name+""+user.phoneNumber+user.surname);
			}						
	}
	
	
	public int getId()
	{
		return userId;
	}
	
	public String getName()
	{
		return userName;
	}
	
	public String getSurname()
	{
			return userSurname;
	}
	
	public String getLocation()
	{
		return userLocation;
	}

	public long getPhone()
	{
		return userPhone;
	}

	public List<Sms> getSmsDetails(int start , int total)
	{
		try {
			Connection con= ConnectionProvider.getcon();
			
			PreparedStatement ps= con.prepareStatement("select * from sms limit ?,?");
			
			ps.setInt(1, start-1);
			ps.setInt(2, total);
			ResultSet result =ps.executeQuery();
			
			List<Sms> objSms =new ArrayList<Sms>();
		
			while(result.next())
			{
				
				Sms sms= new Sms();
				sms.setId(result.getInt("id"));
				sms.setCall_From(result.getLong("Call_From"));
				sms.setCall_To(result.getLong("Call_To"));
				sms.setMessage(result.getString("Message"));
				objSms.add(sms);
//				Testing ---1
//				int id=result.getInt("id");
//				long phoneNumberFrom = result.getLong("Call_From");
//				long phoneNumberTo = result.getLong("Call_To");
//				String UserMessage = result.getString("Message");
			
//				System.out.println(id + "\n" + phoneNumberFrom + "\n" + phoneNumberTo + "\n" + UserMessage);
			}
			return objSms;
		}
				catch(Exception ex)
		     {
				System.out.println(ex.getMessage());
		     }	
	
		return null;
	}	


	
	public List<Sms> getSmsList()
	{
		try {
			Connection con= ConnectionProvider.getcon();
			String query= "select * from sms";
			
			Statement st = con.createStatement();
			
			ResultSet result =st.executeQuery(query);	
			List<Sms> objSms =new ArrayList<Sms>();
			while(result.next())
			{
				Sms sms= new Sms();
				sms.setId(result.getInt("id"));
				sms.setCall_From(result.getLong("Call_From"));
				sms.setCall_To(result.getLong("Call_To"));
				sms.setMessage(result.getString("Message"));
				objSms.add(sms);
			}
			return objSms;
		}catch(Exception ex)
		{
			System.out.println("Exception Occur"+ ex.toString());
			
		}
		return null;
		}
	
	
	public int countDatabase()
	{
		try {
			Connection con= ConnectionProvider.getcon();
			String query= "select * from sms";
			
			Statement st = con.createStatement();
			
			ResultSet result =st.executeQuery(query);		
			while(result.next())
			{
				checkNumber++;
			}
			if(checkNumber%3>=1)
			{
			int number1=checkNumber/3;
				return(number1+1);
			}else
			{
				return(checkNumber/3);
			}
			
		}catch(Exception ex)
		{			
		}
		
		return 1;
	}
			
	
}
	
	

