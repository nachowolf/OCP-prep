package streams.optionals;
import java.util.Optional;

public class Knight {
    private Optional<String> sheath = Optional.empty();
    private Optional<String> canteen = Optional.of("Water");
    private Optional<String> coinPurse = Optional.ofNullable("Coins");
    private Optional<String> quiver = Optional.ofNullable("No Arrows");

    public String getQuiver() {
        return quiver.get();
    }

    public void setQuiver(String quiver) {
        this.quiver = Optional.ofNullable(quiver);
    }

    public String getSheath() {
        return sheath.get();
    }

    public String getCanteen() {
        return canteen.get();
    }

    public String getCoinPurse() {
        return coinPurse.get();
    }

    public static void main(String[] args) {

        Knight knight = new Knight();
        System.out.println(knight.getSheath());
        System.out.println(knight.getCoinPurse());
        System.out.println(knight.getCanteen());

        System.out.println( knight.getQuiver());
        knight.setQuiver("Iron arrows");
        System.out.println( knight.getQuiver());


    }
}
