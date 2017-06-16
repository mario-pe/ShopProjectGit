package adminPanel.servlets;

import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 15.05.2017.
 */
@WebServlet(name = "AdminWelcome Servlet", urlPatterns = "/welcome_ad")
public class AdminWelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        AdminDao adminDao = (AdminDao) request.getAttribute("adminDao");
        Cookie[] cookies = request.getCookies();
        String visitHistory = null;
        String orderBy = null;
        String group = null;

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            String name = cookie.getName();
            if (cookie.getName().equals("visitHistory")) {

                visitHistory = cookie.getValue();
            } else if (cookie.getName().equals("orderBy")) {
                orderBy = cookie.getValue();
            } else if (cookie.getName().equals("group")) {
                group = cookie.getValue();
            }
        }
        if (visitHistory != null && visitHistory.equals("http://localhost:8080/admin")) {
                request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);

        } else if (visitHistory != null && visitHistory.equals("http://localhost:8080/edit?action=add")) {
            request.getRequestDispatcher(request.getContextPath() + "/add_item").forward(request, response);


        } else if (visitHistory != null && visitHistory.equals("http://localhost:8080/edit?id=4&action=edit")) {
            request.getRequestDispatcher(request.getContextPath() + "/edit").forward(request, response);

        } else if (visitHistory != null && visitHistory.equals("http://localhost:8080/order_form")) {
            request.getRequestDispatcher(request.getContextPath() + "/order_form").forward(request, response);

        } else {
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/welcome_ad.jsp").forward(request, response);

        }
    }
}
