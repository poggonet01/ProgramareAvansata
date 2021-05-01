import java.time.LocalTime;
import java.util.Map;

public class Hotel extends Location implements Visitable,Clasifiable {

    private double rank;
    private LocalTime openingTime, closingTime;

    public Hotel() {

    }
    public Hotel( double rank, LocalTime openingTime, LocalTime closingTime) {
        this.rank = rank;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    @Override
    public double getRank() {
        return this.rank;
    }

    @Override
    public LocalTime getOpeningTime() {
        return this.openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return this.closingTime;
    }
}
