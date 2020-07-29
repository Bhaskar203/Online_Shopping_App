package com.dxc.pojos;



public class Bill {

	private int BillNo;
	private int ProductId;
	private String Product_Name;
	private int customerId;
	private double Discount;
	private double Total_Discount;
	private double ActualBill;
	private int Buying_Quantity;
	private double Product_Bill;
	
	
	
	public Bill()
	{
		
	}

	
	public Bill(int billNo, int productId, String product_Name, int customerId, double discount, double total_Discount,
			double actualBill, int buying_Quantity, double product_Bill) {
		super();
		BillNo = billNo;
		ProductId = productId;
		Product_Name = product_Name;
		this.customerId = customerId;
		Discount = discount;
		Total_Discount = total_Discount;
		ActualBill = actualBill;
		Buying_Quantity = buying_Quantity;
		Product_Bill = product_Bill;
	}










	public int getBillNo() {
		return BillNo;
	}



	public void setBillNo(int billNo) {
		BillNo = billNo;
	}



	public int getProductId() {
		return ProductId;
	}



	public void setProductId(int productId) {
		ProductId = productId;
	}



	public String getProduct_Name() {
		return Product_Name;
	}



	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public double getDiscount() {
		return Discount;
	}



	public void setDiscount(double discount) {
		Discount = discount;
	}



	public double getTotal_Discount() {
		return Total_Discount;
	}



	public void setTotal_Discount(double total_Discount) {
		Total_Discount = total_Discount;
	}



	public double getActualBill() {
		return ActualBill;
	}



	public void setActualBill(double actualBill) {
		ActualBill = actualBill;
	}



	public int getBuying_Quantity() {
		return Buying_Quantity;
	}



	public void setBuying_Quantity(int buying_Quantity) {
		Buying_Quantity = buying_Quantity;
	}



	public double getProduct_Bill() {
		return Product_Bill;
	}



	public void setProduct_Bill(double product_Bill) {
		Product_Bill = product_Bill;
	}



	@Override
	public String toString() {
		return "Bill [BillNo=" + BillNo + ", ProductId=" + ProductId + ", Product_Name=" + Product_Name
				+ ", customerId=" + customerId + ", Discount=" + Discount + ", Total_Discount=" + Total_Discount
				+ ", ActualBill=" + ActualBill + ", Buying_Quantity=" + Buying_Quantity + ", Product_Bill="
				+ Product_Bill + "]";
	}
	
	
	
	
	

}
