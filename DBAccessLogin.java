package database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;

public class DBAccessLogin {


	Connection connect()
	{
		Connection c=null;
		try {

		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBMSproject","postgres","cv");
		}
		catch(SQLException e1)
		{
			System.out.println(e1.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		return(c);
	}

	public int searchClient(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Client WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();


			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{

			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}

	}

	public int searchRetailer(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Retailer WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();


			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{

			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}

	}

	public int searchBuilder(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Builder WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();


			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{

			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}

	}

	public int searchManager(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement(" SELECT id FROM Builder,Groups WHERE passcode=crypt(?,passcode) AND Groups.manager_id=? AND id = ?;");
			st.setString(2,usrName);
			st.setString(3,usrName);
			st.setString(1,password);
			ResultSet re = st.executeQuery();


			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{

			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}

	}

	public int searchSupervisor(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT distinct A.id FROM Builder A, Builder B WHERE A.passcode=crypt(?,A.passcode) AND A.id=B.supervisor_id AND A.id = ?;");
			st.setString(2,usrName);
			st.setString(1,password);
			ResultSet re = st.executeQuery();


			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{

			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}

	}

	

	



	

	

	

	

	

	
}
