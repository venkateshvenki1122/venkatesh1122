package com.training;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    CreditCard credit = new CreditCard(1001,"Venki",2357);
    CreditCard credit1 = new CreditCard(1002, "Thamo", 5000);
    //	CreditCard credit = new CreditCard();
    	CreditCardService service = new CreditCardService();
    	System.out.println( service.addCard(credit));
    	System.out.println(service.addCard(credit1));
    	
        //System.out.println( "Hello World!" );
    }
}
