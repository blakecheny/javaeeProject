package com.cuit.service;

import com.cuit.entity.*;

public interface AddService {
  
	public boolean AddUser(User UEntity);	
	public boolean AddDevice(Device DEntity);
	public boolean AddLab(Lab LEntity);
}
