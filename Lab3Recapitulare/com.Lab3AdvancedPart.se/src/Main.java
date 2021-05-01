import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9,30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        m.setName("Museum");
        m.setCost(m,(int)m.getTicketPrice());

        Church c = new Church();
        c.setOpeningTime(LocalTime.of(11,0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        c.setName("Church");

        Restaurant r = new Restaurant();
        r.setOpeningTime(LocalTime.of(10,0));
        r.setClosingTime(LocalTime.of(20,0));
        r.setName("Restaurant");

        Location[] arr = {m,c,r};

        City city = new City(Arrays.asList(arr));
        city.VisitableNotPayable();

    }
}
