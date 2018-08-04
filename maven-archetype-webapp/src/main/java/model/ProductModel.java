package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import controller.CartServlet;
import controller.MyConnect;
import entities.Product;

public class ProductModel {
	Product sanpham;
	Part file;
	
	public ProductModel (Part file) {
		this.file = file;
	}
	public ProductModel() {
	}

	public ProductModel(Product sanpham) {
		this.sanpham = sanpham;
	}
	
	public ArrayList<Product> getList()
	{
		ArrayList<Product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return null;
		}
		try {
			String sql = "select * from sanpham";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product temp = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Product getProductByMasp(String masp) {
		Connection cn = new MyConnect().getcn();
		Product pro = null;
		if(cn==null)
		{
			return null;
		}
		try {
			String sql = "select * from sanpham where masp=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, masp);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pro = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
			}
			ps.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public String getFileName(Part filepart)
	{
	     String filename="";
	     String header = filepart.getHeader("Content-Disposition");
	     //System.out.println("header:" + header);
	     int beginIndex = header.lastIndexOf("=");
	     filename = header.substring(beginIndex+1);
	                    
	     //remove "" quotes 2 dau chuoi
	     Pattern p = Pattern.compile("\"([^\"]*)\"");
	     Matcher m = p.matcher(filename);
	     while (m.find()) 
	            filename = m.group(1);
	                    
	     //danh cho IE 
	     beginIndex = filename.lastIndexOf("\\");
	     filename = filename.substring(beginIndex+1);
	     //System.out.println("filename:" + filename);
	 
	     return filename;
	}
	
	public void uploadFile(String uploadRootPath)
	{                          
	try
	{
	     InputStream fis = file.getInputStream();
	     byte[]data = new byte[fis.available()];
	     fis.read(data);
	                        
	     FileOutputStream out = new FileOutputStream(new File( uploadRootPath + "\\" + getFileName(file)));
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
	public int insertProduct() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql = "INSERT INTO `sanpham`(`madm`,`masp`, `tensp`, `gia`, `hinh`) VALUES (?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sanpham.getMadm());
			ps.setString(2, sanpham.getMsp());
			ps.setString(3, sanpham.getTensp());
			ps.setInt(4, sanpham.getGia());
			ps.setString(5, sanpham.getHinh());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public int updateProduct() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql = "UPDATE `sanpham` SET `madm`=?,`tensp`=?,`gia`=?,`hinh`=? WHERE masp like ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sanpham.getMadm());
			System.out.println(sanpham.getMadm());
			ps.setString(2, sanpham.getTensp());
			System.out.println(sanpham.getTensp());
			ps.setInt(3, sanpham.getGia());
			System.out.println(sanpham.getGia());
			ps.setString(4, sanpham.getHinh());
			System.out.println(sanpham.getHinh());
			ps.setString(5, sanpham.getMsp());
			System.out.println(sanpham.getMsp());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public void removeAll() {
		CartModel Car= new CartModel();
		Car.removeAll();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
