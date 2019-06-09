package com.instacontrollers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.instapojos.InstaPojo;

@Controller
public class UserCustomerController {
	
	@RequestMapping(value="/deleteView")
	public String deleteViewCustomer(@RequestParam("mailIdToDelete") String email,Model model){
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("delete from InstaPojo where mail=:mail");
	Query query2 = query.setParameter("mail",email);
	query2.executeUpdate();
		
	Query query3 = session.createQuery("from InstaPojo");
	List<InstaPojo> alluser = query3.list();
	model.addAttribute("SetList",alluser);

	session.beginTransaction().commit();
	session.close();
	
	return "profile";
}
	
	@RequestMapping(value="/editView")
	public  String editViewCustomer(@RequestParam("mailToEdit") String email,Model model){
		System.out.println("edit button triggered");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from InstaPojo where mail=:mailId");
		query.setParameter("mailId",email);
		List<InstaPojo> editulist = query.list();
		for (InstaPojo ip : editulist) {
			System.out.println(ip.getName()+"  "+ ip.getMob()+""+ip.getMail());
		}
		model.addAttribute("editCustomList",editulist.get(0));
		
		return "update";
	}
	@RequestMapping(value="/updateCustomer")
	public String updateCustomer(InstaPojo pojo,Model model){
		System.out.println("update triggered");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.update(pojo);
		session.beginTransaction().commit();
		
		Query query3 = session.createQuery("from InstaPojo");
		List<InstaPojo> updateUser = query3.list();
		model.addAttribute("SetList",updateUser);

		
		session.close();

		
		
		
		return "profile";
	}
}
