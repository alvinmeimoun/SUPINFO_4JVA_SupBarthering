/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public abstract class UserAuthenticationUtils {
    
    
    public static String GetConnectedUser(HttpServletRequest request) 
    {
        List<Cookie> cookies = new ArrayList<>();
         
        if (request.getAttribute("isAuthenticated").equals("true"))
        {
            if(request.getCookies() != null){
            cookies = Arrays.asList(request.getCookies());
            
        }
         for(Cookie c : cookies){
            if("sb_username".equals(c.getName())){
                return c.getValue();
            }
        }
        }
         return "";
    }
}
