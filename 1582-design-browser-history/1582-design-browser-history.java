class BrowserHistory {
    Stack<String> historyBackward = new Stack<>();
    Stack<String> historyForward = new Stack<>();

    String curr = "";

    public BrowserHistory(String homepage) {
        this.curr = homepage;
    }
    
    public void visit(String url) {
        historyBackward.push(curr);

        curr = url;

        historyForward.clear();
    }
    
    public String back(int steps) {
        while(steps-- > 0 && historyBackward.size() > 0){
            historyForward.push(curr);
            curr = historyBackward.peek();
            historyBackward.pop();
        }
        return curr;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && historyForward.size() > 0){
            historyBackward.push(curr);
            curr = historyForward.peek();
            historyForward.pop();
        }

        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */