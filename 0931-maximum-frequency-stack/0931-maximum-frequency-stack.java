class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();

    int max = -1;

    public FreqStack() {}
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);

        map.put(freq.get(val), map.getOrDefault( freq.get(val), new Stack<Integer>()));

        map.get(freq.get(val)).push(val);

        max = Math.max(max, freq.get(val));    
    }
    
    public int pop() {
        while(map.get(max).size() == 0 && max > 0) max--;

        int pop = map.get(max).peek();
        map.get(max).pop();

        freq.put(pop, freq.get(pop) - 1);

        return pop;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */