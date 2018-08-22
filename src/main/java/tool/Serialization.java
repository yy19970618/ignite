package main.java.tool;

import java.util.ArrayList;

public class Serialization {
	/**
	 * 测试序列转换函数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="1,2,3,4,57";
		ArrayList<Integer> list = strToList(s);
		String d=listToStr(list);
		System.out.println(d);
	}

	/**
     * list序列转字符串
     * @param number 要转换的list
     * @return 转换后的字符串
     */
	public static String listToStr(ArrayList<Integer> list) {
		int i;
		String str = new String();
		for(i=0;i<list.size()-1;i++) {
			str=str+list.get(i).toString();
			str=str+",";
		}
		str=str+list.get(i);
		return str;
	}
	/**
     * 字符串转list序列
     * @param number 要转换的字符串
     * @return 转换后的list
     */
	public static ArrayList<Integer> strToList(String str){
		String[] s=str.split(",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<s.length;i++) {
			list.add(Integer.valueOf(s[i]).intValue());
		}
		return list;
	}

}
