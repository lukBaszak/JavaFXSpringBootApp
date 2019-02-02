package com.lubaszak.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MacroProperties {
    private DoubleProperty calorie;
    private DoubleProperty protein;
    private DoubleProperty fat;
    private DoubleProperty carb;

    public final double getCalorie() {
        if(calorie!=null)
        return calorie.get();
        return 0;
    }


    public final void setCalorie(double calorie) {
        this.calorieProperty().set(calorie);
    }

    public final DoubleProperty calorieProperty() {
        if(calorie==null) {
            calorie = new SimpleDoubleProperty(0);
        }
        return calorie;
    }

    public double getProtein() {
        return protein.get();
    }

    public DoubleProperty proteinProperty() {
        if(protein==null) {
            protein = new SimpleDoubleProperty(0);
        }
        return protein;
    }

    public void setProtein(double protein) {
        this.proteinProperty().set(protein);
    }

    public double getFat() {
        return fat.get();
    }

    public DoubleProperty fatProperty() {
        if(fat==null) {
            fat = new SimpleDoubleProperty(0);
        }
        return fat;
    }

    public void setFat(double fat) {
        this.fatProperty().set(fat);
    }

    public double getCarb() {
        return carb.get();
    }

    public DoubleProperty carbProperty() {
        if(carb==null) {
            carb = new SimpleDoubleProperty(0);
        }
        return carb;
    }

    public void setCarb(double carb) {
        this.carbProperty().set(carb);
    }
}
