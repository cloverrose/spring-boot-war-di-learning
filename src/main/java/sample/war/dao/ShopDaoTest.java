package sample.war.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sample.war.dto.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Profile({"test"})
@Scope("singleton")
public class ShopDaoTest implements ShopDao {
    private List<Shop> shops = Arrays.asList(
      new Shop("1", "store a"), new Shop("2", "store b"), new Shop("3", "store c")
    );

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
