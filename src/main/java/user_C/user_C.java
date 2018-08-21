package main.java.user_C;

public class User_C {
  private int user_id;
  private StringBuffer devices;
  private StringBuffer authed_device;
  private StringBuffer auth_user_ids;
  /**
   * @param user_id
   */
  public User_C(int user_id,String devices,String authed_device,String auth_user_ids) {
    super();
    this.user_id = user_id;
    this.devices=new StringBuffer(devices);
    this.authed_device=new StringBuffer(authed_device);
    checkRep();
    this.auth_user_ids=new StringBuffer(auth_user_ids);
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
  /*
   *  @param the user_id
   */
  public void setDevices(String devices) {
    this.devices=new StringBuffer(devices);
  }
  /*
   *  @param the user_id
   */
  public void setAuthed_device(String authed_device) {
    this.authed_device=new StringBuffer(authed_device);
  }
  /*
   *  @param the user_id
   */
  public void setAuth_user_ids(String auth_user_ids) {
    this.auth_user_ids=new StringBuffer(auth_user_ids);
  }
  public int getuser_Id() {
    return this.user_id;
  }
  public String getDevices() {
    return new String(devices);
  }
  public String getAuthed_device() {
    return new String (authed_device);
  }
  public String getAuth_user_ids() {
    return new String(auth_user_ids);
  }
}
