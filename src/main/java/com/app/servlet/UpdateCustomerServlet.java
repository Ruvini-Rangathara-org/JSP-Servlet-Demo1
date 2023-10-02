package com.app.servlet;

import com.app.controller.CustomerController;
import com.app.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        Customer customer = new Customer(Long.parseLong(id), name, address, Double.parseDouble(salary));

        if(new CustomerController().updateCustomer(customer)){
            System.out.println("Updated!");
            resp.sendRedirect("index .jsp");
        }else{
            System.out.println("error!");
        }


    }
}
