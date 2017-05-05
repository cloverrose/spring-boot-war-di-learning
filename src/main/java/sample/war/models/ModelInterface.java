package sample.war.models;

import sample.war.dto.Shop;

import java.util.List;

public interface ModelInterface {
    List<Shop> rerank(List<Shop> shops);
    List<Shop> filter(List<Shop> shops);
}
