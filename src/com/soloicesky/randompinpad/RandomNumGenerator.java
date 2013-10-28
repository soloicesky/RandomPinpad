/**
 * com.soloicesky.randomnumgenerator.RandomNumGenerator.java
 *Administrator @ 2013-10-28 ÏÂÎç4:52:27
 */
package com.soloicesky.randompinpad;

import java.util.ArrayList;
import java.util.Random;

/**
 * @filname RandomNumGenerator.java
 * @description
 * @author soloicesky
 * @data 2013-10-28 @time ÏÂÎç4:52:27
 */
public class RandomNumGenerator {

	public static ArrayList<Integer> generateRandomNumTable(int start, int end) {
		int index = 0;
		Random rdm;
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		ArrayList<Integer> resultNumTable = new ArrayList<Integer>();

		for (int i = start; i <= end; i++) {
			intArrayList.add(i);
		}

		for (int i = start; i < end; i++) {
			rdm = new Random(System.currentTimeMillis());
			index = rdm.nextInt(intArrayList.size());
			resultNumTable.add(intArrayList.get(index));
			intArrayList.remove(index);
		}

		resultNumTable.add(intArrayList.get(0));
		return resultNumTable;
	}
}
