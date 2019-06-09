package RegisterDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.instapojos.InstaPojo;
import com.iregisterDao.IRegisterDao;

public class RegisterDaoImpl implements IRegisterDao {
	public void register(InstaPojo pojo){

	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	 
	session.save(pojo);
	session.beginTransaction().commit();
	session.close();
}	
}
