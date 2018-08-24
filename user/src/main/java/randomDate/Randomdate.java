package randomDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Randomdate {
//返回2007-01-01到2007-03-01的一个随机日期  
 private static  String a=null;;
  public static void main(String[] args) {
      Randomdate rm=new Randomdate();
      a="aaaaaa";
      System.out.println(a);
      //temp=randomDate("2019-05-14 00:00:00", "2039-05-14 00:00:00");
      rm.setA("b");
      System.out.println(a);  
  }  
  public void setA(String newa) {
    this.a=newa;
  }
  /** 
   * 获取随机日期 
   *  
   * @param beginDate 
   *            起始日期，格式为：yyyy-MM-dd 
   * @param endDate 
   *            结束日期，格式为：yyyy-MM-dd 
   * @return 
   */  

  public static String randomDate(String beginDate, String endDate) {  
      try {  
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
          Date start = format.parse(beginDate);// 构造开始日期  
          Date end = format.parse(endDate);// 构造结束日期  
          if (start.getTime() >= end.getTime()) {  
              return null;  
          }  
          long date = random(start.getTime(), end.getTime());  
          return format.format(date); 
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      return null;  
  }  

  private static long random(long begin, long end) {  
      long rtn = begin + (long) (Math.random() * (end - begin));  
      // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
      if (rtn == begin || rtn == end) {  
          return random(begin, end);  
      }  
      return rtn;  
  }  
}
