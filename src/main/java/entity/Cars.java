package entity;

public class Cars{
    private String vin;
    private String model;
    private String colour;

    public Cars() {
    }

    public Cars(String vin, String model, String colour) {
        this.vin = vin;
        this.model = model;
        this.colour = colour;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
