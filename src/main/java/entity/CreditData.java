package entity;

public class CreditData {
    private double limit;
    private Product product;
    private int period;

    public CreditData(double limit, Product product, int period) {
        this.limit = limit;
        this.product = product;
        this.period = period;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "limit=" + limit +
                ", product=" + product +
                ", period=" + period +
                '}';
    }
}
