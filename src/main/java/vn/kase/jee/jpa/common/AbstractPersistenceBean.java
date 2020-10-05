package vn.kase.jee.jpa.common;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractPersistenceBean {
    @PersistenceContext(unitName = "seniorPersistenceUnit")
    protected EntityManager entityManager;

    protected <E> Long count(Class<E> entity) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(entity)));
        return entityManager.createQuery(cq).getSingleResult();
    }

    protected <E> List<E> findAll(Class<E> entity, String jpql) {
        TypedQuery<E> query = entityManager.createQuery(jpql, entity);
        return query.getResultList();
    }

    protected <E> List<E> findAll(Class<E> entity, String jpql, Map<String, Object> parameters) {
        TypedQuery<E> query = entityManager.createQuery(jpql, entity);
        
        if (parameters != null) {
            for (Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        return query.getResultList();
    }

    protected <E> List<E> findAll(Class<E> entity, String jpql, Object... parameters) {
        TypedQuery<E> query = entityManager.createQuery(jpql, entity);

        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i + 1, parameters[i]);
            }
        }

        return query.getResultList();
    }

    protected <E> E findOne(Class<E> entity, String jpql, Map<String, Object> parameters) {
        List<E> resultList = findAll(entity, jpql, parameters);

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    protected <E> E findOne(Class<E> entity, String jpql, Object... parameters) {
        List<E> resultList = findAll(entity, jpql, parameters);

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
