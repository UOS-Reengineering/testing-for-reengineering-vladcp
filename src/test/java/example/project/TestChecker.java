package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import example.project.domain.Scenario;
import example.project.domain.SimulationResult;
import org.junit.jupiter.api.Test;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        Simulator simulator = mock();
        Scenario scenario = new Scenario();
        when(simulator.run(scenario)).thenReturn(new SimulationResult()); // return empty SimulationResult

        // testing target
        Checker checker = new Checker(simulator);
        boolean isCollision = checker.checkCollisionViolations(scenario); // now List<Snapshots> is not null
        assertEquals(false, isCollision);
    }

}