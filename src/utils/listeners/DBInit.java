package utils.listeners; /**
 * Created by mario on 25.04.2017.
 */

import dao.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DBInit implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        EntityManager em = DBConfig.createEntityManager();
        AddressDao addressDao = new AddressDao(em);
        CustomerDao customerDao = new CustomerDao(em);
        ItemDao itemDao = new ItemDao(em);
        OrderItemDao orderItemDao = new OrderItemDao(em);
        PaymentDao paymentDao = new PaymentDao(em);
        ShippingDao shippingDao = new ShippingDao(em);
        StorehouseDao storehouseDao = new StorehouseDao(em);
        AdminDao adminDao = new AdminDao(em);
        OrderDao orderDao = new OrderDao(em);


        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("customerDao", customerDao);
        servletRequest.setAttribute("addressDao", addressDao);
        servletRequest.setAttribute("itemDao", itemDao);
        servletRequest.setAttribute("orderItemDao", orderItemDao);
        servletRequest.setAttribute("paymentDao", paymentDao);
        servletRequest.setAttribute("shippingDao", shippingDao);
        servletRequest.setAttribute("storehouseDao", storehouseDao);
        servletRequest.setAttribute("adminDao", adminDao);
        servletRequest.setAttribute("orderDao", orderDao);

    }
}
