package clyderide;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DriverSuiteTests.class,
        VehicleSuiteTests.class,
        RideQuoteSuiteTests.class
})
public class ClydeRideTestSuite {
}