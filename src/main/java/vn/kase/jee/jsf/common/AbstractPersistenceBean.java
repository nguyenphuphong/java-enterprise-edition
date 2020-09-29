package vn.kase.jee.jsf.common;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractPersistenceBean extends AbstractFacesBean {
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

    protected <E> E findOne(Class<E> entity, String jpql, Map<String, Object> parameters) {
        List<E> resultList = findAll(entity, jpql, parameters);

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
