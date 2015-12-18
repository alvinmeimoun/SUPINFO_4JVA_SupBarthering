/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import com.supinfo.supbartering.ejb.business.UserManager;
import com.supinfo.supbartering.ejb.entity.UserEntity;
import com.supinfo.supbartering.ejb.facade.UserFacade;
import com.supinfo.supbartering.web.utils.UserAuthenticationUtils;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

public class EditProfileServlet extends HttpServlet {

    @EJB
    UserManager userManager;
    
    @EJB
    UserFacade userFacade;
    
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
        response.getWriter().println("edit profile get");
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
        String cookieUsername = UserAuthenticationUtils.GetConnectedUser(request);
        
        UserEntity user = userFacade.findByUsername(cookieUsername);
        
        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        
        if(oldPassword != null && newPassword != null && confirmNewPassword != null
                && oldPassword.length() > 0 && newPassword.length() > 0 &&
                confirmNewPassword.length() > 0){
            //Changement de mot de passe
            if(user.getPassword().equals(DigestUtils.sha256Hex(oldPassword))){
                //Ancien mot de passe valide
                if(newPassword.equals(confirmNewPassword)){
                    //Confirmation du nouveua mot de passe valide
                    user.setPassword(DigestUtils.sha256Hex(newPassword));
                }
            }
        }
        
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
        return "Edit my profile";
    }

}
