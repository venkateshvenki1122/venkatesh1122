package com.example;

public class Invoice {

	private int invoiceNumber;
	private String customerNAme;
	private int quantity;
	private int productRef;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceNumber, String customerNAme, int quantity, int productRef) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customerNAme = customerNAme;
		this.quantity = quantity;
		this.productRef = productRef;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCustomerNAme() {
		return customerNAme;
	}

	public void setCustomerNAme(String customerNAme) {
		this.customerNAme = customerNAme;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductRef() {
		return productRef;
	}

	public void setProductRef(int productRef) {
		this.productRef = productRef;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", customerNAme=" + customerNAme + ", quantity=" + quantity
				+ ", productRef=" + productRef + "]";
	}
	
	
	
	
}
