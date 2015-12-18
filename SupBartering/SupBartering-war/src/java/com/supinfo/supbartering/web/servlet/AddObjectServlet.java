/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.entity.ObjectEntity;
import com.supinfo.supbartering.ejb.entity.TypeEntity;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.facade.ObjectFacade;
import com.supinfo.supbartering.ejb.facade.TypeFacade;
import com.supinfo.supbartering.ejb.facade.UserFacade;
import com.supinfo.supbartering.web.utils.UserAuthenticationUtils;
import java.io.IOException;
import java.math.BigDecimal;
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
public class AddObjectServlet extends HttpServlet {
    
    
    @EJB
    private ObjectFacade objectFacade;
    
    @EJB
    private UserFacade userFacade;

    @EJB
    private TypeFacade typeFacade;
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        List<TypeEntity> listTypes = typeFacade.findAll();
        request.setAttribute("types", listTypes);
        request.getRequestDispatcher("/jsp/addObject.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = UserAuthenticationUtils.GetConnectedUser(request);
        
        if (!username.isEmpty())
        {
            UserEntity userEntity = userFacade.findByUsername(username);

            ObjectEntity objectEntity = new ObjectEntity();
            objectEntity.setTitle(request.getParameter("title"));
            objectEntity.setDescription(request.getParameter("description"));
            objectEntity.setPrice(new BigDecimal(request.getParameter("price")));
            objectEntity.setUser(userEntity);
            
            Long TypeId = Long.valueOf(request.getParameter("type"));
            if(TypeId != null)
            {
               TypeEntity typeEntity = typeFacade.find(TypeId);
               objectEntity.setType(typeEntity);
               objectFacade.create(objectEntity);
               
               response.sendRedirect(getServletContext().getContextPath() + "/objects");
            }
            else
            {
                request.setAttribute("error", "probleme lors de l'insertion de l'objet");
                request.getRequestDispatcher("/jsp/addObject.jsp").forward(request, response);
            }
        }  
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
