package adminPanel.servlets;

import dao.ItemDao;
import dao.StorehouseDao;
import model.Item;
import model.Storehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 04.05.2017.
 */
@WebServlet(name = "AddItemServlet", urlPatterns = "/add_item")
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
        StorehouseDao storehouseDao = (StorehouseDao) request.getAttribute("storehouseDao");
        String producent = request.getParameter("producent");
        String model = request.getParameter("model");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int storehouseId = Integer.parseInt(request.getParameter("stroehouse"));

        Storehouse storehouse = storehouseDao.getStorehouseById(storehouseId);

        Item item = new Item();
        item.setProducent(producent);
        item.setModel(model);
        item.setPrice(price);
        item.setStock(stock);
        item.setStorehouse(storehouse);

        if (itemDao.addItem(item)) {
            request.setAttribute("info", "dodano produkt");
            request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);
        } else {
            request.setAttribute("info", "nie udało sie dodać produkt");
            request.getRequestDispatcher(request.getContextPath() + "/admin").forward(request, response);
        }

    }
}
