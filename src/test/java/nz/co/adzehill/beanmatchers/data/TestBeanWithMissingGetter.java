package nz.co.adzehill.beanmatchers.data;

public class TestBeanWithMissingGetter {

    private Object goodField;
    private Object badField;

    public Object getGoodField() {
        return goodField;
    }

    public void setGoodField(Object goodField) {
        this.goodField = goodField;
    }

    public void setBadField(Object badField) {
        this.badField = badField;
    }
}
