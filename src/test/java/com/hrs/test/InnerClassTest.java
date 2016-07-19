package com.hrs.test;

public class InnerClassTest {
	
	
	public static void main(String args[]){
		System.out.println(  new InnerClassTest().new InfoBean(23,"hrs").toString());	
	}
	
	
	public class InfoBean {
		
		public InfoBean(int age,String area){
			this.age = age;
			this.area = area;
		}
		
		public String toString(){
			return "area is "+area+" and age is "+age;
		}
		
		private int age ;
		private String area;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		
		
	}

}
