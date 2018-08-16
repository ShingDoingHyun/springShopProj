package com.bitcamp.op.product.model;

import java.util.List;

import com.bitcamp.op.product.model.ProductDTO;

public class ProductList {
	private int productTotalCount;// ��ü �޼�����
	private int currentPageNumber;// ���� ������
	private List<ProductDTO>  productList;
	private int pageTotalCount;// ��ü ��������
	private int productCountPerPage;//�����ڸ��� �޼��� ����
	private int firstRow;//�������� 1�� �޼���
	private int endRow;//�������� ������ �޼���
	
	public ProductList( List<ProductDTO> productList,int productTotalCount, int currentPageNumber,
			 int productCountPerPage, int firstRow, int endRow) {
		super();
		this.productTotalCount = productTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.productList = productList;
		this.productCountPerPage = productCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}


	public ProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}


	private void calculatePageTotalCount() {
		if (productTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = productTotalCount / productCountPerPage;
			if (productTotalCount % productCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}


	public int getProductTotalCount() {
		return productTotalCount;
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public List<ProductDTO> getProductList() {
		return productList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getProductCountPerPage() {
		return productCountPerPage;
	}


	public int getFirstRow() {
		return firstRow;
	}


	public int getEndRow() {
		return endRow;
	}


	@Override
	public String toString() {
		return "ProductList [productTotalCount=" + productTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", productList=" + productList + ", pageTotalCount=" + pageTotalCount + ", productCountPerPage="
				+ productCountPerPage + ", firstRow=" + firstRow + ", endRow=" + endRow + "]";
	}


}
