package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.Danhmuc;

public class Danhmucmodel {
	Danhmuc dm;
	
	public Danhmucmodel() {
	}

	public Danhmucmodel(Danhmuc dm) {
		this.dm = dm;
	}
	
	public int insertDM() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return 0;
		}
		try {
			String sql = "INSERT INTO `danhmuc`(`madm`, `tendm`) VALUES (?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, dm.getMadm());
			ps.setString(2, dm.getTendm());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public ArrayList<Danhmuc> getList() {
		ArrayList<Danhmuc> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null)
		{
			return null;
		}
		try {
			String sql = "SELECT `madm`, `tendm` FROM `danhmuc`";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Danhmuc temp = new Danhmuc(rs.getString(1), rs.getString(2));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
