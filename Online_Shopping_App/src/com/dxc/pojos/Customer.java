package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int cid;
	private String name;
	private String pass;
	private int phoneno;
	private double wallet;
	private  String location;
	private int pincode;
	
	
	
	public Customer()
	{
		
	}
	
	
	
	
	public Customer(int cid, String name, String pass, int phoneno, String location, int pincode, double wallet) {
		super();
		this.cid = cid;
		this.name = name;
		this.pass = pass;
		this.phoneno = phoneno;
		this.location = location;
		this.pincode = pincode;
		this.wallet = wallet;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}




	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", pass=" + pass + ", phoneno=" + phoneno + ", wallet="
				+ wallet + ", location=" + location + ", pincode=" + pincode + "]";
	}




	
	

}
