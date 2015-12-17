/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.entity.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(TypeEntity_.class)
public class TypeEntity_ {
    
    public static volatile SingularAttribute<TypeEntity_, Long> id;
    public static volatile SingularAttribute<TypeEntity_, String> typename;
    
}
