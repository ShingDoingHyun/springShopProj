package com.bitcamp.op.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.op.product.model.ProductDTO;


public interface ProductDaoInterface {

	
	public List<ProductDTO> selectList( 
			@Param("firstRow") int firstRow, 
			@Param(value="endRow")  int endRow, 
			@Param(value="keyword") String keyword, 
			@Param(value="category") String category, 
			@Param(value="row_price") int row_price, 
			@Param(value="high_price") int high_price);
	public int selectCount(
			@Param(value="keyword") String keyword, 
			@Param(value="category") String category, 
			@Param(value="row_price") int row_price, 
			@Param(value="high_price") int high_price);
	public ProductDTO selectProduct(int productNo);
	public int insertProduct(ProductDTO productDto);
	public int updateProduct(ProductDTO productDto);
	public int deleteProduct(int productNo);
}
