package nodes;

public class DLLNode<E> {
	private E info;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	
	public DLLNode(E info) {
		this.info = info;
		next = null;
		prev = null;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public DLLNode<E> getNext() {
		return next;
	}
	
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
	
	public DLLNode<E> getPrev() {
		return prev;
	}
	
	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
}
