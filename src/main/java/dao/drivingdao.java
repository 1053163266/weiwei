package dao;

import java.util.Map;

import util.driving;

public interface drivingdao{

	public  Map<String, driving> queryAlldriving() throws ClassNotFoundException;
	public  Map<String, driving> queryOnedriving(String s) throws ClassNotFoundException;
	
}
