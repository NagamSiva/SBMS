package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.ashokit.entity.Book;

@RepositoryRestResource(path = "book")
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	//http://localhost:8080/book/search/findByNameContaining?name=a
	public List<Book> findByNameContaining(@Param("name") String name);
	
	//http://localhost:8080/book/search/findNameById?id=101
	@Query(value = "select name from Book where id=:id")
	public String findNameById(@Param("id") Integer id);

}
