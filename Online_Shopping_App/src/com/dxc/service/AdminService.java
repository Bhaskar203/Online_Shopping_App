package com.dxc.service;

import java.util.List;

import org.springframework.ui.Model;

import com.dxc.Dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminService {

	AdminDao dao=new AdminDao();

	public boolean addAdmin(Admin a)
	{
		return dao.addAdmin(a);

	}
	public boolean login(Admin a) {
	return dao.login(a);
	}
	public void addproduct(Product p) {
		dao.addproduct(p);
	}
	public String remove(int cid)
	{
		return dao.remove(cid);
	}
	public boolean addcustomer(Customer c) {
		 return dao.addcustomer(c);
	}
	public List<Product> display(){
return dao.display();
	
	}
	public boolean customerlogin(int cid, String password) {
		
		return dao.customerlogin(cid,password);
	}
	public void delete(int id) {
		dao.delete(id);
		
	}
	
	
	public String addcart(Cart c) {
		return dao.addcart(c);
	}
	public List<Cart> displayCart() {
		
		return dao.displayCart();
	}

	public List<Bill> getBill() {
		
		return dao.getBill();
	}
	public boolean payBill() {
		return dao.payBill();
		
	}
	public boolean updatecart(int id, int qty) {
		return dao.updatecart(id,qty);
		
	}
	public double checkBal() {
		// TODO Auto-generated method stub
		return dao.checkBal();
	}
	public void addBal(double amt) {
        dao.addBal(amt);		
	}
	public double finalBill() {
		return dao.finalBill();
	}
	public void AdminAdd(Admin a) {
          dao.AdminAdd(a);		
	}
	public void CustomerAdd(Customer c) {
        dao.CustomerAdd(c);		
	}
	public List<Customer> displaycustomer() {
		// TODO Auto-generated method stub
		return dao.displaycustomer();
	}

}
