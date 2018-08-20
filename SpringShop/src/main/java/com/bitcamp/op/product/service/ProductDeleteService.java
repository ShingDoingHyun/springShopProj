package com.bitcamp.op.product.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.product.dao.ProductDaoInterface;

public class ProductDeleteService {
	@Autowired
	SqlSessionTemplate template;

	private ProductDaoInterface productDao;
	
	
	public int deleteProduct(int productNo) {
		productDao = template.getMapper(ProductDaoInterface.class);
		
		return productDao.deleteProduct(productNo);
		
	}
}
