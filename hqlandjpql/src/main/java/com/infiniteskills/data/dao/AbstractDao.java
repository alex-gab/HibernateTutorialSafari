package com.infiniteskills.data.dao;

import com.infiniteskills.data.HibernateUtil;
import com.infiniteskills.data.dao.interfaces.Dao;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<T,ID extends Serializable> implements Dao<T,ID> {

	private Class<T> persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	protected Session getSession(){
		if(this.session == null){
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		}
		return this.session;
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		return getSession().load(this.getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.findByCriteria();
	}

	@SuppressWarnings("Duplicates")
	protected List<T> findByCriteria(Predicate... restricitions) {
		final CriteriaQuery<T> query = this.getSession().getCriteriaBuilder().createQuery(this.getPersistentClass());

		final Root<T> c = query.from(this.getPersistentClass());
		query.where(restricitions);
		query.select(c);
		final Query<T> q = this.getSession().createQuery(query);
		q.setCacheable(true);

		return q.list();

	}
	
	@Override
	public T save(T entity) {
		this.getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	@Override
	public void clear() {
		this.getSession().clear();
	}

}
