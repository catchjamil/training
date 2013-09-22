package com.sd.training.struts2.imran;

import freemarker.core.ArithmeticEngine;

public class SuperSubCatch {
	public static void main(String[] args){
		try{
			int a=0;
			int b=42;
		}catch(ArithmeticException e){
			System.out.println("Generic exception catch");
		}System.out.println("reachible code");
			
	}
}
