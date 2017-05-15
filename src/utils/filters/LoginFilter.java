package utils.filters;

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
@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setCharacterEncoding("utf-8");

        String login = request.getRemoteUser();

        if (login != null) {
            Customer customer = (Customer) request.getSession().getAttribute("customer");

            if (customer == null) {

                CustomerDao customerDao = (CustomerDao) req.getAttribute("customerDao");
                customer = customerDao.getCustomerByLogin(login);
                request.getSession().setAttribute("customer", customer);
            }
        }

        chain.doFilter(request, response);
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
