class LRUCache {
        private int cap;
        private Map<Integer, Node> cache; // map used for quick look ups
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

    private void remove(Node node){
        Node prev = node.prev; 
        Node nxt = node.next;
        prev.next = nxt; // set prev to next
        nxt.prev = prev; // set next to prev node is isoltated essentially removed
    }


    private void insert(Node node){
        Node prev = this.right.prev; // extract current most recent
        prev.next = node; // link old to new node
        node.prev = prev; // link new to old node
        node.next = this.right; // link new to right sentinel
        this.right.prev = node; // link right sentinel to new
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){ // if key is present in cache, we remove it, then
            Node node = cache.get(key); // add it back to most recent side 
            remove(node);
            insert(node);
            return node.val; // then return val
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){ // if key is already present we update it
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode); // insert into map
        insert(newNode); // insert into linked list

        if (cache.size() > cap){ // if cache size is too large, remove lru from list and map
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
