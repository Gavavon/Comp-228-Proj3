package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
public class Project3<E> implements ListInterface<E> {
	
	DLLNode<E> head;
	DLLNode<E> tail;
	int numElements = 0;
	
	boolean found;
	DLLNode<E> location;
	DLLNode<E> frontPointer;
	DLLNode<E> backPointer;
	
	// Adds elements to the DLL. Automatically adds them where they belong in the list (sorted).
	// Properly handles special cases (list is empty, adding to beginning or end, etc)
	@Override
	public void add(E element){
		DLLNode<E> newNode = new DLLNode<E>(element);
		
		if (head == null)
		{
			head = newNode;
			tail = newNode;
			numElements++;
			return;
		}
		
		DLLNode<E> loop = head;
		boolean reachedEnd = false;
		while (((Comparable)element).compareTo(loop.getInfo()) >= 0)
		{
			if (loop.getNext() == null)
			{
				reachedEnd = true;
				break;
			}
			else
			{
				loop = loop.getNext();
			}
		}
		
	
		if (!reachedEnd)
		{
			if (head == loop) head = newNode;
			
			newNode.setPrev(loop.getPrev());
			newNode.setNext(loop);
			if (newNode.getPrev() != null)
				newNode.getPrev().setNext(newNode);
			loop.setPrev(newNode);
		}
		else
		{
			newNode.setPrev(loop);
			loop.setNext(newNode);
			tail = newNode;
		}
		
		numElements++;
		
	}
	
	
	// Finds the first instance of an element in the list and removes it (properly sets the .next and .prev of adjacent nodes)
	// Properly handles special cases (removing the head or tail of the list)
	@Override
	public boolean remove(E element) {
		
		find(element);
		if (found)
		{
			if (location != head)
			{
				location.getPrev().setNext(location.getNext());
			}
			else
			{
				head = location.getNext();
			}
			
			if (location != tail)
			{
				location.getNext().setPrev(location.getPrev());
			}
			else
			{
				tail = location.getPrev();
			}
			
			numElements--;
		}
		
		return found;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head == null){
			return true;
		}
		return false;
	}
	@Override
	public boolean contains(E element) {
		find(element);
		return(found);
	}
	
	//We
	@Override
	public E get(E element) {
		find (element);
		if (found) {
			return location.getInfo();
		}
		return null;
	}
	@Override
	public void resetIterator() {
		// TODO Auto-generated method stub
		frontPointer= head;
	}
	
	public void resetBackIterator() {
		backPointer = tail;
	}
	
	@Override
	public E getNextItem() {
		E temp;
		 if(frontPointer.getNext() == tail) {
			frontPointer = frontPointer.getNext();
			 temp = frontPointer.getInfo();
			 frontPointer = head;
		 } else {
			 frontPointer= frontPointer.getNext();
			 temp = frontPointer.getInfo();
		 }
		return temp;
	}
	
	public E getPrevItem(){
		E temp;
		if(backPointer.getPrev() == head) {
			backPointer = backPointer.getPrev();
			 temp = backPointer.getInfo();
			 backPointer = tail;
		 } else {
			 backPointer = backPointer.getPrev();
			 temp = backPointer.getInfo();
		 }
		return temp;
	}
	
	// (Linear)
	// Iterates through the list using .getNext() until an element that matches the target is found.
	// If no element is found, 'found' instance var = false.
	public void find(E target) {
		
		found = false;
		location = null;
		
		DLLNode<E> loop = head;
		while (loop != null)
		{
			if (((Comparable)target).compareTo(loop.getInfo()) == 0)
			{
				found = true;
				location = loop;
				return;
			}
			loop = loop.getNext();
		}
		
	}
	
	
	//i think this is how the binary search algo goes but i think we need another variable and array
	//one to check if there was a change in our first array and another array to hold our numbers
	//if we use MAX_VALUE it will work but we'd have to run it again to find another variable
	//need to add a counter to this loop, status update variable, to show change
	
	//Method Desc: We have our high and low set for our array, the key is the value/element we are searching for in our array
	//Mid is = the low+high/2 which should have us sitting pretty in the center of our array (should be sorted) 
	//We then split the array in half and check each end, if no value is found in one end it will be discarded and we repeat
	//if we let this run we will get our MAX_VALUE/key that we were searching for, or we get nill
	
	
	public int find2(int[] bArray, int key, int low, int high) { // Note: This returns an int, but it needs to return an object of type 'E'.
		int index = Integer.MAX_VALUE;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (bArray[mid] < key) {
				low = mid +1;
			} else if (bArray[mid] > key) {
				high = mid - 1;
			} else if (bArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}
	
	public String toString() {
	        StringBuilder sb = new StringBuilder("[\n");
	        DLLNode<E> current = head;
	        while (current != null) {
	        sb.append(current.getInfo().toString()).append("\n");
	        current = current.getNext();
	        }
	        sb.append("]");
	        return sb.toString();
	        }

	// create string to print from tail to head
	public String gnirtSot() {
	        StringBuilder sb = new StringBuilder("[\n");
	        DLLNode<E> current = tail;
	        while (current != head) {
	        sb.append(current.getInfo().toString()).append("\n");
	        current = current.getPrev();

	        if (current == head) {
	        sb.append(current.getInfo().toString()).append("\n");
	        }
	        }
	        sb.append("]");
	        return sb.toString();
	        }
}
