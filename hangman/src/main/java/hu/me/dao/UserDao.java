package hu.me.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hu.me.entity.UserEntity;

@Repository
public class UserDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDao(SessionFactory sessionfactory){
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<UserEntity> getUserOrderByFirstNameDesc(){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		cr.addOrder(Order.desc("firstName"));
		return cr.list();
	}
	
	@Transactional
	public List<UserEntity> getUserFirstNameLikeYou(){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		cr.add(Restrictions.like("firstName", "Nem%"));
		return cr.list();
	}

}
