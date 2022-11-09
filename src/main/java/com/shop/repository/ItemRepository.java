package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    // 상품이름으로 조회하기
    List<Item> findByItemName(String itemName);

    // 상품이름 or 상품디테일 = or 조건으로 조회하기
    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);

    //LessThan 조건으로 조회하기
    List<Item> findByPriceLessThan(Integer price);

    // Order By
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // JPQL 을 이용한 조회
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
