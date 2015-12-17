/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.ejb.entity.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserEntity_.class)
public class UserEntity_ {
	public static volatile SingularAttribute<UserEntity_, Long> id;
        public static volatile SingularAttribute<UserEntity_, String> firstname;
        public static volatile SingularAttribute<UserEntity_, String> lastname;
        public static volatile SingularAttribute<UserEntity_, String> email;
        public static volatile SingularAttribute<UserEntity_, String> username;
        public static volatile SingularAttribute<UserEntity_, String> password;
}
