

import java.util.Collection;
import java.util.Iterator;



import java.lang.reflect.Array;

public class TreeSet<E extends Comparable<E>> implements Iterable<E>{
	
	AVLTree<E> tree = new AVLTree<>();

	public TreeSet() {
		super();
	}

	//passed all tests
	public int size() {
		return tree.getSize();
	}

	
	//passed all tests
	public boolean isEmpty() {
		return size() <= 0;
	}

	
	//passed all tests
	//@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean thisContainsAllOthers = true;
		boolean otherContainsAllThis = true;
		//if (tree.root.getClass().isInstance(o)) {
		TreeSet<E> testSet = new TreeSet<>();
		
		//check that they're the same class
		if (o.getClass().isInstance(testSet)) {
			
			TreeSet<E> secondSet = (TreeSet<E>)o;
			Iterator<E> itr = iterator();
			Iterator<E> itr2 = secondSet.iterator();
			
			//check that they're the same size
			if(this.size() == secondSet.size()) {
				
				//check that they contain all the same elements
				while (itr.hasNext()) {
					if (!secondSet.contains(itr.next())) {
						otherContainsAllThis = false;
					}
				}
			}
			else {
				return false; //not the same size
			}
			return otherContainsAllThis; //return all elements are the same
			
			
		}
		else {
			return false; //unequal types
		}
	}
	

    
	//@SuppressWarnings("unchecked")
	//passed all tests
	public boolean contains(Object o) {
		Object[] newArr = toArray();
		boolean contained = false;
		for (int i = 0; i<size(); i++) {
			if (newArr[i].equals(o)){
				contained = true;
			}
		}
		return contained;
		
	}

	
	

	
	public <E> E[] toArray(E[] a) {
		if (isEmpty()) {
			for (int i = 0; i<a.length; i++) {
				a[i] = null;
			}
			return a;
		}
		else {
			@SuppressWarnings("rawtypes")
		    E[] outArr;
		    outArr = (E[])Array.newInstance(tree.root.getClass(), size()); // create an array of generic type 
		    
		    
			int position = 0;
			Iterator itr = iterator();
			while(itr.hasNext()) {
				outArr[position] = (E) itr.next();
			}
		    return outArr;
		}
	}
		
	
	//passed all tests
	public Object[] toArray() {
		Object[] outArr = new Object[size()];
		Iterator<E> itr = iterator();
		int position = 0;
		while(itr.hasNext()) {
			outArr[position] = itr.next();
			position += 1;
		}
		
		return outArr;
	}

	//passed all tests
	public boolean add(E e) {
		return tree.insert(e);
		
	}

	
	//optional
	//passed all tests
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return tree.delete(e);
	}

	
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(Collection<? extends E> c) { 
		
		return false;
	}

	//optional
	
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	//optional
	
	
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	//optional
	
	//passed all tests
	public void clear() {
		tree.clear();
		
		
	}

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
