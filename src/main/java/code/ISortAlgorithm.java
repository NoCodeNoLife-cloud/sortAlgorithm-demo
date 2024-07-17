package code;// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry, stay foolish

public interface ISortAlgorithm<T extends Comparable<T>> {
	/**
	 * Sorts the target array using the sort algorithm.
	 *
	 * @param target The array to be sorted.
	 */
	void sort(T[] target);
}
