package com.fidexio.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
       features = "src/test/resources/features",
        glue = "com/fidexio/step_definitions",
        tags = "@wip",
        dryRun = false,
        publish = true
)
public class CukesRunner {
}
