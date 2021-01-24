// Something wrong with deleting??
// Insertion works
// https://www.hackerrank.com/challenges/qheap1/problem?isFullScreen=true

public class heapTesting {
    public static int[] minHeap = new int[10];
    public static int size = 0;
    
    public static int parentIndex(int childIndex){return (childIndex - 1)/2;}
    public static int leftChildIndex(int parent){return (2 * parent) + 1;}
    public static int rightChildIndex(int parent){return (2 * parent) + 2;}
    
    public static int parentValue(int childIndex){return minHeap[parentIndex(childIndex)];}
    public static int leftChildValue(int parent){return minHeap[leftChildIndex(parent)];}
    public static int rightChildValue(int parent){return minHeap[rightChildIndex(parent)];}
    
    public static boolean rightChildExists(int parentIndex){
        return (rightChildIndex(parentIndex) < size);
    }
    
    public static void swap(int index1, int index2){
        int temp = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = temp;
    }
    
    public static int getIndex(int value){
        for(int i = 0; i < size; i++){
            if(minHeap[i] == value) return i; 
        }
        throw new IllegalArgumentException("Value " + value + " does not exist");
    }
    
    public static void siftUp(int index){
        if(index == 0){return;}
        
        // Checks if parent is greater value than element, swap to move element up
        if(parentValue(index) > minHeap[index]){
            swap(parentIndex(index), index);
            siftUp(parentIndex(index));
        }
    }
    
    public static void siftDown(int index){
        if(leftChildIndex(index) >= size){return;}
        
        // Sets minIndex to the smaller child's index
        int minIndex = leftChildIndex(index);
        if(rightChildExists(index)){
            if(rightChildValue(index) < leftChildValue(index)){
                minIndex = rightChildIndex(index);
            }
        }
        // Checks if the smaller child is smaller than the current element(parent), If so, swap
        if(minHeap[index] > minHeap[minIndex]){
            swap(index, minIndex);
            siftDown(minIndex);
        }
    }
    
    public static void addElement(int value){ 
        if(size == 0){
            // Make root the value if heap is empty
            minHeap[0] = value;
        }else{
            // Add element to the end of heap
            minHeap[size] = value;
            // Move the element up the heap
            siftUp(size);
        }
        size++;
    }
    
    public static void deleteElement(int value){
        
        // Swap value with last element
        int index = getIndex(value);
        swap(index, size - 1);
        size--;
        // Make sure moved element is in correct spot
        siftUp(index);
        siftDown(index);
    }
    
    public static int peek(){
        return minHeap[0];
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
        while(scan.hasNext()){
            switch(scan.nextInt()){
                case 1:
                    addElement(scan.nextInt());
                    break;
                case 2:
                    deleteElement(scan.nextInt());
                    break;
                case 3:
                    if (size > 0) System.out.println(peek());
                    break;
            } 
        } 
    } 
}
