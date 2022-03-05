package org.elms.controller;

import org.elms.dao.EmployeeDao;
import org.elms.dao.impl.EmployeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeDisplayDeleteController", urlPatterns = {"/employee"})
public class EmployeeDisplayDeleteController extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try{
            if (id != null) {
                int result = employeeDao.delete(Integer.parseInt(id));
                if (result == 1) {
                    request.setAttribute("employees", employeeDao.findAll());
                    response.sendRedirect("/ELMS/employee");
                }
            } else {
                request.setAttribute("employees", employeeDao.findAll());
                request.getRequestDispatcher("/employee.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
