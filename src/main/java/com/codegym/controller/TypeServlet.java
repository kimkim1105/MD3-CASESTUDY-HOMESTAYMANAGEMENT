package com.codegym.controller;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.model.Type;
import com.codegym.service.standard.IStandardService;
import com.codegym.service.standard.StandardService;
import com.codegym.service.type.ITypeService;
import com.codegym.service.type.TypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TypeServlet", value = "/types")
public class TypeServlet extends HttpServlet {
    ITypeService typeService = new TypeService();
    IStandardService standardService = new StandardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showListTypes(request, response);
        }
    }

    private void showListTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<House> houses = typeService.getHouseByIdTypeId(id);
        List<Type> types = typeService.findAll();
        List<Standard> standards = standardService.findAll();
        request.setAttribute("houses",houses);
        request.setAttribute("types",types);
        request.setAttribute("standards",standards);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/list.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}