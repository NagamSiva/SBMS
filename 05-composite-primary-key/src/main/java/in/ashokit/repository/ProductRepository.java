package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Product;
import in.ashokit.entity.ProductPK;

public interface ProductRepository extends  JpaRepository<Product, ProductPK>{

}
