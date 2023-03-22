package example.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Scenario scenarioObj = (Scenario) obj;
        double egoCarDist = Math.sqrt(
                Math.pow(scenarioObj.initEgoCarPos.get(0) - initEgoCarPos.get(0), 2) +
                Math.pow(scenarioObj.initEgoCarPos.get(1) - initEgoCarPos.get(1), 2));
        double frontCarDist = Math.sqrt(
                Math.pow(scenarioObj.initCarInFrontPos.get(0) - initCarInFrontPos.get(0), 2) +
                Math.pow(scenarioObj.initCarInFrontPos.get(1) - initCarInFrontPos.get(1), 2));

        return roadType.equals(scenarioObj.roadType)
                && weatherCondition.equals(scenarioObj.weatherCondition)
                && egoCarDist <= 0.05
                && frontCarDist <= 0.05;

    }
}
