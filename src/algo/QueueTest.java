package algo;

public class QueueTest {

	public static <T> void main(String[] args) {
//		Queue<Integer> newQueue = new Queue(5);
//        newQueue.enQueue(10);
//        newQueue.enQueue(20);
//        newQueue.enQueue(30);
//        newQueue.enQueue(40);
//        newQueue.enQueue(50);
//        System.out.println((T) newQueue.toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.toString());
//        newQueue.enQueue(60);
//        newQueue.enQueue(70);
//        System.out.println((T) newQueue.toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.deQueue().toString());
//        System.out.println((T) newQueue.toString());
//	}
//}

///////////////////////////////////////////////////////////////////////

        Queue<Integer> queue = new Queue<Integer>(5);

        queue.enQueue(1);
        System.out.println("Queue: "+ queue);
        queue.enQueue(2);
        System.out.println("Queue: "+ queue);
        queue.deQueue();
        queue.enQueue(3);
        System.out.println("Queue: "+ queue);
        queue.enQueue(4);
        System.out.println("Queue: "+ queue);
        queue.enQueue(5);
        System.out.println("Queue: "+ queue);
    }
}