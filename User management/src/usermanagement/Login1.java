package usermanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login1 {

	ConnectionManager con= new ConnectionManager();
	public void loginData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int flag=0,flag1=0;
		//System.out.println("Welcome to Student login");
		System.out.println("Enter the username:");
		String user1= s.next();
		System.out.println("Enter the password:");
		String pass1= s.next();
		Statement s1= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r= s1.executeQuery("select * from Studentlogin");//for display
		Statement s2= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r1= s2.executeQuery("select * from Adminlogin");//for display
		while(r.next())
		{
			String u= r.getString(2);
			String p= r.getString(3);
			if(user1.equals(u) && pass1.equals(p))
			{
				flag=1;
			}
		}
		while(r1.next())
		{
			String us= r1.getString(2);
			String pa= r1.getString(3);
			if(user1.equals(us) && pass1.equals(pa))
			{
				flag1=1;
			}
		}
		if(flag==1)
		{
			System.out.println("Welcome to Student login");
		}
		else if(flag1==1)
		{
			System.out.println("Welcome to Admin login");
		}
		else
		{
			System.out.println("Invalid username or password");
		}
		User us= new User();
		us.choice();
		
	}
	
		
	}


