package com.pengyang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.pengyang.user.model.User;

public class JDBCUtils {
	    
        public void delectById(int id)
        {
        	String table="users";
        	
        	Connection conn = null;
			Statement stmt = null;
			
			try {
		
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql:///W_JDBC", "root", "yp19910428");
		    	stmt = conn.createStatement();

		    	stmt.executeQuery("use W_JDBC");
		    	
              
		    	if(1 == stmt.executeUpdate("delete from "+table+" where id ="+id))
		    	System.out.println("ɾ���ɹ�");
		    	else
		    	{
		    		
		    	}
		    	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{	
				if(stmt != null)
				{
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					stmt = null;
				}
				
				if(conn != null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					conn = null;
				}
			}
        	
        }
     
        public User searchFor(String username, String password)
        {
        	User loginUser = new User();
        	
        	String table="users";
        	//String username = "Larry";
        	//String password = "123";
        	
        	ResultSet set = null;
        	Connection conn = null;
			Statement stmt = null;
			
			try {
		
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql:///W_JDBC", "root", "yp19910428");
		    	stmt = conn.createStatement();

		    	stmt.executeQuery("use W_JDBC");

		    	set = stmt.executeQuery("select * from "+table+" where username ='"+ username +"'and password='"+password+"'");
		    	loginUser = null;
		    	
		    	// ���set��Ϊ�� ��ô set.next() Ϊ true Ȼ����Կ�ʼ���� set
		    	if(set.next()) 
		    	{
		    		System.out.println("�û�����");
		    		return loginUser;
		    	}
		    	else
		    	{
		    		System.out.println("�û�������");
		    		return loginUser;
		    	}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally{	
				if(set != null)
				{
					try {
						set.close();
					} catch (SQLException e) {

						e.printStackTrace();
					}
					set = null;
				}
				
				if(stmt != null)
				{
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					stmt = null;
				}
				
				if(conn != null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					conn = null;
				}
			}
			return loginUser;

        }
       
        public void addNewAcc(String username, String password, String nickname)
        {
        	String table="users";
        	//String username = "Larry";
        	//String password = "123";
        	//String nickname = "LL";
        	
        	
        	Connection conn = null;
			Statement stmt = null;
			
			try {
		
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql:///W_JDBC", "root", "yp19910428");
		    	stmt = conn.createStatement();

		    	stmt.executeQuery("use W_JDBC");
		    	
		    	         //if(1 == stmt.executeUpdate("insert into users values(null,'Peter', '123','PP')"))
		    	if(1 == stmt.executeUpdate("insert into "+table+" values("+null+",'"+username+"','"+password+"','"+nickname+"')"))
		    	System.out.println("���"+username+"�ɹ�");
		    	else
		    	{
		    		System.out.println("���ʧ��");
		    	}
		    	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{	
				if(stmt != null)
				{
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					stmt = null;
				}
				
				if(conn != null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					conn = null;
				}
			}
        	
        }
   
    	public void slectAll(){
    				
    				Connection conn = null;
    				Statement stmt = null;
    				ResultSet rst = null;
    					
    				try {
    					// 1. ע������
    					Class.forName("com.mysql.jdbc.Driver");
    					
    					// 2.���������ݿ�����
    					conn = DriverManager.getConnection("jdbc:mysql:///W_JDBC", "root", "yp19910428");
    					
    					
    					// 3.��ÿ��Է��� sql ��� �� statment ����(�൱��һ�� ���� дSQL �� �ط��� Ȼ��������ӿ���ִ��)
    			    	stmt = conn.createStatement();
    			    	
    			    	// 4. ִ�� sql ��䣬�õ��������
    			    	
    			    	stmt.executeQuery("use W_JDBC");
    	
    			    	rst = stmt.executeQuery("select * from users");
    			    	while(rst.next())
    			    	{
    			    		int id = rst.getInt("id");
    			    		String username = rst.getString("username");
    			    		String password = rst.getString("password");
    			    		String nickname = rst.getString("nickname");
    			    		
    			    		System.out.println("id = "+id + " ,username = "+username +",password = " + password +", nickname = "+nickname);
    			    	}
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (ClassNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}finally{
    					if(rst != null)
    					{
    						try {
    							// �� ���ڴ˶����һЩ��Դ ���ͷŵ�
    							rst.close();
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						// ���Ѷ���� ���� ��Ϊ��
    						rst = null;
    					}
    					
    					if(stmt != null)
    					{
    						try {
    							stmt.close();
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						stmt = null;
    					}
    					
    					if(conn != null)
    					{
    						try {
    							conn.close();
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						conn = null;
    					}
    				}
    			}
}


