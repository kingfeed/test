
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 减法处理，数据错误问题，double 类型 转换成String可用
 */

public class SubTest {

    public static void doIt(){
        BigDecimal t1 = new BigDecimal(Double.toString(0.999951));
        System.out.println("t1======"+t1);
        BigDecimal t2 = new BigDecimal("1").subtract(new BigDecimal(Double.toString(0.999951)));
        System.out.println("t2======"+t2);
        BigDecimal t3 = new BigDecimal(Double.toString(t1.doubleValue())).setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println("t3======"+t3);
        BigDecimal t4 = new BigDecimal(Double.toString(t2.doubleValue())).setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println("t4======"+t4);
        /**
         * t1======0.999951 t1======0.999949
         * t2======0.000049 t2======0.000051
         * t3======1.0000 t3======0.9999
         * t4======0.0000 t4======0.0001
         */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        BigDecimal b1 = new BigDecimal(Double.toString(1.1099D));
        System.out.println("b1======"+b1);
        BigDecimal b2 = new BigDecimal(Double.toString(1.1109D));
        System.out.println("b2======"+b2);
        BigDecimal b3 = new BigDecimal(Double.toString(0.1050D));
        System.out.println("b3======"+b3);
        BigDecimal b4 = b1.add(b2).add(b3);
        System.out.println("b1+b2+b3======"+b4);
        /**
         * b1======1.1099
         * b2======1.1109
         * b3======0.1049  b3======0.1050
         * b1+b2+b3======2.3257  b1+b2+b3======2.3258
         */
        BigDecimal b1d = b1.divide(b4,6,BigDecimal.ROUND_HALF_UP);
        System.out.println("b1d======"+b1d);
        BigDecimal b2d = b2.divide(b4,6,BigDecimal.ROUND_HALF_UP);
        System.out.println("b2d======"+b2d);
        BigDecimal b3d = b3.divide(b4,6,BigDecimal.ROUND_HALF_UP);
        System.out.println("b3d======"+b3d);
        System.out.println("b1d+b2d+b3d======"+b1d.add(b2d).add(b3d));
        BigDecimal b4d = b4.divide(b4,6,BigDecimal.ROUND_HALF_UP);
        System.out.println("b4d======"+b4d);
        /**
         * b1d======0.477233 b1d======0.477212
         * b2d======0.477663 b2d======0.477642
         * b3d======0.045105 b3d======0.045146
         * b1d+b2d+b3d======1.000001 b1d+b2d+b3d======1.000000
         * b4d======1.000000 b4d======1.000000
         */
        BigDecimal b1d4 = b1.divide(b4,4,BigDecimal.ROUND_HALF_UP);
        System.out.println("b1d4======"+b1d4);
        BigDecimal b2d4 = b2.divide(b4,4,BigDecimal.ROUND_HALF_UP);
        System.out.println("b2d4======"+b2d4);
        BigDecimal b3d4 = b3.divide(b4,4,BigDecimal.ROUND_HALF_UP);
        System.out.println("b3d4======"+b3d4);
        System.out.println("b1d+b2d+b3d======"+b1d4.add(b2d4).add(b3d4));
        BigDecimal b4d4 = b4.divide(b4,4,BigDecimal.ROUND_HALF_UP);
        System.out.println("b4d======"+b4d);
        /**
         * b1d4======0.4772 b1d4======0.4772
         * b2d4======0.4777 b2d4======0.4776
         * b3d4======0.0451 b3d4======0.0451
         * b1d+b2d+b3d======1.0000 b1d+b2d+b3d======0.9999
         * b4d======1.000000 b4d======1.000000
         */
        BigDecimal b1m = b1d.multiply(new BigDecimal(Double.toString(33.3363D)));
        System.out.println("b1m======"+b1m);
        BigDecimal b2m = b2d.multiply(new BigDecimal(Double.toString(33.3363D)));
        System.out.println("b2m======"+b2m);
        BigDecimal b3m = b3d.multiply(new BigDecimal(Double.toString(33.3363D)));
        System.out.println("b3m======"+b3m);
        System.out.println("b1m+b2m+b3m======"+b1m.add(b2m).add(b3m));
        BigDecimal b4m = b4d.multiply(new BigDecimal(Double.toString(33.3363D)));
        System.out.println("b4m======"+b4m);
        BigDecimal b1m4 = b1d4.multiply(new BigDecimal(Double.toString(33.3363D))).setScale(4, RoundingMode.HALF_UP);
        System.out.println("b1m4======"+b1m4.doubleValue());
        BigDecimal b2m4 = b2d4.multiply(new BigDecimal(Double.toString(33.3363D))).setScale(4, RoundingMode.HALF_UP);
        System.out.println("b2m4======"+b2m4.doubleValue());
        BigDecimal b3m4 = b3d4.multiply(new BigDecimal(Double.toString(33.3363D))).setScale(4, RoundingMode.HALF_UP);
        System.out.println("b3m4======"+b3m4.doubleValue());
        BigDecimal b3m4s = new BigDecimal(Double.toString(33.3363D)).subtract(b1m4).subtract(b2m4);
        System.out.println("b3m4s======"+b3m4s.doubleValue());
        System.out.println("b1m4+b2m4+b3m4======"+b1m4.add(b2m4).add(b3m4));
        System.out.println("b1m4+b2m4+b3m4s======"+b1m4.add(b2m4).add(b3m4s));
        BigDecimal b4m4 = b4d4.multiply(new BigDecimal(Double.toString(33.3363D)));
        System.out.println("b4m======"+b4m);

        /**
         * b1m======15.9084823956
         * b2m======15.9228170046
         * b3m======1.5050005998
         * b1m+b2m+b3m======33.3363000000
         * b4m======33.3363000000
         * b1m4======15.9081
         * b2m4======15.9214
         * b3m4======1.5035
         * b3m4s======1.5068
         * b1m4+b2m4+b3m4======33.3330
         * b1m4+b2m4+b3m4s======33.3363
         * b4m======33.3363000000
         */
    }

    public static void main(String[] args) {

        doIt();
        //doSub();

    }

    private static void doSub() {
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
