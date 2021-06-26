package cinema.system.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AuditoriumServiceTest.class, CinemaServiceTest.class, MovieServiceTest.class,
        ReservationServiceTest.class, ScreeningServiceTest.class, SeatServiceTest.class})
public class ServiceTestSuite {

}
