package com.dxc.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;


public class AdminDao {
	private static final int ArrayList = 0;
	Random ran=new Random();
 private int x=0;
private int dis=0;
double total=0.0;
double price;
private int actualbill=0;
List<Admin> list=new ArrayList<>();
List<Product> list11=new ArrayList<>();

	private static SessionFactory sessionFactory;
	
	
	static
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	
	
	
	public boolean addAdmin(Admin a)
	{
		boolean flag=false;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q1= session.createQuery("from Admin");
		List<Admin> Admlist=q1.getResultList();
		 if(Admlist.isEmpty())
		 {
		
			 session.save(a);
			 flag=true;
		 }
		 else {
			 
			 for(Admin a1:Admlist)
			 {
				 if(a.getId()==a1.getId())
				 {
					 System.out.println("checking Id");
					 flag=true;
				 }
			 }
				 
		 }
			
		session.getTransaction().commit();
		
		 session.close();
		 return flag;
	
	}
	

	public void AdminAdd(Admin a) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		 session.close();
		
	}	
	
	
	
	
	
	public boolean login(Admin a) 
	{
		Session session=sessionFactory.openSession();
		
		System.out.println("going to login");
		Query q1= session.createQuery("from Admin");
		list=q1.getResultList();
		
		
		for(Admin a1:list)
		{
		if(a1.getId()==a.getId()&&a1.getPassword().equalsIgnoreCase(a.getPassword()))
		{
			System.out.println("hhhhhh");
			return true;
		}
		}
	
	return false;	
		
	}
	
	
	public void addproduct(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		 session.close();
	}	
	
	
	public String remove(int cid) {
		String s="Not Found";
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("going to delete");
		Query q5= session.createQuery("from Customer");
		List<Customer> cuslist=q5.getResultList();
		for(Customer c1:cuslist)
		 {
			 if(cid==c1.getCid())
			 {
				 s="Found";
				
		Query q1= session.createQuery("delete from  Customer where cid=:cid");
	  q1.setParameter("cid",cid);
	   q1.executeUpdate();
	
			 }
			 
				 
		 }
	
	session.getTransaction().commit();
	 session.close();
	return s;
	}
	
	
	
	public boolean addcustomer(Customer c)
	{ 
		boolean flag=false;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q5= session.createQuery("from Customer");
		List<Customer> cuslist=q5.getResultList();
		 if(cuslist.isEmpty())
		 {
			 System.out.println("checking Empty");
			 session.save(c);
			 flag=true;
		 }
		
 else {
			 
			 for(Customer c1:cuslist)
			 {
				 if(c.getCid()==c1.getCid())
				 {
				
					 flag=true;
				 }
			 }
				 
		 }
			
		session.getTransaction().commit();
		 session.close();
		 return flag;
	}
	
	
	
	
	
	
	

	public void CustomerAdd(Customer c) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		 session.close();
		
	}
	
	
	
	
	
	public List<Product> display(){
	Session session=sessionFactory.openSession();
	Query q1=session.createQuery("from Product");
	return q1.getResultList();
	}

	public boolean customerlogin(int cid, String password) {
		
Session session=sessionFactory.openSession();
		
		System.out.println("going to Customer login");
		Query q5= session.createQuery("from Customer");
		List<Customer> list1=q5.getResultList();
                       for(Customer c1:list1)
                {
                    	   if(cid==c1.getCid() && password.equalsIgnoreCase(c1.getPass()))
                    	   {
                    		   x=cid;
                    		   return true;
                    	   }
    	 
                      }
		return false;
	}

	public void delete(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("going to delete product");
		Query q1= session.createQuery("delete from  Product where id=:id");
	q1.setParameter("id",id);
	q1.executeUpdate();
	session.getTransaction().commit();
	 session.close();
		
	}

	public String addcart(Cart c) 
{
		
		String s="";
		System.out.println("going to addcart()");
		System.out.println(x);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q1=session.createQuery("from Product");
	//	Query q6=session.createQuery("from Customer");
		Query q7=session.createQuery("from Cart");
		Query q3=session.createQuery("update Product set quantity=:q where id=:i");
        Query q12=session.createQuery("update Cart set qty=:qty where id=:id");

		List<Product> pls=q1.getResultList();
		//List<Customer> cls=q6.getResultList();
		List<Cart> cartlist=q7.getResultList();
		//Iterator<Cart> itr=cartlist.iterator();
		
   
	  for(Product p1:pls)
	     {

          for(Cart c12:cartlist)
          {
    	  
             	if(c.getId()==c12.getId() &&c.getCid()==c12.getCid())
          			{
          				s="found";
          				return s;
          				
          			}  
          }
          
          
             	  if(c.getId()==p1.getId() && c.getQty()<=p1.getQuantity() && c.getCid()==x)
               	{
              	    int y=ran.nextInt(1000); 
              	    int q=p1.getQuantity()-c.getQty();
       	  		    q3.setParameter("q",q);
                    int i=c.getId();
                    q3.setParameter("i",i);
                     c.setCartno(y);
      	            q3.executeUpdate();
      		        session.merge(c);
      		        s="added";
      		        session.getTransaction().commit();
      		        session.close();
      		   
                }
          
	 
        
		             
	 }	  
   		       
		return s;
		
}
	
	
	public List<Cart> displayCart(){
		System.out.println("Coming into displayCart");
		Session session=sessionFactory.openSession();
		System.out.println(x);
		Query q01=session.createQuery("from Cart where cid=:i");
		q01.setParameter("i",x);
		return q01.getResultList();
		}

	

	
	public List<Bill> getBill() {
		List<Bill> bill_list=new ArrayList<>();
		//Bill b2=new Bill();
		double t=0.0;
		System.out.println("Coming into GET BILL");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q01=session.createQuery("from Cart where cid=:x");
		 q01.setParameter("x",x);
		
		List<Cart> ls=q01.getResultList();   
   for(Cart c01:ls)
	{
	   Bill b2=new Bill();
	 
		      int pid=c01.getId();
        	  System.out.println(pid);
        	  Query q123=session.createQuery("from Product where id=:pid");
        	 q123.setParameter("pid",pid);
      		   List<Product> pls=q123.getResultList();
        	 
      	    for(Product p1:pls)
        	  				{
        	  					
        	  							int z=ran.nextInt(1000);
        	  							
        	  							int qq=c01.getQty();
        	  							
				   						b2.setBillNo(z);
				   						
				   						b2.setCustomerId(x);
				   
				   						b2.setProductId(p1.getId());
				    
				   						b2.setProduct_Name(p1.getName());
				  
				   						b2.setActualBill((p1.getPrice()*qq));
				   
		                                b2.setDiscount(p1.getDiscount());
				   
				   						b2.setTotal_Discount((p1.getDiscount()*qq));
				   
				   						int amt=(int) ((p1.getPrice()*qq)-(p1.getDiscount()*qq));
				   
				   						
				   						t=t+amt;
				   						
				   						 price=t;
				   						 
				   						b2.setBuying_Quantity(c01.getQty());
				  
				   					
				   						
				   						b2.setProduct_Bill(amt);
				   						
				   						bill_list.add(b2);
				   			
        	  				}
        
	}
	
   
  
		return bill_list;
	
		
		
	}

	public boolean payBill() {
		 boolean flag=false;
		System.out.println("Coming into PAY BILL");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query q5= session.createQuery("from Customer where cid=:x");
		Query q32=session.createQuery("update Customer set wallet=:wal where cid=:x");
		Query q111= session.createQuery("delete from  Cart where cid=:x");
		q5.setParameter("x", x);
		
		
		List<Customer> payList=q5.getResultList();
		for(Customer cc:payList)
		{
			double wal=cc.getWallet();
		if(wal>price)
		{
			wal=wal-price;
			flag=true;
			q32.setParameter("wal", wal);
			q32.setParameter("x", x);
			q32.executeUpdate();
			q111.setParameter("x", x);
			q111.executeUpdate();
			price=0;
			
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		}
		return flag;
		
		
		
	}

	public boolean updatecart(int id, int qty) {
		boolean flag=false;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		
		
	
		Query q51= session.createQuery("from Product where id=:id");
		q51.setParameter("id",id);
		List<Product> pl=q51.getResultList();
		int q=pl.get(0).getQuantity();
		
		
		Query q65= session.createQuery("update Cart set qty=:q where id=:id");
		
		Query q75= session.createQuery("update Product set quantity=:q where id=:id");
		
		
		if(q>=qty)
		{
			
			int t=q-qty;
			Query q05= session.createQuery("from Cart where cid=:x");
			q05.setParameter("x",x);
			List<Cart> pll=q05.getResultList();
			for(Cart c05:pll)
			{
				
				System.out.println("Yess..sss");
				if(c05.getId()==id)
				{
					int w=c05.getQty()+qty;
					System.out.println(w);
					q65.setParameter("id",id);
					q65.setParameter("q",w);
					q65.executeUpdate();
					
				}
				
		    }
		q75.setParameter("id",id);
		q75.setParameter("q",t);
		q75.executeUpdate();
		flag=true;
		}
		
		
	
		
		
		
		return flag;
		
		
	}

	public double checkBal() {
		 double bal=0;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query q5= session.createQuery("from Customer where cid=:x");
		q5.setParameter("x", x);
     List<Customer> ll= q5.getResultList();
     for(Customer c:ll)
     {
    	 bal=c.getWallet();
     }
 
     System.out.println(bal);
		return bal;
	}
	
	

	public void addBal(double amt) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q32=session.createQuery("update Customer set wallet=:wal where cid=:x");
		   q32.setParameter("wal", amt);
			q32.setParameter("x", x);
			q32.executeUpdate();
     
 

	}

	public double finalBill() {
		return price;
	}


	public List<Customer> displaycustomer() {
		
		Session session=sessionFactory.openSession();
		Query q1=session.createQuery("from Customer");
		return q1.getResultList();
	}

	
	



	
	}
	
	
	
	
		
	
	
	
	
	
