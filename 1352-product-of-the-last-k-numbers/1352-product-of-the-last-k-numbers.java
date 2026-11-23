import java.util.*;
class ProductOfNumbers {
    Deque<Integer> st;
    public ProductOfNumbers() {
        st = new ArrayDeque<>();
    }
    
    public void add(int num) {
        st.offer(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        Iterator<Integer> it = st.descendingIterator();
        while(it.hasNext() && k-- > 0) {
            product *= it.next();
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */