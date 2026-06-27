class Solution {

    class Pair{
        int val;
        int index;

        Pair(int val, int index){
            this.val = val;
            this.index = index;
        } 
    }

    public String[] findRelativeRanks(int[] score) {
        String[] arr = new String[score.length];

        PriorityQueue<Pair> q = new PriorityQueue<>( (a, b) -> b.val - a.val );

        for(int i = 0; i < score.length; i++){
            q.offer(new Pair(score[i], i));
        }

        int pos = 1;
        Stack<String> temp = new Stack<>();
        temp.push("Bronze Medal");
        temp.push("Silver Medal");
        temp.push("Gold Medal");

        while( !q.isEmpty() ){
            Pair p = q.poll();
            if( !temp.isEmpty() ){
                arr[p.index] = temp.pop();
            }else{
                arr[p.index] = Integer.toString(pos);
            }
            pos++;
        }

        return arr;
    }
}