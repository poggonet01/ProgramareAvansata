import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements Visitable{

    private LocalTime openingTime, closingTime;

    public Church() {

    }
    public Church( LocalTime openingTime, LocalTime closingTime) {
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
        return null;
    }

    @Override
    public LocalTime getClosingTime() {
        return null;
    }
}
