

import java.util.Collection;
import java.util.Iterator;
import java.lang.reflect.Array;

public class TreeSet<E extends Comparable<E>> {
	
	AVLTree<E> tree = new AVLTree<>();

	public TreeSet() {
		super();
	}

	
	public int size() {
		return tree.getSize();
	}

	
	public boolean isEmpty() {
		return size() <= 0;
	}

	
	public boolean contains(Object o) {
		if (isEmpty()) return false;
		else if (tree.root.getClass().isInstance(o)) {
			return tree.search((E)o);
		}
		else return false;
		
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

	
	public boolean add(E e) {
		return tree.insert(e);
		
	}

	
	//optional
	
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return tree.delete(e);
	}

	
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(Collection<? extends E> c) { 
	    boolean added = false;
	    for (E e : c) {
	    	if (add(e)) {
	    		added = true; 
	    	}
	    }
	    return added;
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
	
	public void clear() {
		tree.clear();
		
		
	}

}
