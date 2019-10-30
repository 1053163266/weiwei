package util;

public class user {
private String name;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public user(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名:"+this.name+"密码:"+this.password;
	}
}
