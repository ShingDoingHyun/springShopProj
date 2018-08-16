package com.bitcamp.op.product.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

	private int productNo;
	private String productName;
	private String productDetail;
	private String productImage;
	private String productType;
	private int productPrice;
	private int productOpt1;
	private int productOpt2;
	private MultipartFile photoFile;

	public ProductDTO() {
	}

	public ProductDTO(int productNo, String productName, String productDetail, String productImage, String productType,
			int productPrice, int productOpt1, int productOpt2) {
		this.productNo = productNo;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productImage = productImage;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productOpt1 = productOpt1;
		this.productOpt2 = productOpt2;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductOpt1() {
		return productOpt1;
	}

	public void setProductOpt1(int productOpt1) {
		this.productOpt1 = productOpt1;
	}

	public int getProductOpt2() {
		return productOpt2;
	}

	public void setProductOpt2(int productOpt2) {
		this.productOpt2 = productOpt2;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", productName=" + productName + ", productDetail="
				+ productDetail + ", productImage=" + productImage + ", productType=" + productType + ", productPrice="
				+ productPrice + ", productOpt1=" + productOpt1 + ", productOpt2=" + productOpt2 + "]";
	}

}
