

public class ScmZbOutDetail implements java.io.Serializable {
    private static final long serialVersionUID = -5705347318743117340L;
    private String goodsId;
    private Double goodsQty;

    public Double getGoodsQty() {
        return goodsQty;
    }

    public void setGoodsQty(Double goodsQty) {
        this.goodsQty = goodsQty;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return this.getGoodsId()+","+this.getGoodsQty();
    }
}