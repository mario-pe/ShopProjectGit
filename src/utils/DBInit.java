package utils; /**
 * Created by mario on 25.04.2017.
 */

import dao.*;
import model.Address;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

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
//        OrderDao orderDao = new OrderDao(em);
        ItemDao itemDao = new ItemDao(em);
        OrderItemDao orderItemDao = new OrderItemDao(em);
        PaymentDao paymentDao = new PaymentDao(em);
        ShippingDao shippingDao = new ShippingDao(em);
        StorehouseDao storehouseDao = new StorehouseDao(em);
        AdminDao adminDao = new AdminDao(em);
        NewOrderDao orderDao = new NewOrderDao(em);



        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("customerDao",customerDao);
        servletRequest.setAttribute("addressDao",addressDao);
//        servletRequest.setAttribute("orderDao", orderDao);
        servletRequest.setAttribute("itemDao", itemDao);
        servletRequest.setAttribute("orderItemDao", orderItemDao);
        servletRequest.setAttribute("paymentDao", paymentDao);
        servletRequest.setAttribute("shippingDao", shippingDao);
        servletRequest.setAttribute("storehouseDao", storehouseDao);
        servletRequest.setAttribute("adminDao", adminDao);
        servletRequest.setAttribute("orderDao", orderDao);

    }
}
