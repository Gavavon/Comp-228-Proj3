package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
public class Project3<E> implements ListInterface<E> {
	
	/* 
	   I created an empty DLLNode class on my end so I could start working on the add/remove/find methods.
	   If you don't have a DLLNode class on your end, this wont compile, so just comment out whatever is making it fail.
	   If you update the file on github please uncomment whatever you had commented before you push.
	   Thanks! - Anthony
	*/
	
	DLLNode<E> head;
	int numElements = 0;
	
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
		
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
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
	
	/*
	 * These two iterator functions are very simple, and just need to be fed the right current node to work,
	 * once that has been implemented.
	 * -Thomas
	 */
	@Override
	public E getNextItem() {
		DLLNode currItem; //Placeholder for when the global current node is added
		return (E) currItem.getNext().getInfo();
	}
	
	public E getPrevItem(){
		DLLNode currItem; //Placeholder for when the global current node is added
		return (E) currItem.getPrev().getInfo();
	}
	//this Github hasnt seen a lot of activity so im also going to attempt the linear search -SS
	//im very sorry if any of this is wrong in syntax or location i hope you can hack it up
	//and use it where needed
	//Method Desc: find() is our linear algorithm, it will simply check each element starting from the bottom until the value is found
	@Override
	public int find(int lArray[], int key) { // Note: This returns an int, but it needs to return an object of type 'E'.
		//do i put int key here aswell or...? 
	int x = lArray.length;
	for (int i = 0; i < x; i++) {
		if(lArray[i] == key)
			return i;
		}
		return -1;
	}
	
	/* I think we can use this for our linear array, or its grabage but you can just delete that :D
	int found = find(lArray, key);
	if(result == --1)
		System.out.println('What youre looking for is not in this array!');
	else 
		System.out.println("What youre looking for is currently at index: " + found); 
	*/
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
