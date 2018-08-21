package main.java.user_B;

public class User_B {
  private int user_id;
  private int parent_id;
  public StringBuffer children_ids;
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
  public User_B(int user_id,int parent_id,String children_ids) {
    super();
    this.user_id = user_id;
    this.children_ids=new StringBuffer(children_ids);
    this.parent_id=parent_id;
  }
  public void setParent_id(int parent_id) {
    this.parent_id=parent_id;
  }
  public void setchildren_ids(int id) {
    if(children_ids.length()==0) {
      children_ids.append(id);
    }
    else {
      children_ids.append(","+id);
    }
  }
  public int getuser_Id() {
    return this.user_id;
  }
  public int getParent_id() {
    return this.parent_id;
  }
  public String getChildren_ids() {
    return new String(children_ids);
  }
}
