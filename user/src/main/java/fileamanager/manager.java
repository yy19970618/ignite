package fileamanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import TreeNode.Tree;
import device.DeviceTable;
import device.device;
import randomDate.Randomdate;
import user_B.userBtable;
import user_B.user_B;
import user_C.userCtable;
import user_C.user_C;

public class manager {
  DeviceTable device = new DeviceTable();
  userBtable ub = new userBtable();
  userCtable uc = new userCtable();
  Tree tre = new Tree();
  ArrayList<String> deviceIMEI = new ArrayList<String>();
  File file = new File("userC.txt");

  public void read(String filepath) throws Exception {
    Connection conndev = device.ign.getConnect();
    Statement stmt = conndev.createStatement();
    DeviceTable.delect();
    DeviceTable.createTable();
    File file = new File(filepath);
    Scanner sc = null;
    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String tempString = null;
    while (sc.hasNextLine()) {
      tempString = sc.nextLine();
      int user_b_id = 0;
      long imei = 0;
      String device_type = null;
      String undifined = null;
      boolean enabled = true;
      boolean repayment = true;
      StringBuffer project_id = null;
      StringBuffer user_parent_id = null;
      StringBuffer expire_list = null;
      if (tempString.contains("\"")) {
        String[] temp = tempString.split(",", 9);
        project_id = new StringBuffer(temp[0].replaceAll("\"", ""));
        enabled = temp[1].replaceAll("\"", "").equals("Y") ? true : false;
        deviceIMEI.add(temp[2].replaceAll("\"", ""));
        imei = Long.parseLong(temp[2].replaceAll("\"", ""));
        undifined = temp[3].replaceAll("\"", "");
        device_type = temp[4].replaceAll("\"", "");
        repayment = temp[6].replaceAll("\"", "").equals("1") ? true : false;
        user_b_id = Integer.parseInt(temp[7].replaceAll("\"", ""));
        user_parent_id = new StringBuffer(temp[8].replaceAll("\"", ""));
        expire_list = new StringBuffer(createDate(new String(user_parent_id)));
      }
      device dev = new device(user_b_id, imei, device_type, undifined);
      dev.setEnabled(enabled);
      dev.setRepayment(repayment);
      dev.setProject_id(project_id);
      dev.setExpire_list(new String(expire_list));
      DeviceTable.addData(dev, conndev);
      tre.update(new String(user_parent_id));
    }
    sc.close();
    String selectsql = "SELECT * FROM devices";
    ResultSet rs = stmt.executeQuery(selectsql);
    while (rs.next()) {
      // Retrieve by column name
      int user_id = rs.getInt("user_b_id");
      long parent_id = rs.getLong("imei");
      String children_ids = rs.getString("device_type");
      String project_id = rs.getString("project_id");
      String expire_list = rs.getString("expire_list");
      String undifined = rs.getString("undifined");
      boolean enabled = rs.getBoolean("enabled");
      boolean repayment = rs.getBoolean("repayment");
      // Display values
      System.out.print("user_id: " + user_id);
      System.out.print(", imei: " + parent_id);
      System.out.print(", device_type: " + children_ids);
      System.out.print(", project_id: " + project_id);
      System.out.print(", undifined: " + undifined);
      System.out.print(", enabled: " + enabled);
      System.out.print(", repayment: " + repayment);
      System.out.println(", expire_list: " + expire_list);
    }
    conndev.close();
  }

  public String createDate(String str) {
    String[] temp = str.replaceAll("\"", "").split(",");
    StringBuffer date = new StringBuffer();
    int len = temp.length;
    date.append("user_id:" + temp[0] + ": " + "XXXX-XX-XX XX:XX:XX");
    for (int i = 1; i < len; i++) {
      date.append("|");
      date.append("user_id:" + temp[1] + ":  "
          + Randomdate.randomDate("2019-05-14 00:00:00", "2039-05-14 00:00:00"));
    }
    return new String(date);
  }


  public void addUserC() throws Exception {
    Connection uccon = uc.ign.getConnect();
    Statement stmt = uccon.createStatement();
    uc.delect();
    uc.createTable();
    user_C userC = null;
    int len = deviceIMEI.size();
    for (int i = 0; i < len; i++) {
      userC = new user_C(1000001 + i, deviceIMEI.get(i),
          deviceIMEI.get((int) (0 + Math.random() * (len))) + "   "
              + deviceIMEI.get((int) (0 + Math.random() * (len))),
          deviceIMEI.get((int) (0 + Math.random() * (len))) + "     "
              + deviceIMEI.get((int) (0 + Math.random() * (len))));
      uc.addData(userC, uccon);
    }
    String selectsql = "SELECT * FROM user_C";
    ResultSet rs = stmt.executeQuery(selectsql);
    PrintWriter out = new PrintWriter(file);
    while (rs.next()) {
      // Retrieve by column name
      int user_id = rs.getInt("user_id");
      String devices = rs.getString("devices");
      String authed_device = rs.getString("authed_device");
      String auth_user_ids = rs.getString("auth_user_ids");
      // Display values
      System.out.print("userC_id: " + user_id);
      System.out.print(", parent_id: " + devices);
      System.out.print(", children_ids: " + authed_device);
      System.out.println(", auth_user_ids: " + auth_user_ids);
      String userCinfo =
          String.format("user_id: %d, devices: %s, authed_device: %s, auth_user_ids: %s", user_id,
              devices, authed_device, auth_user_ids);
      out.println(userCinfo);
    }
    out.close();
  }


  public void addUserB() throws Exception {
    Connection connub = ub.ign.getConnect();
    Statement stmt = connub.createStatement();
    ub.delect();
    ub.createTable();
    user_B userb = null;
    for (int i = 0; i < tre.Tre.size(); i++) {
      if (!(tre.Tre.get(i).parent == null)) {
        userb = new user_B(Integer.parseInt(tre.Tre.get(i).name),
            Integer.parseInt((tre.Tre.get(i).parent)), toString(tre.Tre.get(i).childset));
        ub.addData(userb, connub);
      } else {
        userb =
            new user_B(Integer.parseInt(tre.Tre.get(i).name), toString(tre.Tre.get(i).childset));
        ub.addDataNUll(userb, connub);
      }
    }
    String selectsql = "SELECT user_id,parent_id,children_ids FROM user_B";
    ResultSet rs = stmt.executeQuery(selectsql);
    while (rs.next()) {
      // Retrieve by column name
      int user_id = rs.getInt("user_id");
      int parent_id = rs.getInt("parent_id");
      String children_ids = rs.getString("children_ids");
      // Display values
      System.out.print("user_id: " + user_id);
      System.out.print(", parent_id: " + parent_id);
      System.out.println(", children_ids: " + children_ids);
    }
    connub.close();
  }


  public String toString(Set<String> set) {
    StringBuffer temp = new StringBuffer();
    for (String str : set) {
      temp.append(str + ",");
    }
    return new String(temp);
  }


  public static void main(String[] args) throws Exception {
    String pathfile = "E:\\eclipse-workspace\\user\\report_alarm_8_device.txt";
    manager man = new manager();
    man.read(pathfile);
    man.addUserB();
    man.addUserC();
  }
}
