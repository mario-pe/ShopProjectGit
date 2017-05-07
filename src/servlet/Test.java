package servlet;

import dao.*;
import model.*;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Created by mario on 25.04.2017.
 */
@WebServlet(name = "Test", urlPatterns = "/test")
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("witaj na servlecie   /aa ");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();

        CustomerDao customerDao = (CustomerDao) request.getAttribute("customerDao");
        AddressDao addressDao = (AddressDao) request.getAttribute("addressDao");
//        OrderDao orderDao = (OrderDao) request.getAttribute("orderDao");
        PaymentDao paymentDao = (PaymentDao) request.getAttribute("paymentDao");
        ShippingDao shippingDao = (ShippingDao) request.getAttribute("shippingDao");
//        ItemDao itemDao = (ItemDao) request.getAttribute("itemDao");
//        OrderItemDao orderItemDao = (OrderItemDao) request.getAttribute("orderItemDao");
        StorehouseDao storehouseDao = (StorehouseDao) request.getAttribute("storehouseDao");
        OrderDao orderDao = (OrderDao) request.getAttribute("orderDao");
//        Customer customer = customerDao.getCustomerByLogin("aa");

//        Customer customer = customerDao.getCustomerById(122);
//        pw.println(customer.getPassword());

        Customer customer1 = new Customer();
        customer1.setPassword("w");
        customer1.setFirstName("testRole");
        customer1.setLastName("MD5");
        customer1.setLogin("w");
        if( customerDao.addCustomer(customer1))
        pw.println("dodano cutomer");
        else pw.println("nie dodano customer");


        if(customerDao.addRole(customer1))
            pw.println("dodano role");
        else pw.println("nie dodano role");


//            pw.println(customer.getFirstName());
//        for(Address a: customer.getAddresses())
//            pw.println(" z adressu " + a.getCity());
//        for(Order o: customer.getOrders())
//            pw.println("z orderu "+ o.getId());
//
//        Order order= orderDao.getNewOrderById(21);
//        for(OrderItem oi: order.getOrderItems())
//            pw.println("Order Items z 21 " + oi.getId() );



//        Payment payment= paymentDao.getPaymentById(1);
//        Shipping shipping = shippingDao.getShippingById(1);
//        Storehouse storehouse = storehouseDao.getStorehouseById(2);

//        Timestamp date = new Timestamp(new Date().getTime());
//        pw.println("Stock magazyn "+ storehouse.getStock());
//        response.getWriter().println('\n' + "DANE DO ZAMOWIENIA");
//        response.getWriter().println("data  " + date );
//        response.getWriter().println(shipping.getType());
//        response.getWriter().println(shipping.getPrice());
//        response.getWriter().println(payment.getType());
//      List<Order>  ol = orderDao.getOrds();
//      List<Item>  oi = itemDao.getItems();

//      for(Item o: oi)
//          pw.println("item id" + o.getId());

//        Order order = new Order();
//


//        Storehouse storehouse = new Storehouse();
//        storehouse.setStock(5000);
//        storehouseDao.addStorehouse(storehouse);




//        List<Cart> cart = new ArrayList<>();
//
//        Item item = itemDao.getItemById(11);
//
//        if( item != null)
//            pw.println("item 11 z bazy");
//        else pw.println("nie udało sie z 11");
//
//
//        Item item1 = itemDao.getItemById(15);
//        if( item1 != null)
//            pw.println("item 11 z bazy");
//        else pw.println("nie udało sie z 12");
//
//        pw.println(item1.getId());
//        pw.println(item1.getModel());
//        pw.println(item1.getProducent());
//        pw.println(item1.getPrice());
//



//        Cart cartProdukt = new Cart();
//        cartProdukt.setItemId(item.getId());
//        cartProdukt.setModel(item.getModel());
//        cartProdukt.setProducent(item.getProducent());
//        cartProdukt.setPrice(item.getPrice());
//        cartProdukt.setQuantity(5);
//
//        pw.println(cartProdukt.getItemId());
//        pw.println(cartProdukt.getModel());
//        pw.println(cartProdukt.getProducent());
//        pw.println(cartProdukt.getPrice());
//        pw.println(cartProdukt.getQuantity());
//
//        Cart cartProdukt2 = new Cart();
//        cartProdukt2.setItemId(item1.getId());
//        cartProdukt2.setModel(item1.getModel());
//        cartProdukt2.setProducent(item1.getProducent());
//        cartProdukt2.setPrice(item1.getPrice());
//        cartProdukt2.setQuantity(4);
//
//        cart.add(cartProdukt);
//        cart.add(cartProdukt2);
//
//        OrderItem orderItem = new OrderItem();
//
//        orderItem.setItem_id(cartProdukt2.getItemId());
//        orderItem.setProducent(cartProdukt2.getProducent());
//        orderItem.setModel(cartProdukt2.getModel());
//        orderItem.setPrice(cartProdukt2.getPrice());
//        orderItem.setQuantity(cartProdukt2.getQuantity());
////        orderItem.setOrder(order);
//        orderItemDao.addOrderItem(orderItem);


//        for(Cart c: cart){
//            orderItem.setItem_id(c.getItemId());
//            orderItem.setProducent(c.getProducent());
//            orderItem.setModel(c.getModel());
//            orderItem.setPrice(c.getPrice());
//            orderItem.setQuantity(c.getQuantity());
//            orderItem.setOrder(order);
//            orderItemDao.addOrderItem(orderItem);
//        }



//        Customer customer1 = new Customer();
//        customer1.setPassword("order");
//        customer1.setFirstName("Custr");
//        customer1.setLastName("Idea");
//        customer1.setLogin("CustIdear");
//        if( customerDao.addCustomer(customer1))
//        pw.println("dodano cutomer");
//        else pw.println("nie dodano customer");

//        Address address = new Address();
//        address.setCity("miasto11");
//        address.setStreet("stan1");
//        address.setStreet("ulica1");
//        address.setHouse("nr dom");
//        address.setZip("18-200");
//        address.setCustomer(customer);
//        if(addressDao.addAddress(address))
//              pw.println("dodano address");
//        else pw.println("nie dodano address");


//        Payment payment = new Payment();
//        payment.setType("raty");
//        paymentDao.addPayment(payment);
//
//        Shipping shipping = new Shipping();
//        shipping.setType("express");
//        shipping.setPrice(35.25);
//        shippingDao.addShipping(shipping);

//        Storehouse storehouse = new Storehouse();
//        storehouse.setStock(5000);
//        storehouseDao.addStorehouse(storehouse);

//        Item item = new Item();
//        item.setProducent("mario");
//        item.setModel("the best");
//        item.setPrice(25.25);
//        item.setStock(10);
//        item.setStorehouse(storehouse);
//        itemDao.addItem(item);

//        order.setDate(date);
//        order.setWholeValue(1500.90);
//        order.setShipping(shipping.getType());
//        order.setShippingCost(shipping.getPrice());
//        order.setPayment(payment.getType());
//        order.setCustomer(customer);
//
//        if(newOrderDao.addOrder(order)){
//            pw.println("dodano order");
//        }
//        else pw.println("nie dodano order");


    }
}
