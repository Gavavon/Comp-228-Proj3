package adts;

import interfaces.ListInterface;

public class Project3<E> implements ListInterface<E> {

	@Override
	public void add(E element) {
		// add object to dll, then sort
	}

	@Override
	public boolean remove(E element) {
		// remove object from dll (don't need to re-sort)
		return false;
	}

	@Override
	public int size() {
		// return size of dll
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(E element) {
		// return true if dll contains element
		return false;
	}

	@Override
	public E get(E element) {
		// 
		return null;
	}

	@Override
	public void resetIterator() {
		// 
		
	}

	@Override
	public E getNextItem() {
		// 
		return null;
	}

}
