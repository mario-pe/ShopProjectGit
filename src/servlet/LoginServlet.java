package servlet;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        CustomerDao customerDao = (CustomerDao) request.getAttribute("customerDao");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Customer customer = customerDao.getCustomerByLogin(login);

        try {
            if (password.equals(customer.getPassword())) {
                response.sendRedirect(request.getContextPath() + "/shop");
                request.getSession().setAttribute("customer", customer);
            } else
                response.sendRedirect(request.getContextPath() + "/index");
        }catch (NullPointerException e){
            request.setAttribute("error","nie wpisałes hasła");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
    }

}
