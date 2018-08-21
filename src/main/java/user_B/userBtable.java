package main.java.user_B;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userBtable {
  public static ignite ign=new ignite();
  /**
   * 对user_b表添加数据
   * @param employee
   * @return
   * @throws Exception
   */
  public static int addData(user_B usr) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "insert into user_b values(?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, usr.getuser_Id());
      pstmt.setInt(2, usr.getParent_id());
      pstmt.setString(3,usr.getChildren_ids());
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
  public static int updateData(user_B usr) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "update user_b set parent_id=?,children_ids=? where user_id=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(3, usr.getuser_Id());
      pstmt.setInt(1, usr.getParent_id());
      pstmt.setString(2, usr.getChildren_ids());
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
  public static int deleteData(user_B usr) throws Exception{
      Connection conn = ign.getConnect();
      String sql = "delete from user_B where user_id=? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, usr.getuser_Id());
      int result = pstmt.executeUpdate();
      ign.disConnect(conn);
      return result;
  }
  public static void delect() throws SQLException { 
    Connection conn = ign.getConnect();
    String sql = "DROP TABLE user_B";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
  public static void createTable() throws SQLException {
    Connection conn = ign.getConnect();
    String sql="CREATE TABLE user_B " +
        "(user_id INTEGER not NULL," +
        "parent_id INTEGER not NULL, "+
        "children_ids VARCHAR(4096),"+
        "PRIMARY KEY (user_id))";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeUpdate();
  }
}
