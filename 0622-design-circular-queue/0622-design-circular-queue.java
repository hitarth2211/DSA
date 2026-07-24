class MyCircularQueue {
    ArrayDeque<Integer> q;
    int n;
    public MyCircularQueue(int k) {
        q = new ArrayDeque<>(k);
        n = k;
    }
    
    public boolean enQueue(int value) {
        if(q.size() == n) return false;
        q.offer(value);
        return true; 
    }
    
    public boolean deQueue() {
        if(q.isEmpty()) return false;
        q.poll();
        return true;
    }
    
    public int Front() {
        return q.isEmpty() ? -1 : q.peek();
    }
    
    public int Rear() {
        return q.isEmpty() ? -1 : q.peekLast();
    }
    
    public boolean isEmpty() {
        return q.isEmpty();
    }
    
    public boolean isFull() {
        return q.size() == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */