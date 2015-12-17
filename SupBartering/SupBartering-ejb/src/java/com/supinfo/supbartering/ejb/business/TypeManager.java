/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.business;

import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.facade.TypeFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TypeManager {
    
      @EJB
    private TypeFacade typeFacade;
    
    public TypeManager(){
        
    }
    
    
    public List<TypeEntity> getAllType()
    {
        return typeFacade.findAll();
    }
    
     public void addOrUpdateType(TypeEntity type){
        boolean isNew = false;
        if(type.getId() == null || type.getId() == 0){
            isNew = true;
        } else {
            if(typeFacade.find(type.getId()) == null){
                isNew = true;
            }
        }
        if(isNew){
            typeFacade.create(type);
        } else {
            typeFacade.edit(type);
        }
    }
  
}
