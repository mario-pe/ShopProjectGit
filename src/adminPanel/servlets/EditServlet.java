package adminPanel.servlets;

import dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 03.05.2017.
 */
@WebServlet(name = "EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("hakuna matata");
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("add")) {
            response.getWriter().println("add");
        } else if (action.equals("delete"))
            response.getWriter().println("delete");
        else {
            request.setAttribute("item", itemDao.getItemById(id));
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/edit.jsp").forward(request, response);
        }
    }
}
