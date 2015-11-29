/**
 * 
 */
package com.grabkart.entity;

/**
 * @author Sundaram
 *
 */
public class Product {

	private long id;
	private String name;
	private String image;
	private Double price;
	private Integer quantity;
	private Integer visible;
	private long soldBy;

	public Product() {
		super();
	}

	public Product(String name, String image, double price, int quantity,
			int visible, long soldBy) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.visible = visible;
		this.soldBy = soldBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(long soldBy) {
		this.soldBy = soldBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + (int) (soldBy ^ (soldBy >>> 32));
		result = prime * result + visible;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (soldBy != other.soldBy)
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}
}
