// 14/22 test cases passed
// Hashtable with a doublylinkedlist
// hashtable keeps track of what items are in memory
// doublylinked list keeps track of what was recently used
// double is used since we can remove a node from middle and put it to the end in constant time

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    class DoublyLinkedList<T> {
        DoublyLinkedList<T> next;
        DoublyLinkedList<T> previous;
        T value;
        T key;

        public DoublyLinkedList(T key, T value) {
            this.value = value;
            this.key = key;
        }

        public String toString() {
            return value + "";
        }

    }

    // move node to the End, return new tail
    public void moveToEnd(DoublyLinkedList<Integer> node, int value) {
        if (node.next == null) {
            node.value = value;
            return;
        }

        if (node.previous != null) {
            node.previous.next = node.next;
            node.next.previous = node.previous.next;
        } else {
            head = node.next;
            head.previous = null;
        }

        // make node new tail and update previous and next accordingly
        tail.next = node;
        tail.next.previous = tail;
        tail = tail.next;
        tail.next = null;

        tail.value = value;
    }

    HashMap<Integer, DoublyLinkedList<Integer>> map;
    DoublyLinkedList<Integer> head;
    DoublyLinkedList<Integer> tail;
    final int capacity;

    public static void main(String[] args) {
        LRUCache testing = new LRUCache(2);
        testing.put(2, 1);
        testing.put(2, 2);
        System.out.println("Finding: " + 2 + " Returned: " + testing.get(2));
        testing.put(1, 1);
        testing.put(4, 1);
        System.out.println("Finding: " + 2 + " Returned: " + testing.get(2));

    }

    public void printCache() {

        DoublyLinkedList<Integer> temp = head;
        System.out.print("{");
        while (temp != null) {
            System.out.print(temp + "<->");
            temp = temp.next;
        }
        System.out.println("}");
    }

    public void printCacheB() {

        DoublyLinkedList<Integer> temp = tail;
        System.out.print("Backwards: {");
        while (temp != null) {
            System.out.print(temp + "<->");
            temp = temp.previous;
        }
        System.out.println("}");
    }

    public LRUCache(int capacity) {
        map = new HashMap<Integer, DoublyLinkedList<Integer>>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("map: " + map);
        if (map.containsKey(key)) {
            moveToEnd(map.get(key), map.get(key).value);
            printCache();
            return (Integer) map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // update if exists, move node to end of Least recently used(tail)
            System.out.println("Updating...");
            moveToEnd(map.get(key), value);
            map.replace(key, tail);

        } else {

            if (map.size() >= capacity) {

                // IF there is only one element, make head new node
                if (head.next == null) {
                    head = new DoublyLinkedList<Integer>(key, value);
                    map.clear();
                    map.put(key, head);
                    return;
                }

                // if cache full, remove LRU(head) and ...
                int keyToRemove = head.key;
                head = head.next;
                head.previous = null;
                map.remove(keyToRemove);

                // add new node to recently used(tail)
                DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>(key, value);
                tail.next = temp;
                tail.next.previous = tail;
                tail = tail.next;
                map.put(key, temp);

                System.out.println(map);
            } else {
                // If cache is empty, add to cache
                if (map.size() == 0) {
                    DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>(key, value);
                    head = temp;
                    tail = head;
                    map.put(key, temp);
                    System.out.println("Add to empty:" + map);

                    // Else cache has space, insert into cache
                } else {
                    DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>(key, value);
                    tail.next = temp;
                    tail.next.previous = tail;
                    tail = tail.next;
                    map.put(key, temp);
                    System.out.println("Insert" + map);
                }

            }
        }
        printCache();
        // printCacheB();
    }
}