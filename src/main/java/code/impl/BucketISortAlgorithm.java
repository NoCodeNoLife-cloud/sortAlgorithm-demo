package code.impl;

import code.ISortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketISortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T> {
	private BucketISortAlgorithm() {}

	/**
	 * Sorts an array using the bucket sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	@Override
	public void sort(T[] target) {
		int n = target.length;

		// Find the maximum and minimum values in the array
		T maxValue = Collections.max(List.of(target));
		T minValue = Collections.min(List.of(target));

		// Calculate the range and number of buckets
		int range = (int) Math.ceil(maxValue.compareTo(minValue) + 1);
		int bucketCount = Math.max(range, 1);

		// Create buckets
		List<T>[] buckets = new List[bucketCount];
		for (int i = 0; i < bucketCount; i++) {
			buckets[i] = new ArrayList<>();
		}

		// Add elements to buckets
		for (T item : target) {
			int bucketIndex = (item.compareTo(minValue)) / range;
			buckets[bucketIndex].add(item);
		}

		// Sort individual buckets and place back into target array
		int index = 0;
		for (List<T> bucket : buckets) {
			Collections.sort(bucket);
			for (T value : bucket) {
				target[index++] = value;
			}
		}
	}
}
