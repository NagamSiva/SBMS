package in.ashokit.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Product {
	
	private Long productPrice;
	
	@EmbeddedId
	private ProductPK productPK;

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public ProductPK getProductPK() {
		return productPK;
	}

	public void setProductPK(ProductPK productPK) {
		this.productPK = productPK;
	}

	@Override
	public String toString() {
		return "Product [productPrice=" + productPrice + ", productPK=" + productPK + "]";
	}
	
	
	
	

}
