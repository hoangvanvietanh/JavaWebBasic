package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.MyConnect;
import entities.Hoadon;

public class HoadonModel {
	Hoadon hoadon;
	
	public HoadonModel() {
	}

	public HoadonModel(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
	
	public int insertHoaDon() {
		int kq=0;
		System.out.println("Ket noi insertHoaDon");
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql="INSERT INTO `hoadon`(`mahd`, `ngaylap`) VALUES (null,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setString(1, hoadon.getNgaydh());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int getNewestIdHoaDon() {
		System.out.println("Ket noi IDHoaDon");
		Connection cn = new MyConnect().getcn();
		int MaxID = 0;
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql = "select MAX(mahd) from hoadon";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				MaxID = rs.getInt(1);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MaxID; 
	}
}
