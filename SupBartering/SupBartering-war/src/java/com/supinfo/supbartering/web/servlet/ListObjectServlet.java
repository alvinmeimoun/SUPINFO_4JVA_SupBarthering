/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.entity.ObjectEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.facade.ObjectFacade;
import com.supinfo.supbartering.ejb.facade.UserFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonin
 */
public class ListObjectServlet extends HttpServlet {

    @EJB
    private ObjectFacade objectFacade;
    
    @EJB
    private UserFacade userFacade;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ObjectEntity> listObjects;
        String username = (String) request.getAttribute("username");
        UserEntity userEntity = userFacade.findByUsername(username);
        
        if(userEntity.getId() != null)
        {
            listObjects = objectFacade.findAllByUser(userEntity);
            request.setAttribute("objects", listObjects);
            request.setAttribute("user", userEntity);
            request.getRequestDispatcher("/jsp/listObjects.jsp").forward(request, response);
            
        }
        else 
        {
            listObjects = objectFacade.findAll();
            request.setAttribute("objects", listObjects);
            request.getRequestDispatcher("/jsp/listObjects.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
