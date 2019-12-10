package usermanagement;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Insertstud {

	ConnectionManager con= new ConnectionManager();
	public void insertStud() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int flag=0,flag1=0;
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";//email validation code
		 Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})");//password validation code
		 Pattern pattern = Pattern.compile(regex);//Pattern is a class.here check email validation
		System.out.println("Enter student_ID:");
		int studid= s.nextInt();
		System.out.println("Enter Student Username:");
		String student = s.next();
		Matcher m= pattern.matcher(student);
		System.out.println("Enter Student Password:");
		String password= s.next();
		Matcher m1= pswNamePtrn.matcher(password);
		if(m.matches())
		{
			System.out.println("Valid Student Username");
			flag=1;
		}
		else
		{
			System.out.println("Invalid Student Username");
		}
		if(m1.matches())
		{
			System.out.println("Valid Student Password");
			flag1=1;
		}
		else
		{
			System.out.println("Invalid Student Password");
		}
		if(flag==1 && flag1==1)
		{
			PreparedStatement st= (PreparedStatement) con.getConnection().prepareStatement("insert into Studentlogin(Student_ID,Username,Password) values(?,?,?);");
			st.setInt(1, studid);
			st.setString(2, student);
			st.setString(3,password);
			st.executeUpdate();
			System.out.println("Student data inserted successfully");
			
		}
		else
		{
			System.out.println("Student data insertion failed");
		}
		User us= new User();
		us.choice();
		
	
		
	}

}
