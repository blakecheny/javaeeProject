package service;

public interface DeleteService {

	public boolean DeleteUserById(int uid);
	public boolean DeleteDeviceById(int d_id);
	public boolean DeleteLabById(int Lab_id);
	
	public boolean DeleteUserByName(String UName);
	public boolean DeleteDevideByName(String DName);
	public boolean DeleteLabByName(String LName);
}
