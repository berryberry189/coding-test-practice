package com.grace.oop.templatecallback;

public class Client {
	public static void main(String[] args) {
		Soldier rambo = new Soldier();
		
		rambo.runContext("총 총 총 총 총");
		
		System.out.println();
		
		rambo.runContext("활 활 활 활 활");

	}
}
