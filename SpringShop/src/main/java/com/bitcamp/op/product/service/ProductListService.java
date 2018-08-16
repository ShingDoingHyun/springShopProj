package com.bitcamp.op.product.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.product.dao.ProductDaoInterface;
import com.bitcamp.op.product.model.ProductDTO;
import com.bitcamp.op.product.model.ProductList;

public class ProductListService {

	
	@Autowired
	SqlSessionTemplate template;
	
	private ProductDaoInterface productDao;
	private static final int PRODUCT_COUNT_PER_PAGE = 8;
	
	public ProductList getProductList(int pageNumber, String keyword, String category, int row_price, int high_price) {
		productDao = template.getMapper(ProductDaoInterface.class);
		
		System.out.println(keyword);
		
		int currentPageNumber = pageNumber > 0 ? pageNumber : 1; 
		
		int productTotalCount = productDao.selectCount(keyword, category, row_price, high_price);
		List<ProductDTO> productList = null;
		
		int firstRow = 0;
		int endRow = 0;
		if (productTotalCount > 0) {
			firstRow = (pageNumber - 1) * PRODUCT_COUNT_PER_PAGE;
			endRow = PRODUCT_COUNT_PER_PAGE;
			productList = productDao.selectList(firstRow, endRow, keyword, category, row_price, high_price);
		} else {
			currentPageNumber = 0;
			productList = Collections.emptyList();
		}
		System.out.println(firstRow+" "+endRow+ "출력" + currentPageNumber + PRODUCT_COUNT_PER_PAGE +"?"+productTotalCount);
		return new ProductList(productList, productTotalCount, currentPageNumber, PRODUCT_COUNT_PER_PAGE,
				firstRow, endRow);
		
	}
}
