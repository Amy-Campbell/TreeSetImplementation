


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

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

	
	public E[] toArray(E[] a) {
		E[] array = (E[]) new Object[size()];
		Iterator<E> itr = iterator();
		int position = 0;
		while(itr.hasNext()) {
			array[position] = itr.next();
		}
		return array;
	}

	
	public boolean add(E e) {
		return tree.insert(e);
		
	}

	//optional
	
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return tree.delete(e);
	}

	
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(Collection<? extends E> c) { 
	    boolean modified = false;
	    for (E e : c) if (add(e)) modified = true; 
	    return modified;
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
