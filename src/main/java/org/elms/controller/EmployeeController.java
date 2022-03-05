package org.elms.controller;

import org.elms.dao.EmployeeDao;
import org.elms.dao.impl.EmployeeDaoImpl;
import org.elms.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeController", urlPatterns = {"/register"})
public class EmployeeController extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee-register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String faculty = request.getParameter("faculty");
        int absence = Integer.parseInt(request.getParameter("absence"));

        Employee employee = new Employee(firstName, lastName, faculty, absence);
        try {
            employeeDao.save(employee);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
