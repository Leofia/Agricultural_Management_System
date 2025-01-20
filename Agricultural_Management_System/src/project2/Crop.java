/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author ANIL
 */
import java.util.Objects;

public abstract class Crop {
    private String name;
    private double weight;
    private String cultivatedSeason;

    public Crop(String name, double weight, String cultivatedSeason) {
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crop crop = (Crop) o;
        return Objects.equals(name, crop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract String toString();
    public abstract void consumeIt();
    public abstract void storeIt() throws CanNotBeStoredException;
}
