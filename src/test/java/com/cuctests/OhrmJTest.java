package com.cuctests;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/Features/Demo.feature",glue = {"com.cuc"})
public class OhrmJTest {

}
