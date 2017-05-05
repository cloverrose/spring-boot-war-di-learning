package sample.war.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.war.dao.BlackListDao;
import sample.war.dto.BlackList;
import sample.war.dto.Shop;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleModel implements ModelInterface {
    @Autowired
    private BlackListDao blackListDao;

    @Override
    public List<Shop> rerank(List<Shop> shops) {
        return shops;
    }

    @Override
    public List<Shop> filter(List<Shop> shops) {
        BlackList blackList = blackListDao.get();
        List<Shop> result = new ArrayList<>();
        for (Shop shop : shops) {
            if (!blackList.getIds().contains(shop.getId())) {
                result.add(shop);
            }
        }
        return result;
    }
}
