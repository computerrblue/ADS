public class MyHashTable<K, V> {

    private class HashNode<K, V>{


        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;

        }
        @Override
        public String toString(){
            return "{" + this.key + " " + this.value + "}";
        }

        


    }


    private HashNode<K,V>[] buckets;
    private int M = 11;
    private int size;

    public MyHashTable(){
        this.buckets = new HashNode[M];
        this.size = 0;


    }
    public MyHashTable(int M){
        this.M = M;
       this.buckets = new HashNode[M];
       this.size = 0; 
    }
    private int hash(K key){
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % M; 

    }
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> head = buckets[index];


        while(head != null){
            if((head.key == null && key == null) || 
            (head.key != null && head.key.equals(key))){
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K,V> node = new HashNode<K,V>(key, value);
        node.next = buckets[index];
        buckets[index] = node;

        size++;


    
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K,V> head = buckets[index];

        while(head != null){
                if (head.key.equals(key)){
                    return head.value;

                } 
                head = head.next;

            }

            return null;

        }
    
        public V remove(K key){
            int index = hash(key);

            HashNode<K,V> head = buckets[index];

            if(head.key.equals(key)){
                V value = head.value;
                buckets[index] = head.next;
                size--;
                return value;

            }
            HashNode<K,V> node = head;
            while(node.next != null){
                if(node.next.key.equals(key)){
                    V value = node.next.value;
                    node.next = node.next.next;
                    size--;
                    return value;
                }
                node = node.next;
            }
            return null;

        }


        public boolean contains(V value){
            for(int i = 0; i < buckets.length; i++){
                HashNode<K,V> head = buckets[i];
                while(head != null){
                    if(head.value.equals(value)){
                        return true;
                    }
                    head = head.next;
                }
            }
            return false;
        }


        public K getKey(V value){
            for(int i = 0; i < buckets.length; i++){
                HashNode<K,V> head = buckets[i];
                while(head != null){
                    if(head.value.equals(value)){
                        return head.key;
                    }
                    head = head.next;
                }
            }
            return null;
        }

    public int[] getBucketSizes() {
        int[] sizes = new int[M];
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K,V> node = buckets[i];
            while (node != null) {
                count++;
                node = node.next;
                }
            sizes[i] = count;
    }
        return sizes;

}

}
    



