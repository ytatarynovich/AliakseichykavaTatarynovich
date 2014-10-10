package com.epam.jmp.gc.apptorun;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 * 
 * Just for running
 */
public class GCInformation {

	private static final Logger log = Logger.getLogger(GCInformation.class);

	public static void main(String[] args) {

		printAllGarbageCollectors();
	}

	private static void printAllGarbageCollectors() {
		try {
			List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();

			for (GarbageCollectorMXBean gcMxBean : gcMxBeans) {
				log.info("GC: " + gcMxBean.getName() + " - " + gcMxBean.getObjectName());
			}

		} catch (RuntimeException re) {
			throw re;
		} catch (Exception exp) {
			throw new RuntimeException(exp);
		}
	}

}
