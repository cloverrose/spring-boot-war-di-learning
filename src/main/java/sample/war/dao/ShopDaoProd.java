package sample.war.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sample.war.dto.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Profile({"production"})
@Scope("singleton")
public class ShopDaoProd implements ShopDao {
    private List<Shop> shops;

    public ShopDaoProd() {
        shops = new ArrayList<>();
        for (int i = 0; i<100; i++) {
            shops.add(new Shop("" + i, "store " + i));
        }
    }

    @Override
    public List<Shop> getAll() {
        return shops;
    }

    @Override
    public Optional<Shop> selectById(String id) {
        for (Shop shop : shops) {
            if (shop.getId().equals(id)) {
                return Optional.of(shop);
            }
        }
        return Optional.empty();
    }
}
