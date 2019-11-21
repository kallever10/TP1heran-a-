/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.kallevermaria.servlets;

import br.iff.edu.kallevermaria.entidades.Usuario;
import br.iff.edu.kallevermaria.utilidades.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aluno
 */
public class Servlet extends HttpServlet {

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
        String nome = request.getParameter("nome") ;
        String sobrenome = request.getParameter("sobrenome") ;
        System.out.println("NomeCompleto: "+nome+" "+sobrenome+"");
        String senha = request.getParameter("senha") ;
        String NomeCompleto=("NomeCompleto: "+nome+" "+sobrenome+"");
       
         Usuario user= new Usuario();
         user.setNome(NomeCompleto);
         user.setSenha(senha);
         
         Double aleatorio = Math.random();
         BigDecimal id = new BigDecimal(aleatorio);
         user.setIdUsuario(id);
         
         Session sessaoBD = HibernateUtil.getSession();
        Transaction tr= sessaoBD.beginTransaction() ;
         sessaoBD.save(user);
         tr.commit();
         sessaoBD.close();
         
         response.sendRedirect("2410jsp.jsp");
         
                
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
