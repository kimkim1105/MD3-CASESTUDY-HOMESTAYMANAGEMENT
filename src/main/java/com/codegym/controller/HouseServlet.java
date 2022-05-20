package com.codegym.controller;

import com.codegym.model.House;
import com.codegym.service.house.HouseService;
import com.codegym.service.house.IHouseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HouseServlet", value = "/houses")
public class HouseServlet extends HttpServlet {
    IHouseService houseService = new HouseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateHouse(request, response);
                break;
            case "edit":
                showEditHouse(request,response);
                break;
            case "delete":
                try {
                    deleteHouse(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                showListHouse(request, response);
        }
    }

    private void deleteHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        houseService.delete(id);

        List<House> houses = houseService.findAll();
        request.setAttribute("houses", houses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("house/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        House house = houseService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/edit.jsp");
        request.setAttribute("house",house);
        requestDispatcher.forward(request,response);
    }

    private void showCreateHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<House> houses;
        if (name != null && name != ""){
            houses = houseService.findByName(name);
        } else {
            houses = houseService.findAll();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/list.jsp");
        request.setAttribute("houses",houses);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "create":
                    createHouse(request, response);
                    break;
                case "edit":
                    editHouse(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String designStyle = request.getParameter("designStyle");
        String address = request.getParameter("address");
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String basicUtility = request.getParameter("basicUtility");
        int standardId = Integer.parseInt(request.getParameter("standardId"));
        String status = request.getParameter("status");
        String image = request.getParameter("image");
        Float price = Float.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String extraUtility = request.getParameter("extraUtility");
        Float evalue = Float.valueOf(request.getParameter("evalue"));
        int countsOfOder = Integer.parseInt(request.getParameter("countsOfOder"));
        houseService.update(new House(id,name,typeId,designStyle,address,maxPeople,basicUtility,standardId,status,image,price,description,extraUtility,evalue,countsOfOder));
        RequestDispatcher dispatcher = request.getRequestDispatcher("house/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String designStyle = request.getParameter("designStyle");
        String address = request.getParameter("address");
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String basicUtility = request.getParameter("basicUtility");
        int standardId = Integer.parseInt(request.getParameter("standardId"));
        String status = request.getParameter("status");
        String image = request.getParameter("image");
        Float price = Float.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String extraUtility = request.getParameter("extraUtility");
        Float evalue = Float.valueOf(request.getParameter("evalue"));
        int countsOfOder = Integer.parseInt(request.getParameter("countsOfOder"));
        houseService.save(new House(name,typeId,designStyle,address,maxPeople,basicUtility,standardId,status,image,price,description,extraUtility,evalue,countsOfOder));
    }
}
