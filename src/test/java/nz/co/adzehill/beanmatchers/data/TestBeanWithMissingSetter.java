package nz.co.adzehill.beanmatchers.data;

public class TestBeanWithMissingSetter {

    private Object goodField;
    private Object badField;

    public Object getGoodField() {
        return goodField;
    }

    public void setGoodField(Object goodField) {
        this.goodField = goodField;
    }

    public Object getBadField() {
        return badField;
    }
}
