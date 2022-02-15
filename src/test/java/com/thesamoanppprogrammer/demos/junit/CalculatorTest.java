package com.thesamoanppprogrammer.demos.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        //arrange
        int a = 10;
        int b = 20;

        //act
        int result = Calculator.add(a, b);

        //assert
        assertEquals(30, result);
    }
}

    //Adding descriptions to assertions
//    @Test
//    public void testAdd() {
//        //arrange
//
//        //act
//
//        //assert
//        assertNotNull(new Object());
//
//        //One fail fails the whole test
//        assertTrue(10 == 10, "Ten always equals ten");
//
//        assertNotEquals(1L, 2l);
//    }

//    @Test
//    public void testAdd() {
//        try {
//            //Give bad input
//            Assertions.fail("Failing the test");
//        } catch (ValidationException e) {
//            //Extra assertions on parameters and input etc
//        }
//    }

//assertThrows instead of @Test(expected = RuntimeException.class)
//    @Test
//    public void testAdd() {
//        assertThrows(RuntimeException.class,
//            ()->{
//                throw new RuntimeException("Oops!");
//            });
//    }

//    @Test
//    public void testAdd() {
//        throw new RuntimeException("Oops!");
//    }

    //Fail a test
//    @Test
//    public void testAdd() {
//        Assertions.fail("Failing the test");
//    }
