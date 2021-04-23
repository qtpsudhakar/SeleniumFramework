package com.karate.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
@KarateOptions(features = "classpath:KFeatures\\OhrmLogin.feature",tags = "login")
public class KTestRun {

}
