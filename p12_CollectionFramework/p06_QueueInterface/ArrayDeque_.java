package p12_CollectionFramework.p06_QueueInterface;

import java.util.*;

public class ArrayDeque_ {
    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();

        // ── Methods from Queue Interface (single-ended) ──────────────────────

        // 1. INSERT (rear)
        queue.add(10);    // throws NoSuchElementException if capacity exceeded (unsafe)
        queue.offer(20);  // returns false if failed (safe)
        queue.offer(30);
        queue.offer(40);
        System.out.println("After inserts: " + queue); // [10, 20, 30, 40]

        // 2. REMOVE (front)
        int removed = queue.remove(); // throws NoSuchElementException if empty (unsafe)
        System.out.println("remove(): " + removed); // 10

        Integer polled = queue.poll(); // returns null if empty (safe)
        System.out.println("poll(): " + polled); // 20

        // 3. INSPECT (front, no removal)
        int head = queue.element(); // throws NoSuchElementException if empty (unsafe)
        System.out.println("element(): " + head); // 30

        Integer peeked = queue.peek(); // returns null if empty (safe)
        System.out.println("peek(): " + peeked); // 30

        System.out.println("Queue now: " + queue); // [30, 40]

        // ── Methods from Deque Interface (double-ended) ──────────────────────

        queue.clear();
        queue.offer(30);
        queue.offer(40);

        // 4. INSERT at FRONT or REAR
        queue.addFirst(10);    // unsafe – throws exception if fails
        queue.addLast(50);     // unsafe – throws exception if fails
        queue.offerFirst(5);   // safe – returns false if fails
        queue.offerLast(60);   // safe – returns false if fails
        System.out.println("After deque inserts: " + queue); // [5, 10, 30, 40, 50, 60]

        // 5. REMOVE from FRONT or REAR
        int rf = queue.removeFirst(); // throws NoSuchElementException if empty (unsafe)
        int rl = queue.removeLast();  // throws NoSuchElementException if empty (unsafe)
        System.out.println("removeFirst(): " + rf); // 5
        System.out.println("removeLast(): " + rl);  // 60

        Integer pf = queue.pollFirst(); // returns null if empty (safe)
        Integer pl = queue.pollLast();  // returns null if empty (safe)
        System.out.println("pollFirst(): " + pf); // 10
        System.out.println("pollLast(): " + pl);  // 50
        System.out.println("Deque now: " + queue); // [30, 40]

        // 6. INSPECT FRONT or REAR (no removal)
        int gf = queue.getFirst();  // throws NoSuchElementException if empty (unsafe)
        int gl = queue.getLast();   // throws NoSuchElementException if empty (unsafe)
        System.out.println("getFirst(): " + gf); // 30
        System.out.println("getLast(): "  + gl); // 40

        Integer pkf = queue.peekFirst(); // returns null if empty (safe)
        Integer pkl = queue.peekLast();  // returns null if empty (safe)
        System.out.println("peekFirst(): " + pkf); // 30
        System.out.println("peekLast(): "  + pkl); // 40

        // ── Stack operations (Deque used as a Stack) ─────────────────────────

        // 7. PUSH (inserts at front, same as addFirst)
        queue.push(0);
        System.out.println("After push(0): " + queue); // [0, 30, 40]

        // 8. POP (removes from front, same as removeFirst)
        int popped = queue.pop();
        System.out.println("pop(): " + popped); // 0
        System.out.println("Final deque: " + queue); // [30, 40]

        // 9. PEEK
        System.out.println(queue.peek());
    }
}