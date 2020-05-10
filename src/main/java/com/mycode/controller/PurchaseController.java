package com.mycode.controller;

import com.mycode.model.Purchase;
import com.mycode.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void savePurchase(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
    }

    @GetMapping("/find")
    public ResponseEntity<Purchase> findById(@RequestParam int id) {
        Purchase purchase = purchaseService.findById(id);
        if (purchase != null) {
            return ResponseEntity.ok(purchase);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Purchase>> findAllPurchases() {
        List<Purchase> result = purchaseService.findAll();
        if (result != null)
            return ResponseEntity.ok(result);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable int id) {
        purchaseService.deleteById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Purchase> replacePurchase(@RequestBody Purchase purchase, @PathVariable Integer id) {
        Purchase replacedPurchase =  purchaseService.replacePurchase(purchase, id);
        if (replacedPurchase != null)
            return ResponseEntity.ok(replacedPurchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/retrieveByDate")
    public ResponseEntity<List<String>> retrieveByDate() {
        List<String> purchase = purchaseService.retrieveByDate();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getCustomerAndShop")
    public ResponseEntity<List<String>> getCustomerAndShop() {
        List<String> purchase = purchaseService.getCustomerAndShop();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getPurchase")
    public ResponseEntity<List<String>> getPurchase() {
        List<String> purchase = purchaseService.getPurchase();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/getPurchaseWithCustomerAndDate")
    public ResponseEntity<List<String>> getPurchaseWithCustomerAndDate() {
        List<String> purchase = purchaseService.getPurchaseWithCustomerAndDate();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getPurchaseByCustomerByArea")
    public ResponseEntity<List<String>> getPurchaseByCustomerByArea() {
        List<String> purchase = purchaseService.getPurchaseByCustomerByArea();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getPurchaseWithBookStorageNumberSum")
    public ResponseEntity<List<String>> getPurchaseWithBookStorageNumberSum() {
        List<String> purchase = purchaseService.getPurchaseWithBookStorageNumberSum();
        if (purchase != null)
            return ResponseEntity.ok(purchase);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
