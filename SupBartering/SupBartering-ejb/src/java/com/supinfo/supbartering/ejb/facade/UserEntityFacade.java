/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.facade;

import com.supinfo.supbartering.ejb.entity.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UserEntityFacade {
    @PersistenceContext(unitName = "SupBartering-ejbPU")
    private EntityManager em;

    public void create(UserEntity userEntity) {
        em.persist(userEntity);
    }

    public void edit(UserEntity userEntity) {
        em.merge(userEntity);
    }

    public void remove(UserEntity userEntity) {
        em.remove(em.merge(userEntity));
    }

    public UserEntity find(Object id) {
        return em.find(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        return em.createQuery(cq).getResultList();
    }

    public List<UserEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<UserEntity> rt = cq.from(UserEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}