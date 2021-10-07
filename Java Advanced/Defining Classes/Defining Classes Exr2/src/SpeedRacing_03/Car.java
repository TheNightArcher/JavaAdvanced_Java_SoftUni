package SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private int driveKm;

    public Car(String model, double fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
        this.driveKm = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDriveKm() {
        return driveKm;
    }

    public boolean requiredFuel(double distance) {

        double requiredFuel = fuelConsumption * distance;
        if (requiredFuel > this.fuelAmount) {
            return false;
        } else {
            this.fuelAmount -= requiredFuel;
            this.driveKm += distance;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.driveKm);
    }
}
