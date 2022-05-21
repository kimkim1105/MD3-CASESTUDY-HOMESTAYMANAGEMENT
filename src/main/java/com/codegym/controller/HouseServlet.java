package com.codegym.controller;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.model.Type;
import com.codegym.service.house.HouseService;
import com.codegym.service.house.IHouseService;
import com.codegym.service.standard.IStandardService;
import com.codegym.service.standard.StandardService;
import com.codegym.service.type.ITypeService;
import com.codegym.service.type.TypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.sort;

@WebServlet(name = "HouseServlet", value = "/houses")
public class HouseServlet extends HttpServlet {
    IHouseService houseService = new HouseService();
    IStandardService standardService = new StandardService();
    ITypeService typeService = new TypeService();
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
        List<Standard> standards= standardService.findAll();
        List<Standard> standards1 = standardService.findAllStandardfromHouses(houses);
        List<Type> types = typeService.findAll();
        List<Type> types1 = typeService.findAllTypefromHouses(houses);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/list.jsp");
        request.setAttribute("houses",houses);
        request.setAttribute("standards",standards);
        request.setAttribute("standard1",standards1);
        request.setAttribute("types",types);
        request.setAttribute("types1",types1);
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
                case "sort":
                    softByPrice(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void softByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("select");
        List<House> houses = null;
        if (key.equals("one")){
            houses = houseService.sorfPriceUnder1000();
        } else if (key.equals("two")){
            houses = houseService.sorfPrice1000to2000();
        } else if (key.equals("three")){
            houses = houseService.sorfPriceOver2000();
        }
        request.setAttribute("houses",houses);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("house/list.jsp");
        requestDispatcher.forward(request,response);
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
