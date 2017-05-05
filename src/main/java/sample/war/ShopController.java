package sample.war;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.war.dao.ShopDao;
import sample.war.dto.Shop;
import sample.war.models.ModelInterface;

import java.util.List;
import java.util.Optional;

@RestController
public class ShopController {
    @Autowired
    ShopDao shopDao;

    @GetMapping("/shops")
    public List<Shop> shopAll() {
        List<Shop> shops = shopDao.getAll();
        return shops;
    }

    @GetMapping("/shops/{shopid}")
    public Shop shop(@PathVariable String shopid) {
        Optional<Shop> shop = shopDao.selectById(shopid);
        if (shop.isPresent()) {
            return shop.get();
        } else {
            return null;
        }
    }

    @GetMapping("/shops/ranking")
    public List<Shop> ranking(@RequestParam("model") String modelName) throws ClassNotFoundException {
        List<Shop> shops = shopDao.getAll();
        Class<ModelInterface> clazz = (Class<ModelInterface>) Class.forName("sample.war.models." + modelName);
        ModelInterface model = SampleWarApplication.ctx.getBean(clazz);
        return model.rerank(model.filter(shops));
    }
}
