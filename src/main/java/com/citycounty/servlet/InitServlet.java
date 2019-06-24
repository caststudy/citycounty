package com.citycounty.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "InitServlet",loadOnStartup =1,urlPatterns ="/init" )
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        String  cityFile=    getServletContext().getRealPath("/")+"/WEB-INF/city.properties";
        try {
            Properties prop=new Properties();
            prop.load(new FileReader(cityFile));
            getServletContext().setAttribute("citykey", prop.keySet());
            getServletContext().setAttribute("city", prop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
