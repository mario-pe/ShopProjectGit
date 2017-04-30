package utils;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.04.2017.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        req.setCharacterEncoding("utf-8");
        String login = "aa";
//		String password;
//		String login = req.getRemoteUser();
        Customer customer = null;
        CustomerDao customerDao = null;
        if (login != null)
            customer = (Customer) request.getSession().getAttribute("customer");
        if (customer == null)
            customerDao = (CustomerDao) req.getAttribute("customerDao");
        customer = customerDao.getCustomerByLogin(login);
        request.getSession().setAttribute("customer", customer);
        if (request.getSession().getAttribute("customer") != null) {
            chain.doFilter(request, response);
        } else response.sendRedirect(request.getContextPath() + "/index");
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
