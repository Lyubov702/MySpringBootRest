package com.mycode.service;

import com.mycode.model.Shop;
import com.mycode.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void save(Shop shop) {
        shopRepository.save(shop);
    }

    public List<Shop> findAllShop() {
        return shopRepository.findAll();
    }


    public Shop findById(int id) {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        return optionalShop.orElse(null);
    }

    public void deleteById( int id) {
        shopRepository.deleteById(id);
    }

    public Shop replaceShop(Shop newShop, Integer id) {
        return shopRepository.findById(id)
                .map(shop -> {
                    shop.setName(newShop.getName());
                    shop.setArea(newShop.getArea());
                    shop.setCommission(newShop.getCommission());
                    return shopRepository.save(shop);
                })
                .orElseGet(() -> {
                    newShop.setId(id);
                    return shopRepository.save(newShop);
                });
    }
    public List<String> findByArea(){
        return shopRepository.findByArea();
    }

    public List<String> getShopByAreaAndDiscount(){
        return shopRepository.getShopByAreaAndDiscount();
    }
}
