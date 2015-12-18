/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.facade.ObjectFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonin
 */
public class DeleteObjectServlet extends HttpServlet {

   @EJB
   public ObjectFacade objectFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        Long objectId = Long.valueOf(request.getParameter("id"));
        boolean isDelete = objectFacade.removeById(objectId);
        if (isDelete)
        {
           request.getRequestDispatcher("/listObjects").forward(request, response);
        }
        else 
        {
            request.setAttribute("error", "une erreur est survenue lors de la suppression");
            request.getRequestDispatcher("/listObjects").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
