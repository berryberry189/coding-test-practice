package com.grace.oop.singleton;

public class Client {
	public static void main(String[] args) {
		// private 생성자이므로 new를 통해 인스턴스를 생성할 수 없음
		// Singleton s = new Singleton();
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);		
		/**
		 com.grace.oop.singleton.Singleton@26f0a63f
		 com.grace.oop.singleton.Singleton@26f0a63f
		 com.grace.oop.singleton.Singleton@26f0a63f
		 */
	}
}
