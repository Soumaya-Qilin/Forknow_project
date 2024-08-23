package fr.simplon.spring_security.service.impl;

import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.model.Shop;
import fr.simplon.spring_security.repository.ShopRepository;
import fr.simplon.spring_security.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void saveShop(ShopDto restaurant) {
        Shop restaurantEntity = Shop.builder()
                .name(restaurant.getName())
                .type(restaurant.getType())
                .build();
        shopRepository.save(restaurantEntity);
    }

    @Override
    public List<Shop> findAllShops() {
        return shopRepository.findAll();

//    public List<ShopDto> findAllShops() {
//        return shopRepository.findAll().stream()
//                .map(shop -> new ShopDto(shop.getName(), shop.getType()))
//                .collect(Collectors.toList());

    }




}
