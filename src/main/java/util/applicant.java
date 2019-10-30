package util;

public class applicant {
private String name;
private String pnumber;
private String address;
@Override
public String toString() {
	return "applicant [name=" + name + ", pnumber=" + pnumber + ", address=" + address + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPnumber() {
	return pnumber;
}
public void setPnumber(String pnumber) {
	this.pnumber = pnumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public applicant(String name, String pnumber, String address) {
	super();
	this.name = name;
	this.pnumber = pnumber;
	this.address = address;
}
public applicant() {
	super();
	// TODO Auto-generated constructor stub
}



}
