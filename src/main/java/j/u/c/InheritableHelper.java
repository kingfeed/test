package j.u.c;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongfei
 */
@Getter
@ToString
public class InheritableHelper {
    public InheritableHelper(){
        this.goodsPriceMap = new HashMap<>();
    }
    private Map<String, BigDecimal> goodsPriceMap;

}
