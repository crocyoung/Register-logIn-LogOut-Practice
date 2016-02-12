package com.pengyang.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XMLUtils {
	
	// 读文档 返回 document 对象
	public static Document getDocument()
	{
		// 建立一个reader
		SAXReader reader = new SAXReader();
		// 开始read
		try {
			Document document = reader.read("C:/MyEclipse 2014 Documents/W_RegisterLogin/users.xml");
			return document;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//  xml 写入 工具
	public static void writeBack2XML(Document doc) {
		
		OutputFormat formatDoc = OutputFormat.createPrettyPrint();
		formatDoc.setEncoding("UTF-8");
		
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream("C:/MyEclipse 2014 Documents/W_RegisterLogin/users.xml"), formatDoc);
			writer.write(doc);
			writer.close();
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
