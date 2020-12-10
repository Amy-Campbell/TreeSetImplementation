
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

import java.lang.reflect.Array;

/**
 * Provides implementation for a set using a self-balancing tree as the
 * underlying structure
 * 
 * @author Amy Campbell, Thomas Williamson, Donat Matthys, Yicheng Zhang
 *
 */

public class TreeSet<E extends Comparable<E>> extends AbstractSet<E> implements Iterable<E> {

	AVLTree<E> tree = new AVLTree<>();

	/**
	 * constructor
	 */
	public TreeSet() {
		super();
	}

	/**
	 * returns the number of elements in the set
	 * 
	 * @return size
	 */
	public int size() {
		return tree.getSize();
	}

	/**
	 * returns true if set is empty
	 * 
	 * @return isEmpty
	 */
	public boolean isEmpty() {
		return size() <= 0;
	}

	/**
	 * Checks if the entered set is equivalent to this set
	 * 
	 * @param Object o
	 * @return sets are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean otherContainsAllThis = true;
		TreeSet<E> testSet = new TreeSet<>();

		// check that they're the same class
		if (o.getClass().isInstance(testSet)) {

			TreeSet<E> secondSet = (TreeSet<E>) o;
			Iterator<E> itr = iterator();
			Iterator<E> itr2 = secondSet.iterator();

			// check that they're the same size
			if (this.size() == secondSet.size()) {

				// check that they contain all the same elements
				while (itr.hasNext()) {
					if (!secondSet.contains(itr.next())) {
						otherContainsAllThis = false;
					}
				}
			} else {
				return false; // not the same size
			}
			return otherContainsAllThis; // return all elements are the same

		} else {
			return false; // unequal types
		}
	}

	/**
	 * Checks that this set contains specified element
	 * 
	 * @return contained
	 */
	public boolean contains(Object o) {
		Object[] newArr = toArray();
		boolean contained = false;
		for (int i = 0; i < size(); i++) {
			if (newArr[i].equals(o)) {
				contained = true;
			}
		}
		return contained;

	}

	/**
	 * Returns an array containing all of the elements in this set; the runtime type
	 * of the returned array is that of the specified array.
	 * 
	 * @return outArr
	 */
	@SuppressWarnings("unchecked")
	public <E> E[] toArray(E[] a) {
		if (isEmpty()) {
			for (int i = 0; i < a.length; i++) {
				a[i] = null;
			}
			return a;
		} else {
			@SuppressWarnings("rawtypes")
			E[] outArr;
			outArr = (E[]) Array.newInstance(tree.root.getClass(), size()); // create an array of generic type

			int position = 0;
			Iterator itr = iterator();
			while (itr.hasNext()) {
				outArr[position] = (E) itr.next();
				position += 1;

			}
			return outArr;
		}
	}

	/**
	 * Returns set as an array
	 * 
	 * @return outArr
	 */
	public Object[] toArray() {
		Object[] outArr = new Object[size()];
		Iterator<E> itr = iterator();
		int position = 0;

		// iterate through set
		while (itr.hasNext()) {
			outArr[position] = itr.next();
			position += 1;
		}

		return outArr;
	}

	/**
	 * Add specified element to the set
	 * 
	 * @param element e
	 */
	public boolean add(E e) {
		return tree.insert(e);

	}

	/**
	 * Remove specified element from the set
	 * 
	 * @param element e
	 */
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		if (tree.search(e)) {
			return tree.delete(e);
		} else {
			return false;
		}
	}

	/**
	 * Check that all elements in specified collection exist in this set
	 * 
	 * @param collection c
	 */
	public boolean containsAll(Collection<?> c) {
		boolean allContained = true;
		Object[] arr = c.toArray();
		if (arr.length == 0) {
			return false;
		} else {
			for (int i = 0; i < arr.length; i++) {
				allContained = contains((E) arr[i]);
			}
			return allContained;
		}

	}

	/**
	 * Add all specified elements to the set
	 * 
	 * @param Collection c
	 */
	@SuppressWarnings("unchecked")
	public boolean addAll(Collection<? extends E> c) {
		boolean allAdded = true;
		Object[] arr = c.toArray();
		for (int i = 0; i < arr.length; i++) {
			allAdded = add((E) (arr[i]));
		}
		return allAdded;
	}

	/**
	 * Retain only elements in specified collection
	 * 
	 * @param Collection c
	 */
	public boolean retainAll(Collection<?> c) {
		Iterator<E> itr = iterator();
		boolean successful = false;
		E element = null;
		if (c.size() == 0) {
			clear();
			return true;
		} else {
			while (itr.hasNext()) {
				element = itr.next();
				if (!c.contains(element)) {
					successful = remove(element);
				}

			}
			return successful;
		}
	}

	/**
	 * Remove all elements in specified collection from this set
	 * 
	 * @param Collection c
	 */
	public boolean removeAll(Collection<?> c) {
		boolean allRemoved = false;
		Object[] arr = c.toArray();
		if (arr.length == 0) {
			return false;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (tree.search((E) (arr[i]))) {
					allRemoved = remove((E) (arr[i]));
				}

			}
			return allRemoved;
		}

	}

	/**
	 * Remove all elements from this set
	 */
	public void clear() {
		tree.clear();

	}

	/**
	 * Returns an inorder iterator over this set
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0; // Point to the current element in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(tree.root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(AVLTreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.getLeft());
			list.add(root.getElement());
			inorder(root.getRight());
		}

		/** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		/** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}

		// Remove the element returned by the last next()
		public void remove() {
			if (current == 0) // next() has not been called yet
				throw new IllegalStateException();

			delete(list.get(--current));
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}

		private void delete(E e) {
			TreeSet.this.remove(e);

		}
	}

}
