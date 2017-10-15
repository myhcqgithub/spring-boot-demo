package top.legend.repository.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Legend on 2017/10/15.
 */
@Data
@NoArgsConstructor
public class Role {
    private Integer roleId;
    private List<Auth> auths;
}
