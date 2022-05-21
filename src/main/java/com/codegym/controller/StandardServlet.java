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

@WebServlet(name = "StandardServlet", value = "/standards")
public class StandardServlet extends HttpServlet {
    IStandardService standardService = new StandardService();
    ITypeService typeService = new TypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showListStandard(request, response);
        }
    }

    private void showListStandard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<House> houses = standardService.getHouseByIdStandardId(id);
        List<Standard> standards = standardService.findAll();
        List<Type> types = typeService.findAll();
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