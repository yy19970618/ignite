package main.java.user_B;

import java.util.ArrayList;

public class User_B {
  private int user_id;
  private int parent_id;
  public ArrayList<Integer>  children_ids = new ArrayList<Integer>();
  /**
   * @param user_id
   */
  public User_B(){
	  this.user_id=-1;
	  this.parent_id=-1;
  }
  public User_B(int user_id) {
      super();
      this.user_id = user_id;
  }
  public User_B(int user_id,int parent_id,ArrayList<Integer> temp_children_ids) {
    super();
    this.user_id = user_id;
    this.children_ids=temp_children_ids;
    this.parent_id=parent_id;
  }
  public void setParent_id(int parent_id) {
    this.parent_id=parent_id;
  }
  public void setchildren_ids(int id) {
    this.children_ids.add(id);
  }
  public int getuser_Id() {
    return this.user_id;
  }
  public int getParent_id() {
    return this.parent_id;
  }
  public ArrayList<Integer> getChildren_ids() {
    return children_ids;
  }
}
