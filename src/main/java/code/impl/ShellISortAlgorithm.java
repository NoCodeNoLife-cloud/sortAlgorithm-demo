package code.impl;
// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry, stay foolish
import code.ISortAlgorithm;

public class ShellISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private ShellISortAlgorithm() {}

	/**
	 * Sorts the given array using the Shell Sort algorithm.
	 *
	 * @param target the array to be sorted
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				T temp = target[i];
				int j;
				for (j = i; j >= gap && target[j - gap].compareTo(temp) > 0; j -= gap) {
					target[j] = target[j - gap];
				}
				target[j] = temp;
			}
		}
	}
}
