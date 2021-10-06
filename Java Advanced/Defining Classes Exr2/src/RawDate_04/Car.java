package RawDate_04;

public class Car {
    String model;
    int enginePower;
    String carGoType;
    double tirePressure1;
    double tirePressure2;
    double tirePressure3;
    double tirePressure4;

    public Car(String model, int enginePower, String carGoType, double tirePressure1,
               double tirePressure2, double tirePressure3, double tirePressure4) {

        this.model = model;
        this.enginePower = enginePower;
        this.carGoType = carGoType;
        this.tirePressure1 = tirePressure1;
        this.tirePressure2 = tirePressure2;
        this.tirePressure3 = tirePressure3;
        this.tirePressure4 = tirePressure4;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCarGoType() {
        return carGoType;
    }

    public double getTirePressure1() {
        return tirePressure1;
    }

    public double getTirePressure2() {
        return tirePressure2;
    }

    public double getTirePressure3() {
        return tirePressure3;
    }

    public double getTirePressure4() {
        return tirePressure4;
    }
}
