package org.riss.bizconnect.pd.product.model.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.riss.bizconnect.pd.product.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("prMenu_product.do")
	public ModelAndView producthome(ModelAndView mv) {
		
		mv.setViewName("pr/prMenubar/prMenu_product");
		ArrayList<ProductDTO> product = productService.listAllProducts();
		
		mv.addObject("all", product);
		
		return mv;
	}
	
	@RequestMapping("product.do")
	public ModelAndView producttest(ModelAndView mv) {
		
		mv.setViewName("pr/stock/product/product");
		ArrayList<ProductDTO> product = productService.listAllProducts();
		
		mv.addObject("all", product);
		
		return mv;
	}
	
	@RequestMapping("insertproduct.do")
	public ModelAndView insertproduct(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		
	    Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager");//지워!!!!!!!!!!!!!!!!!!!!
	    session.setAttribute("loginUser", member);//너도!!!!!!!!!!!!!!!!!!!!!!!!
	     
	    member = (Member)session.getAttribute("loginUser");
		ProductDTO prod = new ProductDTO();

		prod.setLicenseCode(member.getComCode());

		String orderType = request.getParameter("orderType"); //발주/수주구분
		System.out.println("OrderType : " + orderType);
		
		if (orderType == null || orderType.trim().isEmpty()) {
			throw new IllegalArgumentException("OrderType is required.");
		}
		
	    String productNo = productService.generProductNo(orderType);
	    prod.setProductNo(productNo); // 생성된 제품번호 설정
		
		prod.setProductName(request.getParameter("ProductName"));
		String cri = request.getParameter("Cri"); //규격기준
		prod.setProductCri(cri); //규격기준 저장
		int cnt = 0; //제품수량
		try {
		    cnt = Integer.parseInt(request.getParameter("Cnt")); // 제품수량 변환
		} catch (NumberFormatException e) {
		    // 오류 처리: 파라미터가 숫자가 아닐 때
		    System.out.println("제품수량은 숫자로 입력해야 합니다.");
		}
		prod.setProductCnt(cnt); //제품수량 저장
		
		
		if ("size".equals(cri)) {
			prod.setProductSize(request.getParameter("ProductSize"));
		} else if ("weight".equals(cri)) {
			prod.setProductWeight(request.getParameter("ProductWeight"));
		} else if ("volume".equals(cri)) {
			prod.setProductVolume(request.getParameter("ProductVolume"));
		} //규격관련
		
		int iStock = 0;
		int cStock = 0;
	    try {
	        iStock = Integer.parseInt(request.getParameter("ProductiStock"));
	        cStock = Integer.parseInt(request.getParameter("ProductcStock"));
	    } catch (NumberFormatException e) {
	        System.out.println("재고 수량은 숫자로 입력해야 합니다.");
	    }
		
	    if(productService.insertproduct(prod) > 0) {
	        mv.setViewName("pr/stock/product/product");
	    } else {
	        mv.setViewName("common/error");
	    }
		
		if(productService.insertproduct(prod) > 0) {
			mv.setViewName("pr/stock/product/product");
		}else {
			mv.setViewName("common/error");
		}
		mv.setViewName("pr/stock/product/product");
		
		return mv;
	}
	
	
	
	@RequestMapping("filterProductStockStatus.do")
	public ModelAndView filterProductsByStockStatus(ModelAndView mv, HttpServletRequest request) {
	    String filterStatus = request.getParameter("filterStatus"); // 부족/안전 상태

	    ArrayList<ProductDTO> filteredProducts = productService.filterProductStockStatus(filterStatus);
	    
	    mv.addObject("filteredProducts", filteredProducts);
	    mv.setViewName("pr/stock/product/product"); // 필터링된 제품 목록을 보여줄 JSP
	    
	    return mv;
	}
	
}
