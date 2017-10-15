package top.legend.repository.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by Legend on 2017/10/15.
 */
@Validated
@Data
@NoArgsConstructor
public class Role {
    @Min(value = 100,message = "最小为100")
    private Integer roleId;
    private List<Auth> auths;
}
