package entity;

public class Orders {
    private String vin;
    private int orderId;
    private String passportId;

    public Orders() {
    }

    public Orders(String vin, int orderId, String passportId) {
        this.vin = vin;
        this.orderId = orderId;
        this.passportId = passportId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString(){
        return "vin = "+vin+"; orderId = "+orderId+"; passportId = "+ passportId;
    }
}
