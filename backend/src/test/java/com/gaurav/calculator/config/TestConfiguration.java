package com.gaurav.calculator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "com.gaurav.calculator.service",
    "com.gaurav.calculator.validator",
    "com.gaurav.calculator.web.controller"
})
public class TestConfiguration {

}
