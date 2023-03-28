package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import dto.UserInfo;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(UserInfo info) {
		entityTransaction.begin();
		entityManager.persist(info);
		entityTransaction.commit();
	}

	public UserInfo fetch(String email) {
		Query query = entityManager.createQuery("select x from UserInfo x where email = ?1").setParameter(1, email);
		List<UserInfo> list = query.getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	public UserInfo fetch(long mobile) {
		Query query = entityManager.createQuery("select x from UserInfo x where mobile = ?2").setParameter(2, mobile);
		List<UserInfo> list = query.getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);

	}
	
	public UserInfo fetch(int id) {
		return entityManager.find(UserInfo.class, id);
	}
	
	public void delete(UserInfo user) {
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		
	}
	
	public List<UserInfo> fetchAll(){
		return entityManager.createQuery("select x from UserInfo x").getResultList();
	}
}
