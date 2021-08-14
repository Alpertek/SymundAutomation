package com.symund.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/myReports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue="com/symund/step_definitions",
        dryRun = false,
        tags= "@SYMU-366"
)
public class CukesRunner {
}