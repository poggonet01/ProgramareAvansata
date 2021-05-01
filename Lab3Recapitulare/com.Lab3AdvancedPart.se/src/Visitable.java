import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    default Duration getVisitingDuration() {
        return Duration.between(getOpeningTime(),getClosingTime());
    }
}
