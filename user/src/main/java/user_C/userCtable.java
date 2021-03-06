package user_C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import user_B.ignite;

public class userCtable {
  public static ignite ign=new ignite();
  /**
   * 对user_c表添加数据
   * @param employee
   * @return
   * @throws Exception
   */
  public static int addData(user_C usr,Connection conn) throws Exception{
      //Connection conn = ign.getConnect();
      String sql = "insert into user_C values(?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, usr.getuser_Id());
      pstmt.setString(2, usr.getDevices());
      pstmt.setString(3,usr.getAuthed_device());
      pstmt.setString(4,usr.getAuth_user_ids());
      int result = pstmt.executeUpdate();
      //ign.disConnect(conn);
      return result;
  }
  /**
   * 对user_c表内容进行修改
   * @param employee
   * @return
   * @throws Exception 
   */
  public static int updateData(user_C usr) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "update user_C set devices=?,authed_device=? ,auth_user_ids= ? where user_id=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(4, usr.getuser_Id());
      pstmt.setString(1, usr.getDevices());
      pstmt.setString(2, usr.getAuthed_device());
      pstmt.setString(3, usr.getAuth_user_ids());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  
  /**
   * 对user_c内容删除
   * @param employee
   * @return
   * @throws Exception
   */
  public static int deleteData(user_C usr) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "delete from user_C where user_id=? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, usr.getuser_Id());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  public static void delect() throws SQLException { 
    Connection conn = ign.getConnect();
    String sql = "DROP TABLE user_C";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
  public static void createTable() throws SQLException {
    Connection conn = ign.getConnect();
    String sql="CREATE TABLE user_C " +
        "(user_id INTEGER not NULL," +
        "devices VARCHAR(50) not NULL, "+
        "authed_device VARCHAR(50),"+
        "auth_user_ids VARCHAR(50),"+
        "PRIMARY KEY (user_id))";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
}
