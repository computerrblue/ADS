import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<Map.Entry<K,V>>{
    private Node root;
    private int size = 0;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public int size() {
        return size;
    }

    public void put(K key, V val){
    
        if(root == null){
            root = new Node(key, val);
            size++;
            return;
        }
        
        Node curr = root;
        Node parent = null;

        while(curr != null){
            parent = curr;
            int comparekey = key.compareTo(curr.key);
            if(comparekey < 0){
                curr = curr.left;
            }else if(comparekey > 0){
                curr = curr.right;
            }else{
                curr.val = val;
                return;
            }
        }
        int comparekey = key.compareTo(parent.key);
        if(comparekey < 0) {
            parent.left = new Node(key, val);
        } else{
            parent.right = new Node(key, val);
        }
        size++;
        
    }
    public V get(K key){
        Node curr = root;

        while(curr != null){
            int comparekey = key.compareTo(curr.key);
            if(comparekey < 0 ){
                curr = curr.left;
            }else if(comparekey > 0){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return null;
    }

    public void delete(K key){

        Node curr = root;
        Node parent = null;

        while(curr != null){
            parent = curr;
            int comparekey = key.compareTo(curr.key);
            if(comparekey < 0){
                curr = curr.left;
            }else if(comparekey > 0){
                curr = curr.right;
            }else{
                break;
            }

        }
        if (curr == null) return;

        if(curr.left == null && curr.right == null){
            if (curr.key.compareTo(parent.key) < 0) {
                parent.left = null;
        }   else {
                parent.right = null;
        }

        } else if((curr.left != null && curr.right == null ) 
            || (curr.left == null && curr.right != null )){
            Node child = (curr.left != null) ? curr.left : curr.right;
            if (parent == null) {
                root = child;
            }
            if (curr.key.compareTo(parent.key) < 0) {
                parent.left = child;
        }   else {
                parent.right = child;
        }

        }   else { 
        Node succ = curr.right;
        Node succParent = curr;

        while(succ.left != null){
            succParent = succ;
            succ = succ.left;
        }

        curr.key = succ.key;
        curr.val = succ.val;

        if(succParent.left == succ){
                succParent.left = succ.right;
            }else{
                succParent.right = succ.right;
            }
        } 
    }
    @Override
    public Iterator<Map.Entry<K,V>> iterator() {
        return new Iterator<Map.Entry<K,V>>() {
            private Stack<Node> stack = new Stack<>();
            private Node curr = root;

            {
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Map.Entry<K,V> next() {
                Node node = stack.pop();
                Map.Entry<K,V> entry = new Map.Entry<K,V>() {
                    @Override
                    public K getKey() { return node.key; }
                    @Override
                    public V getValue() { return node.val; }
                    @Override
                    public V setValue(V value) {
                        V old = node.val;
                        node.val = value;
                        return old;
                    }
                };

                Node right = node.right;
                while(right != null) {
                    stack.push(right);
                    right = right.left;
                }

                return entry;
            }
        };
    }
}
            