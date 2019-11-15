package object_orientation.inheritance.bikes;

public class Bicycle {

    public int candence,
                gear,
                speed;

    public Bicycle(int candence, int gear, int speed) {
        this.candence = candence;
        this.gear = gear;
        this.speed = speed;
    }

    public void setCandence(int candence) {
        this.candence = candence;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void speedUp(int speed) {
        this.speed += speed;
    }

    public void applyBrake(int speed) {
        this.speed -= speed;
    }
}
