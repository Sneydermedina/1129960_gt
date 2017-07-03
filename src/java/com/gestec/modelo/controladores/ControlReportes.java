/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestec.modelo.controladores;

import com.gestec.model.Reportes;
import com.gestec.model.Reportes1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Sena
 */
@WebServlet(name = "ControlReportes", urlPatterns = {"/ControlReportes"})
public class ControlReportes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("1");
             Reportes r = new Reportes();
             Reportes1 r1=new Reportes1();
             
        if (request.getParameter("Tipo").equals("1")) {
            System.out.println("2");
            try {
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r.getDoc(request, response, parametros);
                System.out.println("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("2")) {
            try {
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r.getPdf(request, response, parametros);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("3")) {
            try {
                Map parametros = new HashMap();
               int id = (Integer) 103;
                parametros.put("id", id);
                r.getPpt(request, response, parametros);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (request.getParameter("Tipo").equals("4")) {
            try {
                Map parametros = new HashMap();
               int id = (Integer) 103;
                parametros.put("id", id);
                r.getXsl(request, response, parametros);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (request.getParameter("Tipo").equals("5")) {
            try {
                Map parametros = new HashMap();
               int id = (Integer) 103;
                parametros.put("id", id);
                r.getHtml(request, response, parametros);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("6")) {
            try {
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r1.getDoc(request, response, parametros);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
        if (request.getParameter("Tipo").equals("7")) {
            try{
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r1.getPdf(request, response, parametros);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("8")) {
            try{
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r1.getPpt(request, response, parametros);
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("9")) {
            try{
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r1.getXsl(request, response, parametros);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (request.getParameter("Tipo").equals("10")) {
            try{
                Map parametros = new HashMap();
                int id = (Integer) 103;
                parametros.put("id", id);
                r1.getHtml(request, response, parametros);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
