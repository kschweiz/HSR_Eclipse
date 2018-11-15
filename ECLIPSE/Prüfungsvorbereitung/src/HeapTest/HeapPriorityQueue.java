package HeapTest;

public class HeapPriorityQueue<K,V> {

    protected ArrayList<Entry<K,V>> heap;
    protected Comparator<K> comp;

    protected static class MyEntry<K,V> implements Entry<K,V> {
        protected K key;
        protected V value;
        public MyEntry(K k, V v) {key = k; value = v;}
        public K getKey() {return key;}
        public V getValue() {return value;}
        public String toString() {return "(" + key + "," + value + ")";}
    }

    public HeapPriorityQueue() {
        heap = new ArrayList<Entry<K,V>>();
        heap.add(new MyEntry(null,null));
        comp = new DefaultComparator<K>();
    }

    public HeapPriorityQueue(Comparator<K> c) {
        heap = new ArrayList<Entry<K,V>>();
        heap.add(new MyEntry(null,null));
        comp = c;
    }

    public int size() {return heap.size() - 1;}

    public boolean isEmpty() {return size() == 0; }

    public Entry<K,V> min() throws EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority Queue is Empty");
        return heap.get(1);
    }

    public Entry<K,V> insert(K k, V v) {
        Entry<K,V> entry = new MyEntry<K,V>(k,v);
        heap.add(entry);
        upHeap(size());
        return entry;
    }

    public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority Queue is Empty");
        if (size() == 1)
            return heap.remove(1);

        Entry<K,V> min = heap.get(1);
        heap.set(1, heap.remove(size()));
        downHeap(1);
        return min;

    }

    public V replaceValue(Entry<K,V> e, V v) {
	// replace the value field of entry e in the priority
        // queue with the given value v, and return the old value


    }

    public K replaceKey(Entry<K,V> e, K k) {
        // replace the key field of entry e in the priority
        // queue with the given key k, and return the old key
   
    }

    public Entry<K,V> remove(Entry<K,V> e) {
        // remove entry e from priority queue and return it
    }

    protected void upHeap(int i) {
        while (i > 1) {
            if (comp.compare(heap.get(i/2).getKey(), heap.get(i).getKey()) <= 0)
                break;
            swap(i/2,i);
            i = i/2;
        }
    }

    protected void downHeap(int i) {
        int size = size();
        int smallerChild;
        while (size >= 2*i) {
            smallerChild = 2*i;
            if ( size >= 2*i + 1)
                if (comp.compare(heap.get(2*i + 1).getKey(), heap.get(2*i).getKey()) < 0)
                    smallerChild = 2*i+1;
            if (comp.compare(heap.get(i).getKey(), heap.get(smallerChild).getKey()) <= 0)
                break;
            swap(i, smallerChild);
            i = smallerChild;
        }
    }

    protected void swap(int j, int i) {
        Entry<K,V> temp;
        temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    public String toString() {
        return heap.toString();
    }

}
