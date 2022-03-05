package org.elms.controller;

import org.elms.dao.LoginDao;
import org.elms.dao.impl.LoginDaoImpl;
import org.elms.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name= "LoginFormController" , urlPatterns = {"/login"})
public class LoginFormController extends HttpServlet {

    private final LoginDao loginDao = new LoginDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException{
        String userName =req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();

        Login login = new Login();
        login.setUserName(userName);
        login.setPassword(password);

        HttpSession session = req.getSession();
        Login user = loginDao.validate(login);

        if(user!=null){
            session.setAttribute("firstName" , user.getFirstName());
            System.out.println(user.getFirstName());
            resp.sendRedirect("/ELMS/employee");
        } else {
            req.setAttribute("error-message" , "Sorry, you are not registered.");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

}
