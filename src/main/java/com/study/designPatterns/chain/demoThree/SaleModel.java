package main.java.com.study.designPatterns.chain.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 21:07
 * @description: 销售对象
 */
public class SaleModel {
    /**
     * 销售的商品
     */
    private String goods;
    /**
     * 销售的数量
     */
    private int saleNum;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return "商品名称=" + goods + ",销售数量=" + saleNum;
    }
}
