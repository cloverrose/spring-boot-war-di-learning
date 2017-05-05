package sample.war.dao;

import sample.war.dto.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDao {
    List<Shop> getAll();

    Optional<Shop> selectById(String id);
}
