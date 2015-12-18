/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.entity.ObjectEntity;
import com.supinfo.supbartering.ejb.facade.ObjectFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonin
 */
public class DetailsObjectServlet extends HttpServlet {

    @EJB
    public ObjectFacade objectFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        ObjectEntity objectEntity = objectFacade.find(Long.valueOf(request.getParameter("id")));
        request.setAttribute("object", objectEntity);
        
        request.getRequestDispatcher("/jsp/detailsObject.jsp").forward(request, response);
        
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
