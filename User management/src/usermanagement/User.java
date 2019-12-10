package usermanagement;

import java.sql.SQLException;
import java.util.Scanner;



public class User {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User us= new User();
		us.choice();
		ConnectionManager c= new ConnectionManager();
	}

	void choice() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("1)InsertStudent\n2)InsertAdmin\n3)Login\n4)Exit\n");
		int n= s.nextInt();
		switch(n)
		{
		case 1:Insertstud in= new Insertstud();
		in.insertStud();
		break;
		case 2:Insertadmin insert= new Insertadmin();
		insert.insertAdmin();
		break;
		case 3:Login1 log= new Login1();
		log.loginData();
		break;
		case 4:System.exit(0);
		}
		
	}

}
