package main.java.device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.java.user_B.ignite;

public class DeviceTable {
  public static ignite ign=new ignite();
  /**
   * 对user_b表添加数据
   * @param employee
   * @return
   * @throws Exception
   */
  public static int addData(device dev) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "insert into devices(user_b_id,imei,device_type,device_name) values(?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setLong(2, dev.getImei());
      pstmt.setString(3, dev.getDevice_type());
      pstmt.setString(4, dev.getDevice_name());
      pstmt.setInt(1, dev.getUser_id());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  /**
   * 对user_b表内容进行修改
   * @param employee
   * @return
   * @throws Exception 
   */
  public static int updateData(device dev) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "update devices set imei=?,device_type=? ,device_name= ? where user_b_id=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, dev.getImei());
      pstmt.setString(2, dev.getDevice_type());
      pstmt.setString(3, dev.getDevice_name());
      pstmt.setInt(4, dev.getUser_id());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  
  /**
   * 对user_b内容删除
   * @param employee
   * @return
   * @throws Exception
   */
  public static int deleteData(device dev) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "delete from devices where user_b_id=? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dev.getUser_id());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  public static void delect() throws SQLException { 
    Connection conn = ign.getConnect();
    String sql = "DROP TABLE devices";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
  public static void createTable() throws SQLException {
    Connection conn = ign.getConnect();
    String sql="CREATE TABLE devices " +
        "(user_b_id INTEGER not NULL," +
        "imei LONG not NULL, "+
        "device_type VARCHAR(50),"+
        "device_name VARCHAR(50),"+
        "project_id INTEGER,"+
        "enabled TINYINT,"+
        "repayment TINYINT,"+
        "expire_list VARCHAR(50),"+
        "PRIMARY KEY (user_b_id))";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
}
