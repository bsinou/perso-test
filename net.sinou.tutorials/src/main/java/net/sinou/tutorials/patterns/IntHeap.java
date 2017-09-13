package net.sinou.tutorials.patterns;

import java.util.Arrays;

public class IntHeap {
	
	private int capacity = 10;
	private int size = 10;

	int[] items = new int[capacity];

	public final static int MIN_HEAP = 1;
	public final static int MAX_HEAP = -1;

	private final int type;

	public IntHeap(int type) {
		this.type = type;
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;

	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0)
			throw new IllegalStateException("Heap is empty");
		return items[0];
	}

	public int poll() {
		if (size == 0)
			throw new IllegalStateException("Heap is empty");
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) * type > items[index] * type) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) * type < leftChild(index) * type) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (items[index] * type < items[smallerChildIndex] * type)
				break;
			else
				swap(index, smallerChildIndex);
			index = smallerChildIndex;
		}
	}
}
