package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void saveItemTest() {
        Item item = new Item();

        item.setItemName("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockCount(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        Item saveItem = itemRepository.save(item);

        System.out.println(saveItem.toString());

    }

    public void saveItemList() {
        for (int i = 0; i <= 10; i++) {
            Item item = new Item();

            item.setItemName("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockCount(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item saveItem = itemRepository.save(item);
        }
    }
    
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNameTest() {
        this.saveItemList();
        List<Item> itemList = itemRepository.findByItemName("테스트 상품1");

        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemNameOrItemDetailTest() {
        this.saveItemList();
        List<Item> itemList = itemRepository.findByItemNameOrItemDetail("테스트 상품1", "테스트 상품 상세설명");

        for (Item item: itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 조건 조회 테스트")
    public void findByPriceLessThanTest() {
        this.saveItemList();
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);

        for (Item item: itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 정렬 후 조회 테스트")
    public void findByPriceLessThanOrderByPriceDescTest() {
        this.saveItemList();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);

        for (Item item: itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("@Query 를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        this.saveItemList();
        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세설명");

        for (Item item: itemList) {
            System.out.println(item.toString());
        }
    }
}