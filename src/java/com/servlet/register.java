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

public class register extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        String us=request.getParameter("usr");
        String em=request.getParameter("email");
        String pw=request.getParameter("pwd");
        String gen=request.getParameter("gender");
        String ctr=request.getParameter("country");
        response.setContentType("text/html");
                try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","harish","hari917");
            String query=("insert into reg values(?,?,?,?,?)");
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,us);
            ps.setString(2,em);
            ps.setString(3,pw);
            
            ps.setString(4,gen);
            ps.setString(5,ctr);
           
            int c = ps.executeUpdate();
            if(c>0)
            {
                out.print("UR REGISTERED SUCCESSFUFLLY.TO ACCESS PLEASE <a href=/mini-project/login.html>LOGIN</a>");
                       
            }
            else
            {
                out.print("Went Wrong.please<a href=/mini-project/register.html>sign up</a>");
            }            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }

    
  
}
