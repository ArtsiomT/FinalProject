package by.epam.terehovich.internetprovider.entity;

import by.epam.terehovich.internetprovider.entity.Entity;

/**
 * Created by aterehovich on 24.7.15.
 */
public class TariffPlan extends Entity {
    private String name;
    private int licenseFee;
    private int speed;
    private int traffic;

    public TariffPlan(int id, String name, int licenseFee, int speed, int traffic){
        super(id);
        this.name = name;
        this.licenseFee = licenseFee;
        this.speed = speed;
        this.traffic = traffic;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(int licenseFee) {
        this.licenseFee = licenseFee;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
}
