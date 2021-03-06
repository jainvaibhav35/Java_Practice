package upwork;

import java.util.Random;

public class HeapSort <E> {

	
	/** Sorts sequence S, using initially empty priority queue P to produce the order. */
	public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P) {
		int n = S.size();
		for (int j = 0; j < n; j++) {
			E element = S.remove(S.first());
			P.insert(element, null); // element is key; null value
		}
		
		for (int j = 0; j < n; j++) {
			E element = P.removeMin().getKey();
			S.addLast(element); // the smallest key in P is next placed in S
		}
	}
	
	public static void main(String[] args) {
		LinkedPositionalList<Integer> list = new LinkedPositionalList<Integer>();
		HeapPriorityQueue<Integer, Integer> heap = new HeapPriorityQueue<Integer, Integer>();
		int arr[] = new int[10];


		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; ++i) {
			list.addLast(rand.nextInt(100));
		}
		
		System.out.println("Original Sequence:");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		pqSort(list, heap);
		
		System.out.println("After heap sort...");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		MaxHeapPriorityQueue<Integer, Integer> heap2 = new MaxHeapPriorityQueue<Integer, Integer>();
		
		System.out.println("Original Sequence:");
		for (int i = 0; i < 10; ++i) {
			int num = rand.nextInt(100);
			heap2.insert(num, null);
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		heap2.sortInPlace();
	}
	
}
