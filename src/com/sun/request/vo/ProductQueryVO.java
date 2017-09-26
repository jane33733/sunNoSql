package com.sun.request.vo;

public class ProductQueryVO {

	/** The product id. */
	private int productId;
	
	/** The price top. */
	private Integer priceTop;
	
	/** The price bottom. */
	private Integer priceBottom;

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * Gets the price top.
	 *
	 * @return the price top
	 */
	public Integer getPriceTop() {
		return priceTop;
	}

	/**
	 * Sets the price top.
	 *
	 * @param priceTop the new price top
	 */
	public void setPriceTop(Integer priceTop) {
		this.priceTop = priceTop;
	}

	/**
	 * Gets the price bottom.
	 *
	 * @return the price bottom
	 */
	public Integer getPriceBottom() {
		return priceBottom;
	}

	/**
	 * Sets the price bottom.
	 *
	 * @param priceBottom the new price bottom
	 */
	public void setPriceBottom(Integer priceBottom) {
		this.priceBottom = priceBottom;
	}

}
