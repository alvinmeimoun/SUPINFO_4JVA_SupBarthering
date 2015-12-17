/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.business;

import com.supinfo.supbartering.ejb.entity.ObjectEntity;
import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.facade.ObjectFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ObjectManager {
    
    @EJB
    private ObjectFacade objectFacade;

    
    public ObjectManager(){
        
    }
    
    public List<ObjectEntity> getAllObjectByUser(UserEntity user)
    {
        return objectFacade.findAllByUser(user);
    }
    public List<ObjectEntity> getAllObjectByType(TypeEntity type)
    {
        return objectFacade.findAllByGenre(type);
    }
    public List<ObjectEntity> getAllObject()
    {
        return objectFacade.findAll();
    }
    
     public void addOrUpdateObject(ObjectEntity object){
        boolean isNew = false;
        if(object.getId() == null || object.getId() == 0){
            isNew = true;
        } else {
            if(objectFacade.find(object.getId()) == null){
                isNew = true;
            }
        }
        
        if(isNew){
            objectFacade.create(object);
        } else {
            objectFacade.edit(object);
        }
    }
    
}
