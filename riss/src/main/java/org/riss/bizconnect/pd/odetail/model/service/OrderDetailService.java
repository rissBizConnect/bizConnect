package org.riss.bizconnect.pd.odetail.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;

public interface OrderDetailService {

	int selectNxNo(String myCom);

	int insertOrderDetail(OrderDetail orderDetail);

	int deleteAll(OrderDetail orderDetail);

	ArrayList<OrderDetail> selectDivList(OrderDetail orderD);

	int updateOrderDetail(OrderDetail orderDetail);
}
