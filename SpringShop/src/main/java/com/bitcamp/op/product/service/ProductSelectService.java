package com.bitcamp.op.product.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.product.dao.ProductDaoInterface;
import com.bitcamp.op.product.model.ProductDTO;

public class ProductSelectService {
	@Autowired
	SqlSessionTemplate template;

	private ProductDaoInterface productDao;
	
	public ProductDTO selectProduct(int productNo) {
		productDao = template.getMapper(ProductDaoInterface.class);
		
		
		return productDao.selectProduct(productNo);
	}
}
