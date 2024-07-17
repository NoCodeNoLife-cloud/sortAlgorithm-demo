package code.impl;// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry, stay foolish
import code.ISortAlgorithm;

import java.util.Random;

public class QuickISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private QuickISortAlgorithm() {}

	/**
	 * Sorts the given array using the quicksort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		quickSort(target, 0, target.length - 1);
	}

	/**
	 * Partitions the array around a pivot element.
	 *
	 * @param target The array to be partitioned.
	 * @param left   The starting index of the subarray to be partitioned.
	 * @param right  The ending index of the subarray to be partitioned.
	 *
	 * @return The index of the pivot element after partitioning.
	 */
	private int simplePartition(T[] target, int left, int right) {
		// Choose the rightmost element as the pivot
		T pivot = target[right];

		// Partition the array around the pivot
		int i = left - 1; // Index for the smaller elements
		for (int j = left; j < right; j++) {
			if (target[j].compareTo(pivot) < 0) {
				i++;
				swap(target, i, j);
			}
		}
		swap(target, i + 1, right); // Place the pivot at its final position

		return i + 1;
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

	/**
	 * Sorts an array of integers using the quicksort algorithm.
	 *
	 * @param target The array of integers to be sorted.
	 * @param left   The starting index of the subarray to be sorted.
	 * @param right  The ending index of the subarray to be sorted.
	 */
	private void quickSort(T[] target, int left, int right) {
		if (left < right) {
			int pivot = partition(target, left, right);
			quickSort(target, left, pivot - 1);
			quickSort(target, pivot + 1, right);
		}
	}

	/**
	 * Partitions the array around a randomly chosen pivot element.
	 *
	 * @param target The array to be partitioned.
	 * @param left   The starting index of the subarray to be partitioned.
	 * @param right  The ending index of the subarray to be partitioned.
	 *
	 * @return The index of the pivot element after partitioning.
	 */
	private int partition(T[] target, int left, int right) {
		Random random = new Random();
		int r = random.nextInt(right - left + 1) + left;
		swap(target, r, right);
		return simplePartition(target, left, right);
	}
}