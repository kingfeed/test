import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 物品追溯库存业务单据类型
 * @author dongfei
 */
@Getter
public enum GoodsTraceStockBillTypeEnum {

    SCM_IN_TYPE_PURCHASE(912, "采购入库"),
    SCM_IN_TYPE_PROFIT(913, "盘盈入库"),
    SCM_IN_TYPE_OTHER(914, "其他入库"),
    SCM_IN_TYPE_BACK(942, "配送退货入库"),
    SCM_IN_TYPE_DIS_WRITEOFF(950, "配送冲销入库"),
    SCM_IN_TYPE_INIT(953, "期初入库"),
    SCM_IN_TYPE_PRODUCT(955, "产品入库",GoodsTraceStockBillGroupEnum.PRODUCTION),
    SCM_IN_TYPE_SALE_BACK(988, "销售退货",GoodsTraceStockBillGroupEnum.SALE),
    SCM_IN_TYPE_TAKE_MATERISLS(992, "领料入库",GoodsTraceStockBillGroupEnum.PICKING_APPLY),
    SCM_IN_TYPE_DIRECT_SEND(999, "直送入库"),
    SCM_IN_TYPE_TAKE_MATERISLS_BACK(994,"领料退库",GoodsTraceStockBillGroupEnum.PRODUCTION),
    SCM_OUT_TYPE_INVENTORY_LOSS(915, "盘亏出库"),
    SCM_OUT_TYPE_OTHER(919, "其他出库"),
    SCM_OUT_TYPE_DIS(939, "配送出库"),
    SCM_OUT_TYPE_DIF_LOSS(945, "差异报损出库"),
    SCM_OUT_TYPE_PUR_RET(960, "采购退货出库"),
    SCM_OUT_TYPE_DIS_DIF(967, "配送差异出库"),
    SCM_OUT_TYPE_TAKE_MATERISLS(985, "领料出库",GoodsTraceStockBillGroupEnum.PICKING_APPLY),
    SCM_OUT_TYPE_SALE_ORDER(987, "销售出库",GoodsTraceStockBillGroupEnum.SALE),
    SCM_OUT_TYPE_PRODUCTION(993, "生产耗用",GoodsTraceStockBillGroupEnum.PRODUCTION),
    SCM_OUT_TYPE_TAKE_MATERISLS_BACK(995,"退料出库",GoodsTraceStockBillGroupEnum.PRODUCTION)
    ;

    /**
     * 单据类型编码
     */
    private Integer billTypeCode;

    /**
     * 单据类型名称
     */
    private String billTypeName;

    /**
     * 虚拟组
     */
    private GoodsTraceStockBillGroupEnum group;

    /**
     * Map容量
     * 当前枚举值21个，21/0.75+1 = 29
     * MAP容量初始值默认为2的幂
     * The default initial capacity - MUST be a power of two.
     * 本值取32
     */
    private static final int MAP_CAPACITY = 1 << 5 ;

  GoodsTraceStockBillTypeEnum(Integer billTypeCode, String billTypeName){
        this.billTypeCode = billTypeCode;
        this.billTypeName = billTypeName;
        this.group = GoodsTraceStockBillGroupEnum.OTHER;
    }

    GoodsTraceStockBillTypeEnum(Integer billTypeCode, String billTypeName, GoodsTraceStockBillGroupEnum group){
        this.billTypeCode = billTypeCode;
        this.billTypeName = billTypeName;
        this.group = group;
    }

    /**
     * 编码、名称键值对
     */
    private static Map<Integer,String> billTypeMap = new HashMap<>(MAP_CAPACITY);

    /**
     * 有序集合，按照插入顺序
     */
    private static Set<Map<String,Object>> billTypeSet = new LinkedHashSet<>(MAP_CAPACITY);
    /**
     * 编码、枚举值键值对
     */
    private static Map<Integer,GoodsTraceStockBillTypeEnum> enumCodeMap = new HashMap<>(MAP_CAPACITY);

    static {
        for (GoodsTraceStockBillTypeEnum goodsTraceBillTypeEnum : GoodsTraceStockBillTypeEnum.values()) {
            Map<String,Object> h = new HashMap<>(4);
            h.put("code",goodsTraceBillTypeEnum.getBillTypeCode());
            h.put("name",goodsTraceBillTypeEnum.billTypeName);
            billTypeSet.add(h);
            billTypeMap.put(goodsTraceBillTypeEnum.getBillTypeCode(), goodsTraceBillTypeEnum.getBillTypeName());
            enumCodeMap.put(goodsTraceBillTypeEnum.getBillTypeCode(),goodsTraceBillTypeEnum);
        }
    }

    /**
     * 编码、名称键值对
     * @return
     */
    public static Map<Integer,String> getBillTypeMap(){
        return billTypeMap;
    }

    /**
     * 有序集合，按照插入顺序
     * @return
     */
    public static Set<Map<String,Object>> getBillTypeSet(){
        return billTypeSet;
    }

    /**
     * 根据单据类型编码获取单据类型枚举项
     * @param billTypeCode
     * @return
     */
    public static GoodsTraceStockBillTypeEnum getEnumByCode(Integer billTypeCode) {
        return enumCodeMap.get(billTypeCode);
    }
}
