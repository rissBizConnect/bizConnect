package org.riss.bizconnect.pd.product.model.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.riss.bizconnect.pd.client.model.service.ClientService;
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
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("moveprMenu_product.do")
	public ModelAndView moveprMenu_product(HttpSession session, ModelAndView mv) {

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		mv.setViewName("pr/prMenubar/prMenu_product");
		ArrayList<ProductDTO> productList = productService.selectAll(myCom);

		mv.addObject("productList", productList);

		return mv;
	}
	
	@RequestMapping("moveProductInsert.do")
	public ModelAndView moveProductInsert(HttpSession session,
			ModelAndView mv) {
		
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);
		
		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		
		mv.setViewName("pr/stock/product/productInsert");
		
		ArrayList<ClientDTO> list = clientService.selectAll(myCom);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("productInsert.do")
	public String productInsert(
			HttpSession session, 
			ModelAndView mv,
			ProductDTO productDTO) {
		
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		productDTO.setLicenseCode(myCom);
		
		if(productService.insertProduct(productDTO) <= 0) {
			return "common/error";
		}

		return "redirect:moveprMenu_client.do";
		
	}
	
	@RequestMapping("productDelete.do")
	public String productDelete(
			HttpSession session, 
			@RequestParam("productNo") String productNo) {

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);

		ProductDTO product = new ProductDTO();
		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		product.setLicenseCode(myCom);
		product.setProductNo(Integer.parseInt(productNo));

		if (productService.deleteproduct(product) <= 0) {
			return "common/error";
		}

		return "redirect:moveprMenu_product.do";
	}
	
	@RequestMapping("moveProductUpdate.do")
	public ModelAndView moveProDuctUpdate(HttpSession session, ModelAndView mv,
			@RequestParam("productNo") String productNo) {
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);
		mv.setViewName("pr/stock/product/productUpdate");

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		ProductDTO product = new ProductDTO();
		product.setLicenseCode(myCom);
		product.setProductNo(Integer.parseInt(productNo));

		product = productService.selectProductOne(product);
		mv.addObject("product", product);

		return mv;
	}
	
	@RequestMapping("productUpdate.do")
	public String productUpdate(
			HttpSession session, 
			ProductDTO product,
			@RequestParam("proNo") String proNo) {

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
		session.setAttribute("loginUser", member);

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();

		logger.info("proNo : " + proNo);
		product.setLicenseCode(myCom);
		product.setProductNo(Integer.parseInt(proNo));
		logger.info("product : " + product);
		if(productService.update(product) <= 0) {
			return "common/error";
		}
		
		return "redirect:moveprMenu_product.do";
	}
}
