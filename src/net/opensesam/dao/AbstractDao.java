package net.opensesam.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T> {

    private final Class<T> entityClass;
    private final SessionFactory sessionFactory;

    public AbstractDao(Class<T> entityClass, SessionFactory sessionFactory) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    public Criteria criteria() {
        return currentSession().createCriteria(entityClass);
    }

    public Query query(String hql) {
        return currentSession().createQuery(hql);
    }

    public Session currentSession() {
        return SessionFactoryUtils.doGetSession(sessionFactory, false);
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        return criteria().list();
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T) currentSession().get(entityClass, id);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void save(T object) {
        currentSession().save(object);
    }

    public void update(T object) {
        currentSession().update(object);
    }
}
