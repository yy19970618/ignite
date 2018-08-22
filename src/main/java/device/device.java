package main.java.device;

import java.util.ArrayList;

public class Device {
private  int user_b_id;
private  long imei; 
private  String device_type;
private  String device_name;
private  int project_id;
private  boolean enabled;
private  boolean repayment;
private  ArrayList<Integer> expire_list;
public Device(int user_b_id,long imei,String device_type,String device_name) {
  super();
  this.user_b_id=user_b_id;
  this.imei=imei;
  this.setDevice_type(device_type);
  this.setDevice_name(device_name); 
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

public ArrayList<Integer> getExpire_list() {
	return expire_list;
}
public void setExpire_list(ArrayList<Integer> expire_list) {
	this.expire_list = expire_list;
}
public String getDevice_type() {
	return device_type;
}
public void setDevice_type(String device_type) {
	this.device_type = device_type;
}
/**
 * @return the device_name
 */
public String getDevice_name() {
	return device_name;
}
/**
 * @param device_name the device_name to set
 */
public void setDevice_name(String device_name) {
	this.device_name = device_name;
}


}
