package org.riss.bizconnect.pd.order.model.dao;

import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import java.util.List;

public interface OrderDAO{
    void createOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long orderCd);
    void updateOrder(OrderDTO order);
    void deleteOrder(Long orderCd);
}