
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 减法处理，数据错误问题，double 类型 转换成String可用
 */
public class SubTest {

    public static void main(String[] args) {

        System.out.println(BigDecimal.valueOf(100));
        System.out.println(BigDecimal.valueOf(100.0001));
        System.out.println(new BigDecimal(Double.toString(100.0001D)));
        System.out.println(new BigDecimal(100.0001D));
        System.out.println(new BigDecimal(100.0001F));
        System.out.println(new BigDecimal(100.0001));
        System.out.println(12.301D-12.3D >0 );
        System.out.println(12.301D-12.3D >0 );
        System.out.println(12.2999991D-12.29999D > 0);
        BigDecimal.valueOf(123.384931D);
        List<ScmZbOutDetail> list = new ArrayList<>();
        ScmZbOutDetail detail1 = new ScmZbOutDetail();
        detail1.setGoodsQty(12.32454D);
        detail1.setGoodsId("1");
        ScmZbOutDetail detail2 = new ScmZbOutDetail();
        detail2.setGoodsQty(12.30);
        detail2.setGoodsId("1");
        ScmZbOutDetail detail3 = new ScmZbOutDetail();
        detail3.setGoodsQty(12.4567);
        detail3.setGoodsId("1");
        ScmZbOutDetail detail4 = new ScmZbOutDetail();
        detail4.setGoodsQty(10.4597D);
        detail4.setGoodsId("1");
        ScmZbOutDetail detail5 = new ScmZbOutDetail();
        detail5.setGoodsQty(101.3289D);
        detail5.setGoodsId("2");
        list.add(detail1);
        list.add(detail2);
        list.add(detail3);
        list.add(detail4);
        list.add(detail5);
        List<ScmZbOutDetail> scmZbOutDetailList = new ArrayList<>();

        list.stream().
                collect(Collectors.groupingBy(ScmZbOutDetail::getGoodsId)).forEach((k, v) -> {
            Optional<ScmZbOutDetail> sum = v.stream().reduce((v1, v2) -> {
                //v1.setGoodsQty(new BigDecimal(v1.getGoodsQty()).add(new BigDecimal(v2.getGoodsQty())).doubleValue());
                //return v1;
                double totalGoodsQty = new BigDecimal(v1.getGoodsQty()).add(new BigDecimal(v2.getGoodsQty())).doubleValue();
                ScmZbOutDetail result = new ScmZbOutDetail();
                try {
                    result.setGoodsId(v1.getGoodsId());
                    result.setGoodsQty(totalGoodsQty);
                } catch (Exception e) {
                }
                return result;
            });
            scmZbOutDetailList.add(sum.get());
        });
        for(ScmZbOutDetail detail:scmZbOutDetailList){
            System.out.println(detail);
        }
        Map<String, Double> goodsInsufficientMap = new HashMap<>();
        for (ScmZbOutDetail scmZbOutDetail : scmZbOutDetailList) {
            if (8.3043 < scmZbOutDetail.getGoodsQty()) {
                    goodsInsufficientMap.put(scmZbOutDetail.getGoodsId(),
                            new BigDecimal(Double.toString(scmZbOutDetail.getGoodsQty())).
                                    subtract(new BigDecimal(Double.toString((8.3043)))).doubleValue());
                    System.out.println("-----------"+new BigDecimal(scmZbOutDetail.getGoodsQty()).
                            subtract(new BigDecimal(8.3043)).doubleValue());
            }
        }
       System.out.println(goodsInsufficientMap);

        for ( ScmZbOutDetail outDetail :list){
            Double lackAmount = goodsInsufficientMap.get(outDetail.getGoodsId());
            if(lackAmount == null || lackAmount <=0D ) continue;
            double curGoodsQty = outDetail.getGoodsQty();
            System.out.println("Q+-----"+outDetail);
            if(curGoodsQty - lackAmount > 0D) {
                System.out.println("LA+----"+outDetail);
                outDetail.setGoodsQty(new BigDecimal(Double.toString(outDetail.getGoodsQty())).
                        subtract(new BigDecimal(Double.toString(lackAmount))).doubleValue());
                goodsInsufficientMap.put(outDetail.getGoodsId(),0D);
                System.out.println("VALUE2 ----"+new BigDecimal(Double.toString(lackAmount))+"-"+new BigDecimal(Double.toString(outDetail.getGoodsQty()))+"="+
                        (new BigDecimal(Double.toString(lackAmount)).
                                subtract(new BigDecimal(Double.toString(outDetail.getGoodsQty()))).doubleValue()));
            }else {
                System.out.println("TA----+---"+outDetail+"---"+lackAmount+"---"+new BigDecimal(Double.toString(lackAmount)));
                System.out.println("VALUE ----"+new BigDecimal(Double.toString(lackAmount))+"-"+new BigDecimal(Double.toString(outDetail.getGoodsQty()))+"="+
                        (new BigDecimal(Double.toString(lackAmount)).
                                subtract(new BigDecimal(Double.toString(outDetail.getGoodsQty()))).doubleValue()));
                goodsInsufficientMap.put(outDetail.getGoodsId(),(new BigDecimal(Double.toString(lackAmount)).
                        subtract(new BigDecimal(Double.toString(outDetail.getGoodsQty()))).doubleValue()));
                outDetail.setGoodsQty(0D);
            }
        }

        for(ScmZbOutDetail detail:list){
            System.out.println("END"+detail);
        }

    }




}
