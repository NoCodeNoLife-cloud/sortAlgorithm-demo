package code.impl;
// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry, stay foolish
import code.ISortAlgorithm;

public class BubbleISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private BubbleISortAlgorithm() {}

	/**
	 * Sorts the target array using the bubble sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (target[j].compareTo(target[j + 1]) > 0) {
					swap(target, j, j + 1);
					swapped = true;
				}
			}
			// If no two elements were swapped by inner loop, then the array is sorted
			if (!swapped) break;
		}
	}

	/**
	 * Swaps the elements at the specified indices in the target array.
	 *
	 * @param target The array in which the swap operation is performed.
	 * @param left   The index of the first element to be swapped.
	 * @param right  The index of the second element to be swapped.
	 */
	private void swap(T[] target, int left, int right) {
		T temp = target[left];
		target[left] = target[right];
		target[right] = temp;
	}
}