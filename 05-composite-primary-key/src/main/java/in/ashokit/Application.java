package in.ashokit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Product;
import in.ashokit.entity.ProductPK;
import in.ashokit.repository.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepository bean = context.getBean(ProductRepository.class);
		/*
		 * ProductPK pk = new ProductPK(); pk.setProductId(10001);
		 * pk.setProductName("Books");
		 * 
		 * Product product = new Product(); product.setProductPrice(500l);
		 * product.setProductPK(pk);
		 * 
		 * bean.save(product);
		 */

		ProductPK pk = new ProductPK();
		pk.setProductId(10001);
		pk.setProductName("Books");
		
		Optional<Product> findById = bean.findById(pk);
		System.out.println(findById.get());
	}

}
