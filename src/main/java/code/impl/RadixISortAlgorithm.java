package code.impl;

import code.ISortAlgorithm;

public class RadixISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private RadixISortAlgorithm() {}

	/**
	 * Sorts an array using the radix sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		if (target.length == 0) {
			return;
		}

		// Convert array to Integer array for radix sort
		Integer[] intArray = new Integer[target.length];
		for (int i = 0; i < target.length; i++) {
			intArray[i] = (Integer) target[i];
		}

		radixSort(intArray);

		// Convert back to generic type T
		for (int i = 0; i < target.length; i++) {
			target[i] = (T) intArray[i];
		}
	}

	/**
	 * Implements the radix sort algorithm for Integer array.
	 *
	 * @param target The array to be sorted.
	 */
	private void radixSort(Integer[] target) {
		// Find the maximum number to know number of digits
		int maxValue = findMaxValue(target);

		// Do counting sort for every digit. Note that instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; maxValue / exp > 0; exp *= 10) {
			countingSort(target, exp);
		}
	}

	/**
	 * Finds the maximum value in an Integer array.
	 *
	 * @param array The array to search for the maximum value.
	 *
	 * @return The maximum value in the array.
	 */
	private int findMaxValue(Integer[] array) {
		int max = array[0];
		for (int value : array) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	/**
	 * A utility function to do counting sort of array according to the digit represented by exp.
	 *
	 * @param array The array to be sorted.
	 * @param exp   The exponent representing the current digit place.
	 */
	private void countingSort(Integer[] array, int exp) {
		int n = array.length;
		int[] output = new int[n]; // output array
		int[] count = new int[10]; // count array for digits 0-9

		// Store count of occurrences in count[]
		for (Integer value : array) {
			count[(value / exp) % 10]++;
		}

		// Change count[i] so that count[i] now contains actual position of this digit in output[]
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Build the output array
		for (int i = n - 1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		}

		// Copy the output array to array[], so that array now contains sorted numbers according to current digit
		for (int i = 0; i < n; i++) {
			array[i] = output[i];
		}
	}
}
