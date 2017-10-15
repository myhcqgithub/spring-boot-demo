package top.legend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.legend.repository.po.User;

/**
 * Created by Legend on 2017/10/15.
 */
public interface UserRepository extends MongoRepository<User,String> {
}
