package com.aimprosoft.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty"},
        tags = "",
        features = "src/test/resources/feature",
        glue = "src/test/java/com/aimprosoft/definitions/"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {


}

