package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.ListIterator;
public class ArrayListStack<E extends Comparable<E>> implements StackInterface<E>{
	private ArrayList<E> stack;
	ArrayListStack(E[] values){
		stack = new ArrayList<>(Arrays.asList(values));
	}
	ArrayListStack(){
		stack = new ArrayList<>();
	}
	ArrayListStack(ArrayListStack src){
		stack = new ArrayList<>(src.stack);
	}
	public boolean empty(){
		return stack.isEmpty();
	}
	public E peek(){
		int size = stack.size();
		if(size == 0) throw new EmptyStackException();
		return stack.get(size - 1);
	}
	public E pop(){
		int size = stack.size();
		if(size == 0) throw new EmptyStackException();
		E result = stack.get(size-1);
		stack.remove(size-1);
		return result;
	}
	public E push(E obj){
		stack.add(obj);
		return obj;
	}
	public boolean equals(ArrayListStack other){
		if(this.stack.size() != other.stack.size())
			return false;
		ListIterator<E> itr1 = this.stack.listIterator();
		ListIterator<E> itr2 = other.stack.listIterator();
		while(itr1.hasNext()){
			if(itr1.next().compareTo(itr2.next()) != 0)
				return false;
		}
		return true;
	}
	/**
	 * Tests any data stack if it is a palindrome. It is your responsibility to sanitize input for things like strings.
	 *
	 * @return true: stack is a palindrome. false: stack is not
	 */
	public boolean isPalindrome(){
		int size = stack.size();
		int pushes = size / 2;
		ArrayListStack head = new ArrayListStack(this);
		ArrayListStack tail = new ArrayListStack();
		for(int i = 0; i < pushes; i++)
			tail.push(head.pop());
		if(size%2 == 1)
			head.pop();
		return head.equals(tail);
	}
}

