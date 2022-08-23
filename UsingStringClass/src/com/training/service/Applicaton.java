package com.training.service;

public class Applicaton {

	public static void main(String[] args) {
		StringService service = new StringService();
		String city ="CHENNAI";
		
		System.out.println(String.format("%s", city));
		System.out.println(String.format("%3$.4f %2$.3f %1$.2f", 100.456,200.4567,300.56789));
		
		int key =12;
		
		switch (key) {
		case 1:
			
			service.stringEquals("ram", "ram");
			break;
		case 2:
			
			service.stringObjectEquals();
			break;
		case 3:
			service.usingTrim("  venkatesh     ");
			break;
		case 4:
			service.lengthOfString("venkatesh ");
			break;
		case 5:
			service.usingSubString("Happy Morning");
			break;
		case 6:
			service.usingChatAndIndexOf("venkat@abc.com");
			break;
		case 7:
			service.usingReplace("venkat@abc.com", "Welcome  chennai");
			break;
		case 8:
			service.usingConcat("I","Love","You");
			break;
		case 9:
			service.usingCompareTo("Ram", "Ram");
			break;
		case 10:
			service.usingStringFormat("Venki",45.298);
			break;
		case 11:
			service.usingStringFormat(17);
			break;
		case 12:
			service.usingStringFormat(9,16);
			break;
		case 13:
			service.usingStringFormat("ram", "ram");
			break;

		default:
			break;
		}
	}

}
