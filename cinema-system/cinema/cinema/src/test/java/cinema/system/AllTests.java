package cinema.system;

import cinema.system.service.ServiceTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ServiceTestSuite.class})
public class AllTests {

}
