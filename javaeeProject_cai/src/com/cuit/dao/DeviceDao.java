package com.cuit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cuit.dbconnect.DBconnect;
import com.cuit.entity.Device;

public class DeviceDao  {
	
	public Device findById(Integer id) throws ClassCastException,SQLException{
		Device device = new Device();
		String sql = "select * from j_device where id = ?";
		Connection  conn = DBconnect.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		device.setUid(rs.getInt("id"));
		device.setPrice(rs.getFloat("prive"));
		
		
		return device;
		
		
	}
}
