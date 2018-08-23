package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.user_B.Ignite;
public class AbstractDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 修改设备的属性
	 * @param 两个list 属性list 新属性值list  设备的imei号
	 * @throws SQLException 
	 * 
	 */
	public static void updateDeviceProperties
	(ArrayList<String> properties, ArrayList<String> values,long imei) throws SQLException{
		Connection conn = Ignite.getConnect();
	      String sql = "update devices set imei=?,device_type=? ,device_name= ? where user_b_id=?";
	      int i;
	      for(i=0;i<values.size()-1;i++) {
	    	  sql=sql+properties.get(i)+"="+values.get(i)+",";
	      }
	      sql=sql+properties.get(i)+"="+values.get(i)+" where imei="+String.valueOf(imei);
	      System.out.println(sql);
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      int result = pstmt.executeUpdate();
	      Ignite.disConnect(conn);
	}
	/**
	 * 删除两个B端用户的父子关系
	 * @param 两个B端用户的user_id
	 * @throws SQLException 
	 * 
	 */
	public static void deleteFiliation
	(int child,int parent) throws SQLException{
		  Connection conn = Ignite.getConnect();
	      String sql = "update user_B set parent_id=null where user_id="+String.valueOf(child);
	      
	      
	      Ignite.disConnect(conn);
	}
	
	
	

}
