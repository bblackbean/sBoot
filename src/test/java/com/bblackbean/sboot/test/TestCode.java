package com.bblackbean.sboot.test;

import com.bblackbean.sboot.controller.HelloController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCode {
    @DisplayName("testJacoco")
    @Test
    public void cocoTest() {
        HelloController helloController = new HelloController();
        String args = "bblack";

        String ret = helloController.hello(args);
        assertEquals("bean", ret);
    }
}
