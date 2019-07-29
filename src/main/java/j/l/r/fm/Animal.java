package j.l.r.fm;

import lombok.Data;

/**
 * @author dongfei
 */
@Data
public abstract class Animal {
    /**
     * 栖息地
     */
    protected String habitat;

    /**
     * 年龄
     */
    private Integer age;

    public Double weight;
}
