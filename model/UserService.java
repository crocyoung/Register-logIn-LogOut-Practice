package com.pengyang.user.model;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.pengyang.utils.XMLUtils;

public class UserService {
	
	public static final int USERNAME_EXIST = 1;
	public static final int EMAIL_EXIST = 2;
	public static final int SUCCESS = 3;
	



	public int regist(User user)
	{
	    // read xml
		
		Document doc = XMLUtils.getDocument();
		
		Element rootElement = doc.getRootElement();
		List<Element> usersElements = rootElement.elements("user");
		
		for(Element userFile : usersElements)
		{
			//get info in markup from xml file 
			if(userFile.elementText("username").equals(user.getUsername()))
			{
				return USERNAME_EXIST;
			}
			
			if(userFile.elementText("email").equals(user.getEmail()))
			{
				return EMAIL_EXIST;
			}
		}
		
		// add user info into  xml 
		Element addNewUserElement = rootElement.addElement("user");
		//add user attributes
		addNewUserElement.addElement("username").setText(user.getUsername());
		addNewUserElement.addElement("password").setText(user.getPassword());
		addNewUserElement.addElement("nickname").setText(user.getNickname());
		addNewUserElement.addElement("email").setText(user.getEmail());
		
		
		// wrote doc into  xml file
		XMLUtils.writeBack2XML(doc);
		
		return SUCCESS;
		
	}
	
	
     //logIn check
	public User loginCheck(String username, String password)
	{
		// compare username and password with date in xml 
		
		// get data from XML
		  
		  Document doc = XMLUtils.getDocument();
		  Element rootElement = doc.getRootElement();
		  List<Element> usersElements = rootElement.elements("user");
			
			for(Element userFile : usersElements)
			{
				
			
				if(userFile.elementText("username").equals(username) && userFile.elementText("password").equals(password))
				{
					// encapsulate BeanUtils
					User user = new User();
					// add attributes
					user.setUsername(username);
					user.setPassword(password);
					user.setNickname(userFile.elementText("nickname"));
					user.setEmail(userFile.elementText("email"));
					
					return user;
				}
			
     	}
			return null;
	}
}
	


