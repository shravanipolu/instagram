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
public class LoginCustomerController {
@RequestMapping(value="/loginCustomer")
	public String login(@RequestParam("mail") String mailId,@RequestParam("pwd") String pword,Model model){
	
	System.out.println("login success for"+ mailId);
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("from InstaPojo where mail=:email and pwd=:password");
	query.setParameter("email", mailId);
	query.setParameter("password",pword);
	List<InstaPojo> list = query.list();
	for (InstaPojo pojo : list) {
		System.out.println(pojo.getName()+""+pojo.getMail()+""+pojo.getMob());
	}
	Query query2 = session.createQuery("from InstaPojo");
	List<InstaPojo> alluser = query2.list();
	model.addAttribute("SetList",alluser);
	session.beginTransaction().commit();
	session.close();
	return "profile";
}
}
