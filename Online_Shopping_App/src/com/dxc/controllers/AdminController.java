package com.dxc.controllers;
	
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.service.AdminService;


@Controller
@RequestMapping("/views")
public class AdminController
	{
	
	
		AdminService service=new AdminService();

		@RequestMapping("/add")
		public String add(@ModelAttribute Admin a,HttpSession session)
		{
		    if(service.addAdmin(a))
			{
				 String message="Admin Already Present with the Same Admin Id";
				 session.setAttribute("message", message);
				 return"message";
				
			
			}
			else {
				service.AdminAdd(a);
				 String message="Admin Added..!!";
				 session.setAttribute("message", message);
				 return"message";
			
			}
		}
	
	@RequestMapping("/login")
public String login(@ModelAttribute Admin a,HttpSession session)
{
	
	boolean b=service.login(a);
	System.out.println(b);

	if(b==true) 
	{
	 return"op";
		}
	else 
	{
		String message="login unsuccessful";
	 session.setAttribute("message", message);
	 return"message";
	}
}	
@RequestMapping("/addproduct")
	public String addproduct(@ModelAttribute Product p,HttpSession session )
	{
	System.out.println("going to add");
	service.addproduct(p);
	 String message="Product Added..:)";
	session.setAttribute("message", message);
	return "message";
		
	}
@RequestMapping("/remove")
public String remove(@RequestParam int cid,HttpSession session)
{
	String s1=service.remove(cid);
	if(s1.equalsIgnoreCase("found"))
	{
		 String message="Customer Removed..:)";
		 session.setAttribute("message", message);
		 return"message";
	}
	else {
	 String message="Customer Removed..:)";
	 session.setAttribute("message", message);
	 return"message";
	}

}


@RequestMapping("/delete")
public String delete(@RequestParam int id,HttpSession session)
{
	service.delete(id);
	 String message="Product Removed..:)";
	 session.setAttribute("message", message);
	 return"message";

}




@RequestMapping("/addcustomer")
public String addcustomer(@ModelAttribute Customer c,HttpSession session )
{
System.out.println("going to add");
if(service.addcustomer(c))
{
 String message="customer is present with same Customer Id";
session.setAttribute("message", message);
return "message";
}
else
{
	service.CustomerAdd(c);
	 String message="customer created..!!";
	 session.setAttribute("message", message);
	 return"message";

}
	
}
@RequestMapping("/prod")
public String display(Model m) {
	 List<Product> list=service.display();
	 m.addAttribute("list", list);
	return "showproducts";
	
}
@RequestMapping("/discus")
public String displayCustomer(Model m) {
	 List<Customer> list=service.displaycustomer();
	 m.addAttribute("list", list);
	return "showcustomer";
	
}
	




/*=====================Customer=================================================*/

@RequestMapping("/customer-in")
public String Customerlogin(@RequestParam int cid,@RequestParam String password,HttpSession session)
{

boolean b=service.customerlogin(cid,password);
System.out.println(b);

if(b==true) 
{
	String message="login successful";
 session.setAttribute("message", message);
 return"cust-opp";
	}
else 
{
	String message="login unsuccessful";
 session.setAttribute("message", message);
 return"message";
}
}	
	
@RequestMapping("/product-list")
public String displayProducts(Model m) {
	 List<Product> list=service.display();
	 m.addAttribute("list", list);
	return "showproducts";
	
}


@RequestMapping("/addcart")
public String addcart(@ModelAttribute Cart c,HttpSession session) {
	
	String msg=service.addcart(c);
	if(msg.equalsIgnoreCase("found")) {
	String message="Product is exists please udpate in cart";
	 session.setAttribute("message", message);
	 return"msg";
	}
	else if(msg.equalsIgnoreCase("added")) {
		String message="Product Added succesfully";
		 session.setAttribute("message", message);
		 return"message";
		}
	else {
		String message="Product Unable to  Add to Cart ,Due to incorrect Product-Id or Customer-Id ..else insufficient Quantity of product";
		 session.setAttribute("message", message);
		 return"message";
	}
	 
	 	 
}


@RequestMapping("/cart")
public String displaycartProducts(Model m) {
	List<Cart>cartList=service.displayCart();
	if(cartList.isEmpty())
	{
		String message="Oops..!! Cart is Empty.Please add..!! ";
		m.addAttribute("message", message);
			return "message";
	}
	else {
	 m.addAttribute("list",cartList);
	return "displaycartproducts";
	}
	
}




@RequestMapping("/getbill")

public String getBill(Model m)
{
	List<Bill> lis=service.getBill();
	if(lis.isEmpty())
	{
		String message="Oops..!! Cart is Empty.Please add..!! ";
		m.addAttribute("message", message);
			return "message";
	}
	else
	{
	String message="Bill is Ready of your Cart Products";
	m.addAttribute("message", message);
	 m.addAttribute("list",lis);
	 System.out.println(lis);
		return "cartbill";
	}
}


@RequestMapping("/paybill")
public String payBill(Model m)
{
	if(service.payBill())
	{
		String message="Bill is Paid..:)";
		m.addAttribute("message", message);
		return "message";
	}
	else
	{
	
	String message="Insufficient Balance..!!";
	m.addAttribute("message", message);
	return "message";
	}
	
}

@RequestMapping("/updcart")

public String updatecart(@RequestParam int id,@RequestParam int qty,Model m)
{
   if(  service.updatecart(id,qty))
   {
	String message=" Your Cart Product is Updated..!!";
	m.addAttribute("message", message);
	
		return "message";
   }
   else
   {
	   String message="Insufficient Quantity..!!";
	m.addAttribute("message", message);
	
	return "message";
	   
   }
}


@RequestMapping("/checkbal")
public String checkBal(Model m)
{
    double bal= service.checkBal();
	String message="Account Balance is:"+bal;
	m.addAttribute("message", message);
	
		return "message";
}



@RequestMapping("/addbal")
public String addBal(@RequestParam double amt,Model m)
{
    service.addBal(amt);
	String message="Amount is Added..!!";
	m.addAttribute("message", message);
	
		return "message";
}




@RequestMapping("/finalbill")
public String finalBill(Model m)
{
    double bill=service.finalBill();
	String message="Total Bill of the cart Products is: "+bill;
	m.addAttribute("message", message);
	
		return "finalBill";
}







}

	
	

