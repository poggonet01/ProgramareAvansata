import java.time.LocalTime;

public class Restaurant extends Location implements Visitable{

    private LocalTime openingTime, closingTime;

    public Restaurant() {

    }
    public Restaurant(LocalTime openingTime, LocalTime closingTime) {

        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

}
