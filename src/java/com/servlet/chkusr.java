/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class chkusr extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String us=request.getParameter("usr");
        String pw=request.getParameter("pwd");
        Connection con=null;
        String query=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","harish","hari917");
            query="select * from reg where USERNAME=? and PASSWORD=?";
            ps=con.prepareStatement(query);
            ps.setString(1,us);
            ps.setString(2,pw);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                response.sendRedirect("/mini-project/home.html");
               
            }
            else
            {
                 response.sendRedirect("/mini-project/register.html");
                           }
        }
        catch(Exception e){
             e.printStackTrace();       
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
}
