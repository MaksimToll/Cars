package ua.com.rentcar.entity;

import ua.com.rentcar.dao.Identified;

import java.sql.Timestamp;

/**
 * Created by maks on 21.01.2015.
 */
public class Car  implements Identified<Integer>{
    private int id;
    private String image;
    private int group;
    private int enabled;
    private String name;
    private String marka;
    private Timestamp lastUpdate;
    private String number;
    private String description;
    private double price;

    public Car(int id, String image, int group, int enabled, String name, String marka, Timestamp lastUpdate, String number, String description, double price) {
        this.id = id;
        this.image = image;
        this.group = group;
        this.enabled = enabled;
        this.name = name;
        this.marka = marka;
        this.lastUpdate = lastUpdate;
        this.number = number;
        this.description = description;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car() {

    }

    public Integer getId() {
        return new Integer(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
