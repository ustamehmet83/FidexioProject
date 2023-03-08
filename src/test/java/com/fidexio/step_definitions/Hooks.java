package com.fidexio.step_definitions;

import com.fidexio.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown(){
        Driver.closeDriver();


    }
}
