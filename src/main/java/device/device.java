package main.java.device;

public class device {
private  int user_b_id;
private  long imei; 
private  StringBuffer device_type;
private  StringBuffer device_name;
private  int project_id;
private  boolean enabled;
private  boolean repayment;
private  StringBuffer expire_list;
public device(int user_b_id,long imei,String device_type,String device_name) {
  super();
  this.user_b_id=user_b_id;
  this.imei=imei;
  this.device_type=new StringBuffer(device_type);
  this.device_name=new StringBuffer(device_name); 
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
public  int getProject_id() {
  return project_id;
}
/**
 * @param project_id 要设置的 project_id
 */
public  void setProject_id(int project_id) {
  this.project_id = project_id;
}
/**
 * @return device_name
 */
public  String getDevice_name() {
  return new String(device_name);
}
/**
 * @param device_name 要设置的 device_name
 */
public  void setDevice_name(String device_name) {
  this.device_name = new StringBuffer(device_name);
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

}
