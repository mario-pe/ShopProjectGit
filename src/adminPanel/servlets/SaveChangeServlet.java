package adminPanel.servlets;

import dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 04.05.2017.
 */
@WebServlet(name = "SaveChangeServlet", urlPatterns = "/save")
public class SaveChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");

        int id = Integer.parseInt(request.getParameter("id"));
        String producent = request.getParameter("prducent");
        String model = request.getParameter("model");
        String priceParam = request.getParameter("price");
        String stockParam = request.getParameter("stock");
        double price = -1;
        int stock = -1;
        if (priceParam.equals("")) {
            price = -1;
        } else {
            price = Double.parseDouble(priceParam);
        }
        if (stockParam.equals("")) {
            stock = -1;
        } else {
            stock = Integer.parseInt(stockParam);
        }

        itemDao.updateItemById(id, producent, model, price, stock);
        response.sendRedirect("/admin");
    }
}
