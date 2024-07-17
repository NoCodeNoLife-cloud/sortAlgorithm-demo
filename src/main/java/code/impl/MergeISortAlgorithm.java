package code.impl;

import code.ISortAlgorithm;

public class MergeISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private MergeISortAlgorithm() {}

	/**
	 * Sorts an array using the merge sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		mergeSort(target, 0, target.length - 1);
	}

	/**
	 * Implements the merge sort algorithm.
	 *
	 * @param target The array to be sorted.
	 * @param left   The starting index of the subarray to be sorted.
	 * @param right  The ending index of the subarray to be sorted.
	 */
	private void mergeSort(T[] target, int left, int right) {
		if (left < right) {
			// Find the middle point
			int middle = left + (right - left) / 2;

			// Sort first and second halves
			mergeSort(target, left, middle);
			mergeSort(target, middle + 1, right);

			// Merge the sorted halves
			merge(target, left, middle, right);
		}
	}

	/**
	 * Merges two subarrays of target[].
	 *
	 * @param target The array to be sorted.
	 * @param left   The starting index of the first subarray.
	 * @param middle The ending index of the first subarray.
	 * @param right  The ending index of the second subarray.
	 */
	private void merge(T[] target, int left, int middle, int right) {
		// Sizes of two subarrays to be merged
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Create temporary arrays
		@SuppressWarnings("unchecked")
		T[] leftArray = (T[]) new Comparable[n1];
		@SuppressWarnings("unchecked")
		T[] rightArray = (T[]) new Comparable[n2];

		// Copy data to temporary arrays
		System.arraycopy(target, left, leftArray, 0, n1);
		for (int j = 0; j < n2; j++) {
			rightArray[j] = target[middle + 1 + j];
		}

		// Merge the temporary arrays
		int i = 0, j = 0;
		int k = left; // Initial index of merged subarray
		while (i < n1 && j < n2) {
			if (leftArray[i].compareTo(rightArray[j]) <= 0) {
				target[k] = leftArray[i];
				i++;
			} else {
				target[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of leftArray[] if any
		while (i < n1) {
			target[k] = leftArray[i];
			i++;
			k++;
		}

		// Copy remaining elements of rightArray[] if any
		while (j < n2) {
			target[k] = rightArray[j];
			j++;
			k++;
		}
	}
}