package p12_CollectionFramework.p06_QueueInterface;

import java.util.*;

public class PriorityQueue_ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min Heap
        pq.offer(10);
        pq.offer(30); 
        pq.offer(20); 
        pq.offer(40); 
        pq.offer(50);

        System.out.println(pq.poll()); // → 10
        System.out.println(pq.poll()); // → 20
        System.out.println(pq.poll()); // → 30

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        pq1.offer(10);
        pq1.offer(30); 
        pq1.offer(20); 
        pq1.offer(40); 
        pq1.offer(50);

        System.out.println(pq1.poll()); // → 50
        System.out.println(pq1.poll()); // → 40
        System.out.println(pq1.poll()); // → 30
    }
}
