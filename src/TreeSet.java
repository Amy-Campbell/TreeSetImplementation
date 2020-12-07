

import java.util.Collection;
import java.util.Iterator;
import java.lang.reflect.Array;

public class TreeSet<E extends Comparable<E>> {
	
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

	//@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean thisContainsAllOthers = true;
		boolean otherContainsAllThis = true;
		Iterator<E> itr = iterator();
		while (itr.hasNext()){
			
		}
		for (int i = 0; i< size(); i++) {
		
		}
		
		return this.equals(o);
		
	}
	

    
	//@SuppressWarnings("unchecked")
	//passed all tests
	public boolean contains(Object o) {
		//if (isEmpty()) return false;
		//else if (tree.root.getClass().isInstance(o)) {
			//return tree.search((E)o);
		//}
		//else return false;
		Object[] newArr = toArray();
		boolean contained = false;
		for (int i = 0; i<size(); i++) {
			if (newArr[i].equals(o)){
				contained = true;
			}
		}
		return contained;
		
	}

	public Iterator<E> iterator() {
		return tree.iterator();
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
	    //boolean added = false;
	    //for (E e : c) {
	    	//if (add(e)) {
	    		//added = true; 
	    	//}
	    //}
	    //return added;
		
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

}
