/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.facade.UserFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    
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
        //response.getWriter().println("login get");
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String passwordCrypted = DigestUtils.sha256Hex(
                request.getParameter("password"));
        
        UserEntity user = userFacade.findByUsername(username);
        if(user != null && user.getPassword().equals(passwordCrypted)){
            response.addCookie(new Cookie("sb_token", DigestUtils.sha256Hex(username)));
            response.addCookie(new Cookie("sb_username", username));
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Login servlet";
    }

}
