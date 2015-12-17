/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.business.UserManager;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import org.apache.commons.codec.digest.DigestUtils;

public class RegisterServlet extends HttpServlet {

    @EJB
    private UserManager userManager;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO register page
        //response.getWriter().print("register test");
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creation de l'entité
        UserEntity user = new UserEntity();
        
        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setPassword(DigestUtils.sha256Hex(
                request.getParameter("password")));
        user.setUserName(request.getParameter("username"));
        
        userManager.addOrUpdateUser(user);
        
        RequestDispatcher rd = request.getRequestDispatcher("login");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Add user";
    }
}
