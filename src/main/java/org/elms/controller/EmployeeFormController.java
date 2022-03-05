package org.elms.controller;

import org.elms.dao.EmployeeDao;
import org.elms.dao.impl.EmployeeDaoImpl;
import org.elms.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeFormController", urlPatterns = {"/employee-save"})
public class EmployeeFormController extends HttpServlet {
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            if (id != null) {
                Employee employee = employeeDao.findOne(Integer.parseInt(id));
                request.setAttribute("employee", employee);
                request.setAttribute("action", "Update");
            } else {
                request.setAttribute("action", "Save");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("employee/employee-register-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id").trim();
        System.out.println(id);
        int result;
        try {
            Employee employee = new Employee();
            employee.setFirstName(request.getParameter("firstName"));
            employee.setLastName(request.getParameter("lastName"));
            employee.setFaculty(request.getParameter("faculty"));
            employee.setAbsence(Integer.parseInt(request.getParameter("absence")));

            if (id.length() != 0) {
                employee.setId(Integer.parseInt(id));
                result = employeeDao.update(employee);
            } else {
                result = employeeDao.save(employee);
            }

            if (result == 1) {
                response.sendRedirect("/ELMS/employee");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
