package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
public class Project3<E> implements ListInterface<E> {
	
	DLLNode<E> head;
	int numElements = 0;
	
	boolean found;
	DLLNode<E> location;
	
	// Adds elements to the DLL. Automatically adds them where they belong in the list (sorted).
	@Override
	public void add(E element){
		DLLNode<E> newNode = new DLLNode<E>(element);
		
		if (head == null)
		{
			head = newNode;
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
		}
		
		numElements++;
		
	}

	@Override
	public boolean remove(E element) {
		
		find(element);
		if (found)
		{
			if (location.getPrev() != null)
			{
				location.getPrev().setNext(location.getNext());
			}
			else
			{
				head = location.getNext();
			}
			
			if (location.getNext() != null)
				location.getNext().setPrev(location.getPrev());
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
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void resetIterator() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E getNextItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Method Desc: find() is our linear algorithm, it will simply check each element starting from the head until the value is found
	public void find(E target) { // Note: This returns an int, but it needs to return an object of type 'E'.
		
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
	
	@Override
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
	}
}
