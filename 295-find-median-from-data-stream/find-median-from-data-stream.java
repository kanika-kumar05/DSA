class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());

        if(min.size()>max.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        // == -> even
        // max=>n/2
        if(max.size()==min.size()){
            return (max.peek()+min.peek())/2.0;
        }
        // odd
        // max=> (n/2)+1
        else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */