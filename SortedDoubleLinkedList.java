package _solution;

import java.util.ListIterator;
/**
 * 
 * @author Omar Mahmud
 *
 * @param <T> - Creates an empty list that is associated with the specified comparato
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	java.util.Comparator<T> comp = null;
// Creates an empty list that is associated with the specified comparator.

	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
		comp = comparator2;
	}

//Inserts the specified element at the correct position in the sorted list.
	/**
	 * 
	 * @param elem - the data to be added to the list
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T elem) {
		if (elem == null) {
			return this;
		}

		Node newnode = new Node(elem, null, null);
		if (header == null) {
			header = tail = new Node(elem, null, null);
		} else {
			if (comp.compare(elem, header.item) <= 0) {
				newnode.next = header;
				header = newnode;
			} else if (comp.compare(elem, tail.item) >= 0) {
				tail.next = newnode;
				tail = newnode;
			} else {
				Node next = header.next;
				Node prev = header;
				while (comp.compare(elem, next.item) > 0) {
					prev = next;
					next = next.next;
				}
				prev.next = newnode;
				newnode.next = next;
			}
		}
		size++;
		return this;
	}

	@Override
	
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException();
	}
// Implements the remove operation by calling the super class remove method.
/**
 * @param the data element to be removed
 * @param the comparator to determine equality of data elements
 */
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
		Node next = header;
		Node prev = null;
		while (next != null) {
			if (comparator.compare(next.item, data) == 0) {
				size--;
				if (prev != null) {
					prev.next = next.next;
				} else {
					header = next.next;
				}
				if (next == tail) {
					tail = prev;
				}
			}
			prev = next;
			next = next.next;
		}

		return this;

	}
/**
 * @return an iterator positioned at the head of the list
 */
	public ListIterator<T> iterator() {
		return new iter();
	}
}