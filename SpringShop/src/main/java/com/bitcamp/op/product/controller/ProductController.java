package com.bitcamp.op.product.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.product.model.ProductDTO;
import com.bitcamp.op.product.service.ProductAddService;
import com.bitcamp.op.product.service.ProductListService;
import com.bitcamp.op.product.service.ProductSelectService;
import com.bitcamp.op.product.service.ProductUpdateService;

@Controller
public class ProductController {

	@Autowired
	ProductListService productListService;
	
	@Autowired
	ProductSelectService productSelectService;
	
	@Autowired
	ProductAddService productAddService;
	
	@Autowired
	ProductUpdateService productUpdateService;
	
	
	//사용자 영역
	
	//상품리스트, 조건들
	@RequestMapping("/product/productList")
	public String productList(Model model, 
			@RequestParam(value="page", defaultValue="1") int pageNumber,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="category", required=false) String category,
			@RequestParam(value="row_price", defaultValue="0") int row_price,
			@RequestParam(value="high_price", defaultValue="0") int high_price
			) {

		model.addAttribute("product", productListService.getProductList(pageNumber, keyword, category, row_price, high_price ));
		return "product/productList";
	}
	
	//상품상세
	@RequestMapping("/product/productDetail/{productNo}")
	public String productDetail(@PathVariable("productNo") int productNo, Model model) {
		
		model.addAttribute("productDTO", productSelectService.selectProduct(productNo));
		
		return "product/productDetail";
	}
	
	
	
	
	
	//관리자 영역
	
	//관리자 페이지 상품 리스트
	@RequestMapping("/product/productAdminList")
	public String productAdminList(Model model, 
			@RequestParam(value="page", defaultValue="1") int pageNumber,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="category", required=false) String category,
			@RequestParam(value="row_price", defaultValue="0") int row_price,
			@RequestParam(value="high_price", defaultValue="0") int high_price	
			) {

		model.addAttribute("product", productListService.getProductList(pageNumber, keyword, category, row_price, high_price ));
		return "product/productAdminList";
	}
	
	//관리자 상품추가폼
	@RequestMapping(value = "/product/productAdd", method = RequestMethod.GET)
	public String productAddForm() {
		return "product/productAdd";
	}
	
	//관리자 상품추가
	@RequestMapping(value = "/product/productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDto, HttpServletRequest request) throws Exception {
		productAddService.addProduct(productDto, request);
		
		return "redirect:/product/productAdminList";
	}
	
	//관리자 상품 수정폼
	@RequestMapping(value = "/product/productUpdate/{productNo}", method = RequestMethod.GET)
	public String productUpdateForm(@PathVariable("productNo") int productNo, Model model) {
		model.addAttribute("productDTO", productSelectService.selectProduct(productNo));
		return "product/productUpdate";
	}
	
	//관리자 상품 수정
	@RequestMapping(value = "/product/productUpdate", method = RequestMethod.POST)
	public String productUpdate(ProductDTO productDto, HttpServletRequest request) throws Exception {
		
		
		productUpdateService.updateProduct(productDto, request);
		return "redirect:/product/productAdminList";
	}
	
	
	//관리자 상품 삭제
	@RequestMapping(value = "/product/productDelete")
	public String productDelete() {
		
		
		return "redirect:/product/productAdminList";
	}
	

}
