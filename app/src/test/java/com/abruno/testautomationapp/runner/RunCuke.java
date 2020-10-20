package com.abruno.testautomationapp.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {"pretty", "json:target/RunCuke.json", "junit:target/RunCuke.xml"},
        glue = {"com.abruno.testautomationapp.steps"})
public class RunCuke {

}
