package entity;

public class Lab {

	private int lab_id;
	private String name;
	private String type;
	private String belong;
	private boolean open_or_close;
	private String device_type;
	private String device_num;
	
	public int getLab_id() {
		return lab_id;
	}
	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public boolean isOpen_or_close() {
		return open_or_close;
	}
	public void setOpen_or_close(boolean open_or_close) {
		this.open_or_close = open_or_close;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_num() {
		return device_num;
	}
	public void setDevice_num(String device_num) {
		this.device_num = device_num;
	}
}
