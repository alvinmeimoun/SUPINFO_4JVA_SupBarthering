/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.facade;

import com.supinfo.supbartering.ejb.entity.ObjectEntity;
import com.supinfo.supbartering.ejb.entity.ObjectEntity_;
import static com.supinfo.supbartering.ejb.entity.ObjectEntity_.user;
import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
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
public class ObjectFacade {
    
    @PersistenceContext(unitName = "SupBartering-ejbPU")
    private EntityManager em;

    public void create(ObjectEntity objectEntity) {
        em.persist(objectEntity);
    }

    public void edit(ObjectEntity objectEntity) {
        em.merge(objectEntity);
    }

    public void remove(ObjectEntity objectEntity) {
        em.remove(em.merge(objectEntity));
    }
    
    public boolean removeById(Long id){
        try
        {
         em.remove(find(id));
         return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ObjectEntity find(Long id) {
        return em.find(ObjectEntity.class, id);
    }
    
    public List<ObjectEntity> findAllByUser(UserEntity user) throws NoResultException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ObjectEntity> criteriaQuery = criteriaBuilder.createQuery(ObjectEntity.class);
        Root<ObjectEntity> object = criteriaQuery.from(ObjectEntity.class);
        
        criteriaQuery.where(criteriaBuilder.equal(object.get(ObjectEntity_.user), user));
        
        try{
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException nre){
            return null;
        }
    }
    public List<ObjectEntity> findAllByGenre(TypeEntity type) throws NoResultException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ObjectEntity> criteriaQuery = criteriaBuilder.createQuery(ObjectEntity.class);
        Root<ObjectEntity> object = criteriaQuery.from(ObjectEntity.class);
        
        criteriaQuery.where(criteriaBuilder.equal(object.get(ObjectEntity_.type), type));
        
        try{
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException nre){
            return null;
        }
    }

    public List<ObjectEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ObjectEntity.class));
        return em.createQuery(cq).getResultList();
    }

    public List<ObjectEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ObjectEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<ObjectEntity> rt = cq.from(ObjectEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
