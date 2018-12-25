package test;

import static org.junit.Assert.*;

import java.util.List;

import com.cuit.entity.Device;
import com.cuit.entity.User;
import com.cuit.impledao.QueryDao;

public class Test {

	/*@org.junit.Test
	public void test() {
		QueryDao dao = new QueryDao();
		User user = dao.FindUserById(12);
		System.out.println(user.getUid());
	}*/

	@org.junit.Test
	public void test(){
		QueryDao dao = new QueryDao();
		List<Device> list = dao.FindDeviceByLabId(6310);
		System.out.println(list.size());
	}
}
