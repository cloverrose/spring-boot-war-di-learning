package sample.war.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sample.war.dto.BlackList;

import java.util.Arrays;
import java.util.List;

@Component
@Profile({"production"})
@Scope("singleton")
public class BlackListDaoProd implements BlackListDao {
    private BlackList blackList;

    public BlackListDaoProd() {
        List<String> ids = Arrays.asList("1", "10", "100");
        blackList = new BlackList(ids);
    }

    @Override
    public BlackList get() {
        return blackList;
    }
}
