package edu.miracosta.cs113;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CircularArrayQueue<E> implements Queue<E>{
	private ArrayList<E> queue;
	private int front;
	private int rear;
	private int size;

	/**
	 * Constructs an empty queue with the desired capacity
	 *
	 * @peram capacity default capacity of the queue
	 */
	CircularArrayQueue(int capacity){
		queue = new ArrayList<>(capacity);
		front = 0;
		rear = capacity - 1;
		size = 0;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public void forEach(Consumer<? super E> action) {

	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	/**
	 * Adds a new element to the queue. Will allocate more capacity if necessary.
	 *
	 * @e element to be added
	 * @return true if adding successful
	 */
	public boolean add(E e){
		int capacity = queue.size();
		if(capacity == 0) {
			queue.add(e);
			rear = 0;
		}else if(capacity == size){
			rear = (rear + 1) % capacity;
			queue.add(rear, e);
			if(front >= rear)
				++front;
		}else {
			rear = (rear + 1) % capacity;
			queue.set(rear, e);
		}
		++size;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	/**
	 * Gets the element stored at the head of the queue without deleting it
	 *
	 * @return head element
	 */
	public E element(){
		if(size == 0) throw new NoSuchElementException();
		return queue.get(front);
	}
	/**
	 * Adds a new element to the queue. Will allocate more capacity if necessary.
	 *
	 * @e element to be added
	 * @return true if adding successful
	 */
	public boolean offer(E e)
	{	return this.add(e);	}
	/**
	 * Gets the element stored at the head of the queue without deleting it
	 *
	 * @return head element
	 */
	public E peek()
	{	return (size == 0)?null:queue.get(front);	}
	/**
	 * Gets the element stored at the head of the queue also deleting it
	 *
	 * @return head element or null if empty
	 */
	public E poll(){
		E result;
		if(size == 0) return null;
		result = queue.get(front);
		queue.set(front, null);
		front = (front + 1) % queue.size();
		--size;
		return result;
	}
	/**
	 * Gets the element stored at the head of the queue also deleting it. Throws exception if empty
	 *
	 * @return head element
	 */
	public E remove(){
		if(size == 0) throw new NoSuchElementException();
		return this.poll();
	}
	public void clear(){
		queue.clear();
		rear = (front - 1) % queue.size();
		size = 0;
	}

	@Override
	public Spliterator<E> spliterator() {
		return null;
	}

	@Override
	public Stream<E> stream() {
		return null;
	}

	@Override
	public Stream<E> parallelStream() {
		return null;
	}

}
