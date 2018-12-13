package com.cuit.service;

import java.util.List;

import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.entity.User;

public interface QueryService {
	
	
	public List<User> FindUserAll();
	public List<Device> FindDeviceAll();
	public List<Lab> FindLabAll();
	
	public User FindUserById(int Uid);
	public Device FindDeviceById(int d_id);
	public Lab FindLabById(int lab_id);
	
	
	public List<Device> FindDeviceByLabId(int lab_id);
	
	public User FindUserByName(String UName);
	public Lab FindLabByName(String LName);
	
	
	public User FindUserByDim(String tmp);
	public List<Device> FindDeviceByDim(String tmp);
	public Lab FindLabByDim(String tmp);
	
}
