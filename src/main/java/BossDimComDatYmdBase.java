import lombok.Data;

/**
 * @ClassName: BossDimComDatYmdBase
 * @Description: 时间维度表—年月日(BossDimComDatYmdBase)实体类
 * @Author: RuiXin Yu
 * @Date: 2019/10/13 17:54
 */
@Data
public class BossDimComDatYmdBase {

    BossDimComDatYmdBase(String name){
        this.dayName = name;
    }

    /**
     * 日名称
     */
    private String dayName;
    
    /**
     * 日code
     */
    private Integer dayCode;

    /**
     * 周名称
     */
    private String weekName;
    
    /**
     * 周code
     */
    private Integer weekCode;
    
    /**
     * 月名称
     */
    private String monthName;
    
    /**
     * 月code
     */
    private Integer monthCode;
    
    /**
     * 年名称
     */
    private String yearName;
    
    /**
     * 年code
     */
    private Integer yearCode;

    
}