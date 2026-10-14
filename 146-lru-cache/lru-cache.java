class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> hm;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;

        Node node = hm.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            if (hm.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                hm.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            hm.put(key, newNode);
        }

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */