package code.impl;

import code.ISortAlgorithm;

public class HeapISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private HeapISortAlgorithm() {}

	/**
	 * Sorts an array using the heap sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(target, n, i);
		}

		// One by one extract elements from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			swap(target, 0, i);

			// Call max heapify on the reduced heap
			heapify(target, i, 0);
		}
	}

	/**
	 * To heapify a subtree rooted with node i which is an index in target[].
	 *
	 * @param target The array to be heapified.
	 * @param n      The size of the heap.
	 * @param i      The index of the root of the subtree.
	 */
	private void heapify(T[] target, int n, int i) {
		int largest = i; // Initialize largest as root
		int left = 2 * i + 1; // left = 2*i + 1
		int right = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (left < n && target[left].compareTo(target[largest]) > 0) {
			largest = left;
		}

		// If right child is larger than largest so far
		if (right < n && target[right].compareTo(target[largest]) > 0) {
			largest = right;
		}

		// If largest is not root
		if (largest != i) {
			swap(target, i, largest);

			// Recursively heapify the affected sub-tree
			heapify(target, n, largest);
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
