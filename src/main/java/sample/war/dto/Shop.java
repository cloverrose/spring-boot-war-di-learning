package sample.war.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Shop {
    private String id;
    private String name;
}
