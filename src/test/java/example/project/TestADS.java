package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class TestADS {

    @Test
    public void testPrintPath() {
        //test if ads.printPath() prints the ADSPath.
        ADS ads = new ADS("dummy");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        ads.printPath();

        // assertion
        assertEquals("dummy", bos.toString().trim());

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testPredict() {
        //setup
        ADS ads = mock();
        Scenario scenario = new Scenario("special scenario leading to the prediction of [0, 0]");
        when(ads.predict(scenario)).thenReturn(Arrays.asList(0,0));

        // action
        List<Object> prediction = ads.predict(scenario);

        // assertion
        assertEquals(Arrays.asList(0, 0), prediction);

        verify(ads, times(1)).predict(scenario); // only call predict once
        verify(ads, times(0)).printPath(); // never called printPath
    }

}