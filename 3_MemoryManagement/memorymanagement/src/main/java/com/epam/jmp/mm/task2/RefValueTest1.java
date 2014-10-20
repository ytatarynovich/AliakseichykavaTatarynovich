package com.epam.jmp.mm.task2;

import org.apache.log4j.Logger;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class RefValueTest1 {
    static final Logger logger = Logger.getLogger(RefValueTest1.class);
    public static void main(String[] args) {
        int a = 0;
        int[] b = {20};
        a = f(a, g(a, b));
        logger.info(a + " " + b[0]);
    }

    private static int f(int a, int[] b) {
        a += 30;
        b[0] = 40;
        return 42;
    }

    private static int[] g(int a, int[] b) {
        a = 50;
        b = new int[]{60};
        return b;
    }
}


