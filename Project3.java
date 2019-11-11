package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
public class Project3<E> implements ListInterface<E> {
	
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected int numElements = 0;
	protected boolean needNewFind2Arrays;
	protected E[] arrayForFind2;
	protected boolean found2;
	protected boolean found;
	protected DLLNode<E> location;
	protected DLLNode<E> frontPointer;
	protected DLLNode<E> backPointer;
	
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
			needNewFind2Arrays = true;
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
		needNewFind2Arrays = true;
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
			needNewFind2Arrays = true;
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
	
	public E get2(E element) {
		find2(element);
		if (found2) {
			return location.getInfo();
		}
		return null;
	}
		
	@Override
	public void resetIterator() {
		frontPointer= head;
	}
	
	public void resetBackIterator() {
		backPointer = tail;
	}
	
	@Override
	public E getNextItem() {
		E temp;
		 if(frontPointer.getNext() == null) {
			//frontPointer = frontPointer.getNext();
			 frontPointer = head;
			 temp = frontPointer.getInfo();
			
		 } else {
			 temp = frontPointer.getInfo();
			 frontPointer= frontPointer.getNext();
		 }
		return temp;
	}
	
	public E getPrevItem(){
		E temp;
		if(backPointer.getPrev() == null) {
			//backPointer = backPointer.getPrev();
			backPointer = tail;
			temp = backPointer.getInfo();
			 
		 } else {
			
			 temp = backPointer.getInfo();
			 backPointer = backPointer.getPrev();
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
	
	 public  void find2(E element) {
	        found2 = false;

	        if (numElements < 1) return;

	        if (needNewFind2Arrays) {

	            arrayForFind2 = (E[]) new Object[numElements];
	            DLLNode<E> current = head;

	            for (int i=0; i < numElements; i++) {
	                arrayForFind2[i] = current.getInfo();
	                current = current.getNext();
	            }
	            needNewFind2Arrays = false;
	        }

	        int low = 0;
	        int high = numElements - 1;
	        while (high >= low) {
	            int mid = (low + high) / 2;
	            if (((Comparable)element).compareTo(arrayForFind2[mid]) == 0) {
	                found2 = true;
	                return;
	            }
	            else {
	                if (((Comparable)element).compareTo(arrayForFind2[mid]) < 0) {
	                    high = mid - 1;
	                }
	                else {
	                    low = mid + 1;
	                }
	            }
	        }
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
