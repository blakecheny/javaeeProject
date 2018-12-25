package com.cuit.impledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cuit.dbconnect.DBconnect;
import com.cuit.service.DeleteService;

public class DeleteDao implements DeleteService {

	@Override
	public boolean DeleteUserById(int uid) {

		String sql = "delete from j_user where uid = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DeleteUserById 出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteDeviceById(int d_id) {
		String sql = "delete from j_device where d_id = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, d_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DeleteDeviceById 出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteLabById(int Lab_id) {
		String sql = "delete from j_device where lab_id = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Lab_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DeleteLabById 出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteUserByName(String UName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteDevideByName(String DName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteLabByName(String LName) {
		// TODO Auto-generated method stub
		return false;
	}

}
