package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Deque;

/**
 * Created by mario on 26.04.2017.
 */
@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
//        request.getSession().setAttribute("customer",null);
            request.getSession().removeAttribute("customer");

        Deque<String> visitHistory = (Deque<String>) request.getSession().getAttribute("visitHistory");
        String link = visitHistory.getLast();
        String orderBy = (String) request.getSession().getAttribute("orderBy");
        String group = (String) request.getSession().getAttribute("group");
        Cookie visitHistoryC = new Cookie("visitHistory", link);
        Cookie orderByC = new Cookie("orderBy", orderBy);
        Cookie groupC = new Cookie("group", group);
        visitHistoryC.setMaxAge(3600);
        orderByC.setMaxAge(3600);
        groupC.setMaxAge(3600);
        response.addCookie(visitHistoryC);
        response.addCookie(orderByC);
        response.addCookie(groupC);

        request.logout();
        response.sendRedirect(request.getContextPath()+"/index");
    }
}
