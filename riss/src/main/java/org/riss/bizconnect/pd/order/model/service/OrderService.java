package org.riss.bizconnect.pd.order.model.service;

import org.riss.bizconnect.pd.order.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long orderCd);
    void updateOrder(OrderDTO order);
    void deleteOrder(Long orderCd);
}