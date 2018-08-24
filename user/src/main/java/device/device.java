package device;

public class device {
private  int user_b_id;
private  long imei; 
private  StringBuffer device_type;
private  StringBuffer undifined;
private  StringBuffer project_id;
private  boolean enabled;
private  boolean repayment;
private  StringBuffer expire_list;
private int  user_c_id;
public device(int user_b_id,long imei,String device_type,String undifined) {
  super();
  this.user_b_id=user_b_id;
  this.imei=imei;
  this.device_type=new StringBuffer(device_type);
  this.setUndifined(undifined); 
}
public  int getUser_id() {
  return user_b_id;
}
public  void setUser_id(int user_id) {
  this.user_b_id = user_id;
}
/**
 * @return imei
 */
public  long getImei() {
  return imei;
}
/**
 * @param imei 要设置的 imei
 */
public  void setImei(long imei) {
  this.imei = imei;
}
/**
 * @return device_type
 */
public  String getDevice_type() {
  return new String(device_type);
}
/**
 * @param device_type 要设置的 device_type
 */
public  void setDevice_type(String device_type) {
  this.device_type = new StringBuffer(device_type);
}
/**
 * @return project_id
 */
public  String getProject_id() {
  return new String(project_id);
}
/**
 * @param project_id2 要设置的 project_id
 */
public  void setProject_id(StringBuffer project_id2) {
  this.project_id = new StringBuffer(project_id2);
}
/**
 * @return enabled
 */
public  boolean isEnabled() {
  return enabled;
}
/**
 * @param enabled 要设置的 enabled
 */
public  void setEnabled(boolean enabled) {
  this.enabled = enabled;
}
/**
 * @return repayment
 */
public  boolean isRepayment() {
  return repayment;
}
/**
 * @param repayment 要设置的 repayment
 */
public  void setRepayment(boolean repayment) {
  this.repayment = repayment;
}
/**
 * @return expire_list
 */
public  String getExpire_list() {
  return new String(expire_list);
}
/**
 * @param expire_list 要设置的 expire_list
 */
public  void setExpire_list(String expire_list) {
  this.expire_list = new StringBuffer(expire_list);
}
/**
 * @return user_c_id
 */
public int getUser_c_id() {
  return user_c_id;
}
/**
 * @param user_c_id 要设置的 user_c_id
 */
public void setUser_c_id(int user_c_id) {
  this.user_c_id = user_c_id;
}
/**
 * @return undifined
 */
public String getUndifined() {
  return new String(undifined);
}
/**
 * @param undifined 要设置的 undifined
 */
public void setUndifined(String undifined) {
  this.undifined = new StringBuffer(undifined);
}

}
