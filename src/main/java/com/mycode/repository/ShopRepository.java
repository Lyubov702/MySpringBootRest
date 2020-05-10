package com.mycode.repository;

import com.mycode.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(value = "SELECT name FROM shop e WHERE e.area ='Советский' OR e.area='Сормовский';", nativeQuery = true)
    List<String> findByArea();


    @Query(value = "SELECT s.id, s.name, s.area, s.commission FROM purchase p JOIN customer c ON p.customerId=c.id " +
            " JOIN shop s ON s.id=p.seller" +
            " WHERE s.area NOT LIKE 'Автозаводский' AND  c.discount  BETWEEN 10 AND 15;", nativeQuery = true)
    List<String> getShopByAreaAndDiscount();

}
