class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private int cap;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void insert(Node node){
        Node prev = this.right.prev; // get the prev
        prev.next = node; // connect new node to prev
        node.prev = prev; // set prev to the original prev
        node.next = this.right; // connecti it to right
        this.right.prev = node; // connect right to the node
    }
    
    private void remove(Node node){
        Node prev = node.prev; // get prev
        Node nxt = node.next; // get next
        prev.next = nxt; // connect them
        nxt.prev = prev;
        // skip over the curr node to remove it;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node); // update to most recently used
            insert(node); // add it back to right
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap){
            Node lru = this.left.next;
            remove(lru); // rmeove it
            cache.remove(lru.key); // remove from map
        }
    }
}
