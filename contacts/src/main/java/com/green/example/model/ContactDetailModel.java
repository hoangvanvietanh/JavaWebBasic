package com.green.example.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;


import com.green.example.controller.MyConnect;
import com.green.example.entity.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ContactDetailModel {
	Contact contact;
	Part file;
	
	public ContactDetailModel(Part file) {
		//System.out.println("vo usermodel");
		this.file = file;
	}

	public ContactDetailModel(Contact contact) {
		this.contact = contact;
	}

	public ContactDetailModel() {
		
	}
	
	public String getFileName(Part filepart)
	{
		
		//System.out.println("get file name");
	     String filename="";
	     //System.out.println("get file name");
	     String header = filepart.getHeader("Content-Disposition");
	    // System.out.println("get file name");
	    // System.out.println("header:" + header);
	     int beginIndex = header.lastIndexOf("=");
	     filename = header.substring(beginIndex+1);
	     //System.out.println("hellos");
	  
	     Pattern p = Pattern.compile("\"([^\"]*)\"");
	     Matcher m = p.matcher(filename);
	     while (m.find()) 
	            filename = m.group(1);
	                   
	     //System.out.println("hi");
	     beginIndex = filename.lastIndexOf("\\");
	     filename = filename.substring(beginIndex+1);
	     //System.out.println("filename:" + filename);
	 
	     return filename;
	}
	public ArrayList<Contact> getList()
	{
		ArrayList<Contact> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return null;
		}
		try {
			String sql = "SELECT * FROM contact";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Contact temp = new Contact(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertUser()
	{
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql = "INSERT INTO `contacts`.`contact`(`name`,`photo`,`birthday`,`sex`,`address`,`phone`,`email`,`note`) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhoto());
			ps.setString(3, contact.getBirthday());
			ps.setString(4, contact.getSex());
			ps.setString(5, contact.getAddress());
			ps.setString(6, contact.getPhoneNumber());
			ps.setString(7, contact.getEmail());
			ps.setString(8, contact.getNote());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
		
	}
	
	public void uploadFile(String uploadRootPath)
	{                          
		try
		{
		     InputStream fis = file.getInputStream();
		     byte[]data = new byte[fis.available()];
		     fis.read(data);
		                        
		     FileOutputStream out = new FileOutputStream(new File( uploadRootPath + getFileName(file)));
		     out.write(data);
		                         
		     out.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		     System.out.println("That bai");
		}
		System.out.println("Thanh cong");
		}
	}
