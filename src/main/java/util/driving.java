package util;
public class driving {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String phonenumber;
	private String data;
	private boolean statu;
	public driving() {
		super();
		// TODO Auto-generated constructor stub
	}
	public driving(int id, String name, String sex, int age, String phonenumber, String data, boolean statu) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phonenumber = phonenumber;
		this.data = data;
		this.statu = statu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "driving [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phonenumber=" + phonenumber
				+ ", data=" + data + ", statu=" + statu + "]";
	}	
	
}