package io_and_no.tobias_motor_repairs.service_app.tracker;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String model;
    private String registration;
    private String colour;

    public Vehicle(String string) {
        String[] split = string.toLowerCase().split(",");

        this.model = split[0];
        this.registration = split[1];
        this.colour = split[2];
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


}
