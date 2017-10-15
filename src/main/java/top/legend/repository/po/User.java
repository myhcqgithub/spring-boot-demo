package top.legend.repository.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Legend on 2017/10/15.
 */
@Data
@NoArgsConstructor
@Document(collection = "aop_user")
public class User {
    @Id
    private String id;
    private List<Role> roles;
}
