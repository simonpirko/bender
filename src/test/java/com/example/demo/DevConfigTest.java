package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevConfigTest {

    @Autowired
    private Environment environment;

    @Test
    public void setEnvironment(Type t) {
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
    }
}