package com.mycode.controller;

import com.mycode.model.Shop;
import com.mycode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveShop(@RequestBody Shop shop) {
        shopService.save(shop);
    }

    @GetMapping("/find")
    public ResponseEntity<Shop> findById(@RequestParam int id) {
        Shop shop = shopService.findById(id);
        if (shop != null) {
            return ResponseEntity.ok(shop);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Shop>> findAllShops() {
        List<Shop> shops = shopService.findAllShop();
        if (shops != null)
            return ResponseEntity.ok(shops);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable int id) {
        shopService.deleteById(id);

    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Shop> replaceShop(@RequestBody Shop shop, @PathVariable Integer id) {
        Shop replacedShop = shopService.replaceShop(shop, id);
        if (replacedShop != null)
            return ResponseEntity.ok(replacedShop);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findByArea")
    public ResponseEntity<List<String>> findByArea() {
        List<String> shopServiceByArea = shopService.findByArea();
        if (shopServiceByArea != null)
            return ResponseEntity.ok(shopServiceByArea);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getShopByAreaAndDiscount")
    public ResponseEntity<List<String>> getShopByAreaAndDiscount() {
        List<String> shopServiceByArea = shopService.getShopByAreaAndDiscount();
        if (shopServiceByArea != null)
            return ResponseEntity.ok(shopServiceByArea);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
