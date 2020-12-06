


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

	
	public boolean contains(E e) {
		return tree.search(e);
		
	}

	
	public Iterator<E> iterator() {
		//Iterator<E> it = new Iterator<>() {

            //private int currentIndex = 0;

            //@Override
            //public boolean hasNext() {
                //return currentIndex < size() && this[currentIndex] != null;
            //}

            //@Override
            //public E next() {
                //return arrayList[currentIndex++];
            //}

            //@Override
            //public void remove() {
                //throw new UnsupportedOperationException();
            //}
        //};
        //return it;
		return tree.iterator();
	}

	
	public Object[] toArray() {
		tree.inorder();
		// TODO Auto-generated method stub
		return null;
	}

	
	public E[] toArray(E[] e) {
		E[] array = (E[]) new Object[size()];
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean add(E e) {
		// TODO Auto-generated method stub
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
	
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	//optional
	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
