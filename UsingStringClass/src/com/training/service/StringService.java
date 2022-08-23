package com.training.service;

public class StringService {

	public void stringEquals(String str1,String str2)
	{
		System.out.println("IS Values same :="+ str1.equals(str2));
		
		System.out.println("Are they pointing to same location :="+ (str1==str2));
	
	}
	public void stringObjectEquals() {
		
		String ram = new String("Ram");
		String venki = new String("Ram");
		
		System.out.println("IS Values same :="+ ram.equals(venki));
		
		System.out.println("Are they pointing to same location :="+ (ram==venki));
	
		System.out.println(ram.hashCode());
	}
	
	public void usingTrim(String name) {
		
		//System.out.println("Without Trim:"+ name);
		System.out.println("Trim :"+ name.trim());
	}
	
	public void lengthOfString(String name) {
		
		System.out.println("String Length :"+ name.length());
		System.out.println(name.trim().length());
	}
	
	public void usingSubString(String name) {
		
		System.out.println(name.substring(1));
		System.out.println(name.substring(0,5));
	}
	
	public void usingChatAndIndexOf(String name) {
		
		System.out.println("Index Position of @ :" + name.indexOf('@'));
		System.out.println("Character At Position 3 :"+ name.charAt(6));	
	}
	
	public void usingReplace(String str1,String str2) {
		
		System.out.println("Replace :"+str1.replace(".com", ".in"));
		System.out.println(str2.replace('c', 'v'));
	}
	
	public void usingConcat(String str1,String str2,String str3) {
		
		String str4= str1.concat(str2);
		System.out.println(str4.concat(str3));
		StringBuilder builder = new StringBuilder(str1);
		builder.append(str2);
		System.out.println(builder.toString());
	}
	
	public void usingCompareTo(String str1,String str2) {
		
		System.out.println(str1.compareTo(str2));
	}
	
	public void usingStringFormat(String str1, double mark) {
		
		String frmtString = String.format("Name %s", str1);
		System.out.println(frmtString);
		
		System.out.println(String.format("Mark %.2f",mark));
	}
	
	public void usingStringFormat(int mark) {
		System.out.println(String.format("%o", mark));
		System.out.println(String.format("Hexa Decimal %x",mark));
	}
	
	public void usingStringFormat(int mark1,int mark2) {
		System.out.println(String.format("Octal %1$o,Hexa %2$x", mark1,mark2));
		
	}
	public void usingStringFormat(String str1,String str2) {
		System.out.println(String.format(" %1$s,%2$s", str1,str2));
	}
	
	public void usingStringFormat(long value) {
		System.out.println();
	}
	
}
