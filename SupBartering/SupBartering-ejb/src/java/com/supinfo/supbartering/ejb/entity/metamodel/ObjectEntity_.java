/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.entity.metamodel;

import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(ObjectEntity_.class)
public class ObjectEntity_ {
    
    public static volatile SingularAttribute<ObjectEntity_, Long> id;
    public static volatile SingularAttribute<ObjectEntity_, String> title;
    public static volatile SingularAttribute<ObjectEntity_, String> description;
    public static volatile SingularAttribute<ObjectEntity_, String> pictureUrl;
    public static volatile SingularAttribute<ObjectEntity_, BigDecimal> price;
    public static volatile SingularAttribute<ObjectEntity_, Date> dateSubmit;
    public static volatile SingularAttribute<ObjectEntity_, UserEntity> user;
    public static volatile SingularAttribute<ObjectEntity_, TypeEntity> type;
}
