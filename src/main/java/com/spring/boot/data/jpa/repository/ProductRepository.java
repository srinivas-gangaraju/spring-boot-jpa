package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     *
     * @param name
     * product name
     * @return the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null
     */
    public Product findByName(String name);

    /**
     *
     * @param id must not be {@literal null}.
     * @return an optional
     */
    Optional<Product> findById(Long id);

    /**
     *
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameOrDescription(String name, String description);
    /**
     *
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     *
     * @param name
     * @return
     */
    public Product findDistinctByName(String name);

    /**
     *
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     *
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     *
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);

    /**
     *
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);

    /**
     *
     * @param startPrice
     * @param endPrice
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     *
     * @param names
     * @return
     */
    List<Product> findByNameIn(List<String> names);

    /**
     *
     * @return
     */
    List<Product> findFirst2ByOrderByNameAsc();

    /**
     *
     * @return
     */
    List<Product> findTop3ByOrderByPriceDesc();

    /**
     *
     * @return
     */
    List<Product> findTop3ByOrderByPriceAsc();

    //Define JPQL query using @Query with index or position parameters
    @Query("SELECT p from Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);


    //Define JPQL query using @Query with named param
    @Query("SELECT p from Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,@Param("description") String description);

    //Define JPQL query using @Query with named param
    @Query(value = "SELECT * from products p where p.name = ?1 or p.description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    //Define JPQL query using @Query with named param
    @Query(value = "SELECT * from products p where p.name = :name or p.description = :description", nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,@Param("description") String description);

    //Define named JPQL query

    Product findByPrice(@Param("price") BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    @Query(nativeQuery = true)
    List<Product> findAllOrderByPriceAsc();
}
