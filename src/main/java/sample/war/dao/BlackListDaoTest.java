package sample.war.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sample.war.dto.BlackList;

import java.util.Arrays;

@Component
@Profile({"test"})
@Scope("singleton")
public class BlackListDaoTest implements BlackListDao {
    private BlackList blackList = new BlackList(Arrays.asList("1"));

    @Override
    public BlackList get() {
        return blackList;
    }
}
