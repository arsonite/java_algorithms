package algo;

import java.util.Arrays;

public class Queue<T> {

    private int front;
    private int rear;
    int size;
    T[] queue;

    public Queue(int inSize) {
        size = inSize;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isempty() {
        return (front == -1 && rear == -1);
    }

    public void enQueue(T value) {
        if ((rear+1)%size==front) {
            throw new IllegalStateException("Queue is full");

        } else if (isempty()) {
            front++;
            rear++;
            queue[rear] = value;

        } else {
            rear=(rear+1)%size;
            queue[rear] = value;

        }
    }

    public T deQueue() {
        T value = null;
        if (isempty()) {
            throw new IllegalStateException("Queue is empty, cant dequeue");
        } else if (front == rear) {
            value = queue[front];
            front = -1;
            rear = -1;

        } else {
            value = queue[front];
            front=(front+1)%size;

        }
        return value;

    }

    @Override
    public String toString() {
        return "[front = " + front + ", rear = " + rear + ", size = " + size
                + ", Final Queue = " + Arrays.toString(queue) + "]";
    }

}

///////////////////////////////////////////////////////////////////////

//import java.util.NoSuchElementException;
//
//public class Queue<E> {
//    private E[] elements;//array in generic
//    private int front;//first element or front of the queue
//    private int back;//last element or back of the queue
//    private int capacity; //capacity of the queue
//    private int count; //indicates number of elements currently stored in the queue
//
//    public Queue(int size)
//    {
//        capacity = size;
//        count = 0;
//        back = size-1;
//        front = 0;
//        elements =(E []) new Object[size];  //queue array empty
//    }
//
//    //Returns true if the queue is empty or false
//    public boolean isEmpty()
//    {
//        return count==0;//means its true
//    }
//
//    //Add elements to the queue
//    public void enqueue(E item)
//    {
//        if(count == capacity)
//        {
//            resize(capacity*2);
//            // System.out.println("Queue is full");
//
//        }
//
//        back =(back+1) % capacity;    //example back=(0+1)%10=1
//        elements[back]=item;
//        //elements[0]=0
//        //item=elements[count];
//        count++;
//    }
//
//    //Public resize
//    public void resize(int reSize){
//        E[] tmp = (E[]) new Object[reSize];
//
//        int current = front;
//        for (int i = 0; i &lt; count; i++)
//        {
//            tmp[i] = elements[current];
//            current = (current + 1) % count;
//        }
//
//        elements = tmp;
//        front = 0;
//        back = count-1;
//        capacity=reSize;
//    }
//
//    //Dequeue method to remove head
//    public E dequeue()
//    {
//        if(isEmpty())
//        throw new NoSuchElementException("Dequeue: Queue is empty");
//        else
//        {
//            count--;
//            for(int x = 1; x <= count; x++)
//            {
//                elements[x-1] = elements[x];
//            }
//            capacity--;
//            return (E) elements;
//        }
//    }
//
//    //peek the first element
//    public E peek()
//    {
//        if(isEmpty())
//        throw new NoSuchElementException("Peek: Queue is empty");
//
//        else
//        return elements[front];
//    }
//
//    //Print queue as string
//    public String toString()
//    {
//
//        if(isEmpty()) {
//            throw new NoSuchElementException("Queue is empty");
//        }
//
//        String s = "[";
//        for(int i = 0; i < count; i++)
//        {
//            if(i != 0)
//            s += ", ";
//            s = s + elements[i];// [value1,value2,....]
//        }
//
//        s +="]";
//        return s;
//    }
//
//    public void delete() {   //Delete everything
//        count = 0;
//    }
//}

///////////////////////////////////////////////////////////////////////

//import java.util.Arrays;
//
//public class Queue<T> implements QueueInterface<T> {
//
//    private T[] a;
//    private int sz;
//
//    public Queue(int capacity) {
//        sz = 0;
//        @SuppressWarnings("unchecked")
//        T[] tempQueue = (T[])new Object[capacity];
//        a= tempQueue;
//    }
//
//    public void enqueue(T newEntry) {
//        try {
//        for (int i=0; i<a.length; i++) {
//                if (a[i] == null) {
//                    a[i] = newEntry;
//                    break;
//                }
//            }
//        sz++;
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//            @SuppressWarnings("unchecked")
//            T[] tempQueue = (T[])new Object[a.length*+5];
//            a= tempQueue;
//            for (int i=0; i<a.length; i++) {
//                if (a[i] == null) {
//                    a[i] = newEntry;
//                    break;
//                }
//
//            }
//        }
//    }
//
//    public T dequeue() {
//        T result = a[0];
//        a[0] = null;
//        for (int i=1; i<a.length;i++) {
//            a[i-1] = a[i];
//        }
//        sz--;
//        return result;
//    }
//
//    public T getFront() {
//        return a[0];
//    }
//
//    public boolean isEmpty() {
//        for (int i=0; i<a.length; i++) {
//            if (a[i] != null) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void clear() {
//        for (int i=0; i<a.length; i++) {
//            a[i] = null;
//            sz--;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Queue [a=" + Arrays.toString(a) + ", sz=" + sz + "]";
//    }
//
//}