package com.epam.jmp.mm.task2;

import org.apache.log4j.Logger;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class RefValueTest extends Object {
    static final Logger logger = Logger.getLogger(RefValueTest.class);

    public static void main(String[] args) {
        int a = 0;
        int[] b = {20};
        f(a, b);
        logger.info(a + " " + b[0]);
        g(a, b);
        logger.info(a + " " + b[0]);
    }

    private static void f(int a, int[] b) {
        a += 30;
        b[0] = 40;
    }

    private static void g(int a, int[] b) {
        a = 50;
        b = new int[]{60};
    }
}


