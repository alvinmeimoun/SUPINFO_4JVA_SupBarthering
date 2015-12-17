/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.facade;

import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TypeFacade {
    @PersistenceContext(unitName = "SupBartering-ejbPU")
    private EntityManager em;

    public void create(TypeEntity typeEntity) {
        em.persist(typeEntity);
    }

    public void edit(TypeEntity typeEntity) {
        em.merge(typeEntity);
    }

    public void remove(TypeEntity typeEntity) {
        em.remove(em.merge(typeEntity));
    }

    public TypeEntity find(Long id) {
        return em.find(TypeEntity.class, id);
    }
    
    public List<TypeEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TypeEntity.class));
        return em.createQuery(cq).getResultList();
    }

}
