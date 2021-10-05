package Constructors_02;

public class CarConstructors {
    private  String brand;
    private  String model;
    private  int horsePower;

    public CarConstructors(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    public CarConstructors(String brand, int horsePower) {
      this(brand,"unknown",horsePower);
    }
    public CarConstructors(String brand) {
     this(brand,"unknown",-1);
    }



    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }
}
