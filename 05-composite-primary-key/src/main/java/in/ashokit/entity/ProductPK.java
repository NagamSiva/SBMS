package in.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductPK implements Serializable {

	private Integer productId;
	private String productName;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
