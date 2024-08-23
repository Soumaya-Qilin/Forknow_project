package fr.simplon.spring_security.service;

import fr.simplon.spring_security.dto.RegisterDto;

import fr.simplon.spring_security.dto.ShopDto;
import fr.simplon.spring_security.dto.UserDto;
import fr.simplon.spring_security.model.Shop;

import java.util.List;

public interface ShopService{
//       void saveShop(ShopDto restaurant);
    void saveShop(ShopDto shopMapping);

    List<Shop> findAllShops();
}