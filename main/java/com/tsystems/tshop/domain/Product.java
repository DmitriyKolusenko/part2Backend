package com.tsystems.tshop.domain;

import com.tsystems.tshop.enums.ProductCategory;

public class Product {
	private Integer idgoods;
	private String goodsname;
	private Integer price;
	private Integer weight;
	private Integer instock;
	private String goodsparameters;
	private Integer volume;
	private Integer count;
	private Integer totalsaled;
	
	public Product() {}
	
	public Product(final Integer idgoods, final String goodsname,
			final Integer price,
			final Integer weight,
			final Integer instock,
			final String goodsparameters,
			final Integer volume) {
		super();
		this.idgoods = idgoods;
		this.goodsname = goodsname;
		this.price = price;
		this.weight = weight;
		this.instock = instock;
		this.goodsparameters = goodsparameters;
		this.volume = volume;
	}


	public Integer getIdgoods() {
		return idgoods;
	}

	public void setIdgoods(Integer idgoods) {
		this.idgoods = idgoods;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getInstock() {
		return instock;
	}

	public void setInstock(Integer instock) {
		this.instock = instock;
	}

	public String getGoodsparameters() {
		return goodsparameters;
	}

	public void setGoodsparameters(String goodsparameters) {
		this.goodsparameters = goodsparameters;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotalsaled() {
		return totalsaled;
	}

	public void setTotalsaled(Integer totalsaled) {
		this.totalsaled = totalsaled;
	}
}
