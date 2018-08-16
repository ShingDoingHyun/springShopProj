package com.bitcamp.op.product.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.product.dao.ProductDaoInterface;
import com.bitcamp.op.product.model.ProductDTO;

public class ProductUpdateService {
	@Autowired
	SqlSessionTemplate template;

	private ProductDaoInterface productDao;
	
	public int updateProduct(ProductDTO productDto, HttpServletRequest request) throws IllegalStateException, IOException {
		productDao = template.getMapper(ProductDaoInterface.class);	
		int result = 0;
		String imgName = "";

		// 1. 저장 경로 설정
		String uploadUri = "/uploadFile/productImage";
		// 2. 시스템의 물리적인 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!productDto.getPhotoFile().isEmpty()) {
			imgName = System.currentTimeMillis() + productDto.getPhotoFile().getOriginalFilename();

			productDto.getPhotoFile().transferTo(new File(dir, imgName));

			productDto.setProductImage(imgName);
		}

		result =  productDao.updateProduct(productDto);
		
		
		return result;
	}
}
