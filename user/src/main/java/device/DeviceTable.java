package device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import user_B.ignite;

public class DeviceTable {
  public static ignite ign=new ignite();
  /**
   * 对user_b表添加数据
   * @param employee
   * @return
   * @throws Exception
   */
  public static int addData(device dev,Connection conn) throws Exception{
      //Connection conn = ign.getConnect();
      String sql = "insert into devices(user_b_id,imei,device_type,undifined,project_id,enabled,repayment,expire_list,user_c_id) values(?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setLong(2, dev.getImei());
      pstmt.setString(3, dev.getDevice_type());
      pstmt.setString(4, dev.getUndifined());
      pstmt.setInt(1, dev.getUser_id());
      pstmt.setString(5, dev.getProject_id());
      pstmt.setBoolean(6, dev.isEnabled());
      pstmt.setBoolean(7, dev.isRepayment());
      pstmt.setString(8,dev.getExpire_list());
      pstmt.setInt(9, dev.getUser_c_id());
      int result = pstmt.executeUpdate();
      //ign.disConnect(conn);
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
      String sql = "update devices set imei=?,device_type=? ,undifined= ? ,project_id=?,enabled=?,repayment=?,expire_list=?,user_c_id=?,where user_b_id=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, dev.getImei());
      pstmt.setString(2, dev.getDevice_type());
      pstmt.setString(3, dev.getUndifined());
      pstmt.setInt(4, dev.getUser_id());
      pstmt.setBoolean(5, dev.isEnabled());
      pstmt.setBoolean(6, dev.isRepayment());
      pstmt.setString(7,dev.getExpire_list());
      pstmt.setInt(8, dev.getUser_c_id());
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
        "undifined VARCHAR(50),"+
        "project_id VARCHAR(50),"+
        "enabled TINYINT,"+
        "repayment TINYINT,"+
        "expire_list VARCHAR(50),"+
        "user_c_id INTEGER  NULL,"+
        "PRIMARY KEY (imei))";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
}
