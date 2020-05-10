package com.mycode.service;

import com.mycode.model.Purchase;
import com.mycode.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(int id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        return optionalPurchase.orElse(null);
    }

    public Purchase replacePurchase(Purchase newPurchase, Integer id) {
        return purchaseRepository.findById(id)
                .map(purchase -> {
                    purchase.setDate(newPurchase.getDate());
                    purchase.setSeller(newPurchase.getSeller());
                    purchase.setCustomerId(newPurchase.getCustomerId());
                    purchase.setBookId(newPurchase.getBookId());
                    purchase.setNumber(newPurchase.getNumber());
                    purchase.setSum(newPurchase.getSum());
                    return purchaseRepository.save(purchase);
                })
                .orElseGet(() -> {
                    newPurchase.setId(id);
                    return purchaseRepository.save(newPurchase);
                });
    }
    public void deleteById( int id) {
        purchaseRepository.deleteById(id);
    }


    public List<String> retrieveByDate() {
        return purchaseRepository.retrieveByDate();
    }

    public List<String> getCustomerAndShop() {
        return purchaseRepository.getCustomerAndShop();
    }

    public List<String> getPurchase() {
        return purchaseRepository.getPurchase();
    }

    public List<String> getPurchaseWithCustomerAndDate() {
        return purchaseRepository.getPurchaseWithCustomerAndDate();
    }

    public List<String> getPurchaseByCustomerByArea() {
        return purchaseRepository.getPurchaseByCustomerByArea();
    }

    public List<String> getPurchaseWithBookStorageNumberSum() {
        return purchaseRepository.getPurchaseWithBookStorageNumberSum();
    }



}
