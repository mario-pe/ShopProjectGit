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
        response.setContentType("text/plain;charset=utf-8");

        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        String action = request.getParameter("action");

        // servlet were admin actions are redirect to different .jsp pages with necessary attributes
        if (action.equals("add")) {
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/add.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (itemDao.deleteItemById(id))
                request.setAttribute("info", "produkt o numrze " + id + " został usunięty");
            else
                request.setAttribute("info", " operacja usuniecia produkt o numrze " + id + " niepowiadła sie ");
            request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);

        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("item", itemDao.getItemById(id));
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/admin/edit.jsp").forward(request, response);
        }
    }
}
