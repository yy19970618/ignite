package main.java.user_C;

import java.util.ArrayList;

public class User_C {
  private int user_id;
  private ArrayList<Integer> devices;
  private ArrayList<Integer> authed_device;
  private ArrayList<Integer> auth_user_ids;
  /**
   * @param user_id
   */
  public User_C(int user_id,ArrayList<Integer> devices,ArrayList<Integer> authed_device,ArrayList<Integer> auth_user_ids) {
    super();
    this.user_id = user_id;
    this.setDevices(devices);
    this.setAuthed_device(authed_device);
    checkRep();
    this.setAuth_user_ids(auth_user_ids);
  }
  private void checkRep() {
    // TODO 自动生成的方法存根
    
  }
  /*
   * @param the user_id
   * */
  public void setUser_id(int user_id) {
    this.user_id=user_id;
  }
 
  public int getuser_Id() {
    return this.user_id;
  }
public ArrayList<Integer> getDevices() {
	return devices;
}
public void setDevices(ArrayList<Integer> devices) {
	this.devices = devices;
}
public ArrayList<Integer> getAuthed_device() {
	return authed_device;
}
public void setAuthed_device(ArrayList<Integer> authed_device) {
	this.authed_device = authed_device;
}
public ArrayList<Integer> getAuth_user_ids() {
	return auth_user_ids;
}
public void setAuth_user_ids(ArrayList<Integer> auth_user_ids) {
	this.auth_user_ids = auth_user_ids;
}
  
}
