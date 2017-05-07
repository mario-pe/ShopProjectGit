package utils;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 03.05.2017.
 */
@WebFilter(filterName = "RoleFilter", value = "/shop")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setCharacterEncoding("utf-8");
        CustomerDao customerDao = (CustomerDao) request.getAttribute("customerDao");
        String login = request.getRemoteUser();
        Customer customer =(Customer) request.getSession().getAttribute("customer");
        String role = customerDao.getRoleByLogin(customer.getLogin());
        if(role.equals("customer")){
            request.getRequestDispatcher(request.getContextPath() + "/shop").forward(request,response);

        }
        else {
            request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
