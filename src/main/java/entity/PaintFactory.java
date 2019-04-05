package entity;

public class PaintFactory {
    private int factoryId;
    private String paint;

    public PaintFactory() {
    }

    public PaintFactory(int factoryId, String paint) {
        this.factoryId = factoryId;
        this.paint = paint;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }
}
