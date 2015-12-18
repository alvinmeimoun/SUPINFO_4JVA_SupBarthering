/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

public class GetObjectImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filename = request.getParameter("filename");
        
        File file = new File(System.getProperty("user.home") + "/SupBartering/Picture/" + filename);
        FileInputStream fis = new FileInputStream(file);
        IOUtils.copy(fis, response.getOutputStream());
        
        String mimetype;
        switch(filename.substring(filename.lastIndexOf('.'))){
            case ".jpg": 
            case ".jpeg":
                mimetype = "image/jpeg";
                break;
            case ".png":
                mimetype = "image/png";
                break;
            default:
                mimetype = "image";
                break;
        }
        response.setContentType(mimetype);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Get image data";
    }

}
