package com.epam.jmp.mm.task1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class MemoryEater {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        //List v = new ArrayList();
        while (true) {
            List v = new ArrayList();
            byte b[] = new byte[1048576];
            v.add(b);
            Runtime rt = Runtime.getRuntime();

            logger.info("free memory: " + rt.freeMemory());
            /*try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }*/
        }
    }
}