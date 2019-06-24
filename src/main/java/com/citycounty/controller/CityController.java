package com.citycounty.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Controller
@RequestMapping("/city")
public class CityController {
     @RequestMapping(value = "/getcity")
    public  @ResponseBody Set<Object> getCity(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Set city=  (Set) request.getServletContext().getAttribute("citykey");
        return  city;
    }
    @RequestMapping(value = "/getcounty")
    public   void getCity(HttpServletRequest request,HttpServletResponse response,String city) throws IOException {
       Properties  prop= (Properties) request.getServletContext().getAttribute("city");
         response.getWriter().print(prop.getProperty(city));
    }


}
