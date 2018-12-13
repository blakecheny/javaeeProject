package junit;

import static org.junit.Assert.*;

import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.impledao.AddDao;
import com.cuit.impledao.QueryDao;
import com.cuit.impledao.UpDateDao;

public class Test {

	@org.junit.Test
	public void test() {
		QueryDao dao = new QueryDao();
		Lab lab=dao.FindLabByDim("创");
		System.out.println(lab.getName());
		
		
	}

	@org.junit.Test
	public void test1(){
		UpDateDao update = new UpDateDao();
		Device device = new Device();
		device.setBrand("华为");
		device.setUid(12);
		device.setFrom_lab(6310);
		update.UpDateDevice(device);
		
	}
	
}
