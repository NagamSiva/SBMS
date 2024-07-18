package in.ashokit.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private Long id;
	private String sku;
	private String name;
	private String description;
	private BigDecimal unit_price;
	private String image_url;
	private Boolean active;
	private Integer units_in_stock;
	private LocalDateTime date_created;
	private LocalDateTime last_updated;
	private Long category_id;
	
	
	public Product() {
	}


	public Product(Long id, String sku, String name, String description, BigDecimal unit_price, String image_url,
			Boolean active, Integer units_in_stock, LocalDateTime date_created, LocalDateTime last_updated,
			Long category_id) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unit_price = unit_price;
		this.image_url = image_url;
		this.active = active;
		this.units_in_stock = units_in_stock;
		this.date_created = date_created;
		this.last_updated = last_updated;
		this.category_id = category_id;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Integer getUnits_in_stock() {
		return units_in_stock;
	}


	public void setUnits_in_stock(Integer units_in_stock) {
		this.units_in_stock = units_in_stock;
	}


	public LocalDateTime getDate_created() {
		return date_created;
	}


	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}


	public LocalDateTime getLast_updated() {
		return last_updated;
	}


	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}


	public Long getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
	

	
}
