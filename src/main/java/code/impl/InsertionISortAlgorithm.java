package code.impl;// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry, stay foolish
import code.ISortAlgorithm;

public class InsertionISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private InsertionISortAlgorithm() {}

	/**
	 * Sorts an array using the insertion sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;
		for (int i = 1; i < n; ++i) {
			T key = target[i];
			int j = i - 1;

			// Move elements of target[0..i-1], that are greater than key,
			// to one position ahead of their current position
			while (j >= 0 && target[j].compareTo(key) > 0) {
				target[j + 1] = target[j];
				j = j - 1;
			}
			target[j + 1] = key;
		}
	}
}
