import java.util.Iterator;
/**
 * @description 双向链表实现的队列
 * @author zhangff01
 * @param <T>
 */
public class LinkedQueueList<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enqueue(T t){
		Node oldlast=last;
		last=new Node();
		last.t=t;
		if(isEmpty()){
			first=last;
		}else{
			oldlast.next=last;
		}
		N++;
	}
	public T dequeue(){
		if(isEmpty()){
			first=null;
			last=null;
			return null;
		}			
		T t=first.t;
		first=first.next;
		N--;
		return t;
	}
	
	private class Node{
		Node prev;
		T t;
		Node next;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedQueueListIterator();
	}
	private class LinkedQueueListIterator implements Iterator<T>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public T next() {
			T t=current.t;
			current=current.next;
			return t;
		}
		@Override
		public void remove() {
			
		}
	}
}
