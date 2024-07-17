package code.impl;

import code.ISortAlgorithm;

public class SelectionISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private SelectionISortAlgorithm() {}

	/**
	 * Sorts an array using the selection sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in the unsorted part of the array
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (target[j].compareTo(target[minIndex]) < 0) {
					minIndex = j;
				}
			}
			// Swap the found minimum element with the first element of the unsorted part
			swap(target, i, minIndex);
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
