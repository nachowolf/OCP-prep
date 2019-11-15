package object_orientation.inheritance.bikes;

public class MountainBike extends Bicycle {

    public int seatHeight;

    public MountainBike(int candence, int gear, int speed, int seatHeight) {
        super(candence, gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setSeatHeight(int height){
        this.seatHeight = height;
    }
}
