package com.cuit.impledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cuit.dbconnect.DBconnect;
import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.entity.User;
import com.cuit.service.UpDateService;

public class UpDateDao implements UpDateService {

	@Override
	public boolean UpDateUser(User UEntity) {
		String sql = "update j_user set "
				+ "uid=?,"
				+ "password=?,"
				+ "nickname=?,"
				+ "email=?,"
				+ "sex=?,"
				+ "phoneNum=?,"
				+ "major=?,"
				+ "w_class=?"
				+" where uid =?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,UEntity.getUid());
			ps.setString(2, UEntity.getPassword());
			ps.setString(3, UEntity.getNickname());
			ps.setString(4, UEntity.getEmail());
			ps.setInt(5,UEntity.getSex());
			ps.setString(6, UEntity.getPhoneNum());
			ps.setString(7, UEntity.getMajor());
			ps.setString(8, UEntity.getW_class());
			ps.setInt(9, UEntity.getUid());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UpDateUser 出错");
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

	@Override
	public boolean UpDateDevice(Device DEntity) {
		String sql = "update j_device set "
				+ "d_id=?,"
				+ "from_lab=?,"
				+ "d_type=?,"
				+ "price=?,"
				+ "brand=?,"
				+ "note=?"
				+" where d_id =?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, DEntity.getUid());
			ps.setInt(2,DEntity.getFrom_lab());
			ps.setString(3, DEntity.getD_type());
			ps.setFloat(4, DEntity.getPrice());
			ps.setString(5, DEntity.getBrand());
			ps.setString(6, DEntity.getNote());
			ps.setInt(7, DEntity.getUid());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UpDateDevice 出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean UpDateLab(Lab LEntity) {
		String sql = "update j_device set "
				+ "lab_id=?,"
				+ "name=?,"
				+ "type=?,"
				+ "belong=?,"
				+ "open_or_close=?,"
				+ "devide_type=?,"
				+ "device_num=?"
				+" where lab_id =?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, LEntity.getLab_id());
			ps.setString(2, LEntity.getName());
			ps.setString(3, LEntity.getType());
			ps.setString(4, LEntity.getBelong());
			ps.setInt(5, LEntity.getOpen_or_close());
			ps.setString(6,LEntity.getDevice_type());
			ps.setString(7, LEntity.getDevice_num());
			ps.setInt(8, LEntity.getLab_id());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UpDateLab 出错");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
