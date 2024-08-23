package fr.simplon.spring_security.repository;

import fr.simplon.spring_security.model.Shop;
import fr.simplon.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
