package org.riss.bizconnect.pd.product.model.controller;

import java.sql.Date;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("product.do")
	public ModelAndView producttest(ModelAndView mv) {
		
		mv.setViewName("stock/product");
		ArrayList<ProductDTO> product = productService.listAllProducts();
		
		mv.addObject("all", product);
		
		return mv;
	}
	
	@RequestMapping("insertproduct.do")
	public ModelAndView insertproduct(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
	    session.setAttribute("loginUser", member);//너도!!!!!!!!!!!!!!!!!!!!!!!!
	     
	    member = (Member)session.getAttribute("loginUser");
		ProductDTO prod = new ProductDTO();

		prod.setLicenseCode(member.getComCode());
		
		prod.setProductNo(request.getParameter("ProductNo"));
		prod.setProductName(request.getParameter("ProductName"));
		prod.setProductSize(request.getParameter("ProductSize"));

		if(productService.insertproduct(prod) > 0) {
			mv.setViewName("stock/product");
		}else {
			mv.setViewName("common/error");
		}
		mv.setViewName("stock/product");
		return mv;
	}
	
}
