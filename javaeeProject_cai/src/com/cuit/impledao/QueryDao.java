package com.cuit.impledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cuit.dbconnect.DBconnect;
import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.entity.User;
import com.cuit.service.QueryService;

public class QueryDao implements QueryService{
	


	@Override
	public List<User> FindUserAll() {
		User user = new User();
		List<User> list = new ArrayList<User>();
		
		String sql = "select * from j_User";
		
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setEmail(rs.getString("email"));
				user.setMajor(rs.getString("major"));
				user.setNickname(rs.getString("nickname"));				
				user.setPassword(rs.getString("password"));
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setSex(rs.getInt("sex"));
				user.setUid(rs.getInt("uid"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("finUserAll 出错");
			e.printStackTrace();
			return null;
		}		

		
		return list;
	}

	@Override
	public List<Device> FindDeviceAll() {
		List<Device> list = new ArrayList<Device>();
		Device device = new Device();
		try {
			String sql = "select * from j_device";
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				device.setUid(rs.getInt("d_id"));
				device.setPrice(rs.getFloat("price"));
				device.setFrom_lab(rs.getInt("from_lab"));
				device.setD_type(rs.getString("d_type"));
				device.setBrand(rs.getString("brand"));
				device.setNote(rs.getString("note"));
				list.add(device);
			}
			
		} catch (SQLException e) {
			System.out.println("findDeviceAll 出错");
			e.printStackTrace();
			return null;
		}
		
		
		return list;
	}

	@Override
	public List<Lab> FindLabAll() {
		List<Lab> list = new ArrayList<Lab>();
		Lab lab = new Lab();
		String sql = "select * from j_lab";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lab.setBelong(rs.getString("belong"));
				lab.setDevice_num(rs.getString("device_num"));
				lab.setDevice_type(rs.getString("device_type"));
				lab.setLab_id(rs.getInt("lab_id"));
				lab.setName(rs.getString("name"));
				lab.setOpen_or_close(rs.getInt("open_or_close"));
				lab.setType(rs.getString("type"));
				list.add(lab);
			}
			
			
		} catch (SQLException e) {
			System.out.println("FindLabAll 出错");
			e.printStackTrace();
			return null;
		}
		
		return list;
	}

	@Override
	public User FindUserById(int Uid) {
		User user = new User();
		
		String sql = "select * from j_user where uid = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setEmail(rs.getString("email"));
			user.setMajor(rs.getString("major"));
			user.setNickname(rs.getString("nickname"));				
			user.setPassword(rs.getString("password"));
			user.setPhoneNum(rs.getString("phoneNum"));
			user.setSex(rs.getInt("sex"));
			user.setUid(rs.getInt("uid"));
			
		} catch (SQLException e) {
			System.out.println("FindUserById 出错");
			
			e.printStackTrace();
			return null;
		}
		
		return user;
	}

	@Override
	public List<Device> FindDeviceById(int d_id) {
		Device device = null;
		List<Device> list = new ArrayList<Device>();
		try {
			
			device = new Device();
			String sql = "select * from j_device where d_id = ?";
			Connection  conn = DBconnect.getConn();
			if(conn ==null)
				System.out.println("获取数据库连接失败");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, d_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			device.setUid(rs.getInt("d_id"));
			device.setPrice(rs.getFloat("price"));
			device.setFrom_lab(rs.getInt("from_lab"));
			device.setD_type(rs.getString("d_type"));
			device.setBrand(rs.getString("brand"));
			device.setNote(rs.getString("note"));
			list.add(device);			
		} catch (SQLException e) {
			System.out.println("FindDeviceById 功能出错");
			e.printStackTrace();
			return null;
		}
		
		return list;
		
	}

	@Override
	public Lab FindLabById(int lab_id) {
		Lab lab = new Lab();
		String sql = "select * from j_lab where lab_id = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, lab_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			lab.setBelong(rs.getString("belong"));
			lab.setDevice_num(rs.getString("device_num"));
			lab.setDevice_type(rs.getString("device_type"));
			lab.setLab_id(rs.getInt("lab_id"));
			lab.setName(rs.getString("name"));
			lab.setOpen_or_close(rs.getInt("open_or_close"));
			lab.setType(rs.getString("type"));
			
		} catch (SQLException e) {
			System.out.println("FindLabById 出错");
			e.printStackTrace();
			return null;
		}
		
		return lab;

	}

	@Override
	public List<Device> FindDeviceByLabId(int lab_id) {
		List<Device> list = new ArrayList<Device>();
		Device device = new Device();
		try {
			String sql = "select * from j_device where from_lab = ?";
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, lab_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				device.setUid(rs.getInt("d_id"));
				device.setPrice(rs.getFloat("price"));
				device.setFrom_lab(rs.getInt("from_lab"));
				device.setD_type(rs.getString("d_type"));
				device.setBrand(rs.getString("brand"));
				device.setNote(rs.getString("note"));
				list.add(device);
			}
			
		} catch (SQLException e) {
			System.out.println("FindDeviceByLabId 出错");
			e.printStackTrace();
			return null;
		}
		
		
		return list;
	}

	@Override
	public User FindUserByName(String UName) {
		User user = new User();
		String sql = "select * from j_user where nickname = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,UName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setEmail(rs.getString("email"));
			user.setMajor(rs.getString("major"));
			user.setNickname(rs.getString("nickname"));				
			user.setPassword(rs.getString("password"));
			user.setPhoneNum(rs.getString("phoneNum"));
			user.setSex(rs.getInt("sex"));
			user.setUid(rs.getInt("uid"));
			
		} catch (SQLException e) {
			System.out.println("FindUserByName 出错");
			e.printStackTrace();
			return null;
		}
		
		return user;
	}

	@Override
	public Lab FindLabByName(String LName) {
		Lab lab = new Lab();
		String sql = "select * from j_lab where name = ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, LName);
			ResultSet rs = ps.executeQuery();
			lab.setBelong(rs.getString("belong"));
			lab.setDevice_num(rs.getString("device_num"));
			lab.setDevice_type(rs.getString("device_type"));
			lab.setLab_id(rs.getInt("lab_id"));
			lab.setName(rs.getString("name"));
			lab.setOpen_or_close(rs.getInt("open_or_close"));
			lab.setType(rs.getString("type"));
			
		} catch (SQLException e) {
			System.out.println("FindLabByName 出错");
			e.printStackTrace();
			return null;
		}
		
		return lab;
	}

	@Override
	public User FindUserByDim(String tmp) {
		User user = new User();
		String sql = "select * from j_user where nickname like '%?%'";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,tmp);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setEmail(rs.getString("email"));
			user.setMajor(rs.getString("major"));
			user.setNickname(rs.getString("nickname"));				
			user.setPassword(rs.getString("password"));
			user.setPhoneNum(rs.getString("phoneNum"));
			user.setSex(rs.getInt("sex"));
			user.setUid(rs.getInt("uid"));
			
		} catch (SQLException e) {
			System.out.println("FindUserByName 出错");
			e.printStackTrace();
			return null;
		}
		
		return user;
	}

	@Override
	public List<Device> FindDeviceByDim(String tmp) {
		List<Device> list = new ArrayList<Device>();
		Device device = new Device();
		try {
			String sql = "select * from j_device where brand LIKE ?";
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+tmp + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				device.setUid(rs.getInt("d_id"));
				device.setPrice(rs.getFloat("price"));
				device.setFrom_lab(rs.getInt("from_lab"));
				device.setD_type(rs.getString("d_type"));
				device.setBrand(rs.getString("brand"));
				device.setNote(rs.getString("note"));
				list.add(device);
			}
			
		} catch (SQLException e) {
			System.out.println("FindDeviceByDim 出错");
			e.printStackTrace();
			return null;
		}
		
		
		return list;
	}

	@Override
	public Lab FindLabByDim(String tmp) {
		Lab lab = new Lab();
		String sql = "select * from j_lab where name LIKE ?";
		try {
			Connection conn = DBconnect.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + tmp + "%");
			ResultSet rs = ps.executeQuery();
			rs.next();
			lab.setBelong(rs.getString("belong"));
			lab.setDevice_num(rs.getString("device_num"));
			lab.setDevice_type(rs.getString("device_type"));
			lab.setLab_id(rs.getInt("lab_id"));
			lab.setName(rs.getString("name"));
			lab.setOpen_or_close(rs.getInt("open_or_close"));
			lab.setType(rs.getString("type"));
			
		} catch (SQLException e) {
			System.out.println("FindLabByDim 出错");
			e.printStackTrace();
			return null;
		}
		
		return lab;
	}
}
