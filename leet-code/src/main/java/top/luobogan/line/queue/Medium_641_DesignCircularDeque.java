package top.luobogan.line.queue;

/**
 * https://leetcode.cn/problems/design-circular-deque/
 * 设计循环双端队列
 */
public class Medium_641_DesignCircularDeque {

    // size为queue里实际的元素个数
    private int size;
    private int[] data;

    // 左闭右开区间
    private int first, last;

    public Medium_641_DesignCircularDeque(int k){
        size = 0;
        data = new int[k];
        first = last = 0;
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
     */
    public boolean insertFront(int value) {

        if(isFull()){
            return false;
        }

        if(first == 0){
            first = data.length - 1;
        }else {
            first--;
        }

        data[first] = value;
        size++;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false
     */
    public boolean insertLast(int value) {

        if(isFull()){
            return false;
        }

        data[last] = value;
        last++;
        if(last == data.length){
            last = 0;
        }
        size++;
        return true;

    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
     */
    public boolean deleteFront() {

        if(isEmpty()){
            return false;
        }

        size--;
        first++;
        if(first == data.length){
            first = 0;
        }
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
     */
    public boolean deleteLast() {

        if(isEmpty()){
            return false;
        }

        if(last == 0){
            last = data.length-1;
        }else {
            last--;
        }
        size--;
        return true;

    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     */
    public int getFront() {

        if(isEmpty()){
            return -1;
        }

        return data[first];

    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     */
    public int getRear() {

        if(isEmpty()){
            return -1;
        }

        if(last == 0){
            return data[data.length-1];
        }else{
            return data[last -1];
        }
    }

    /**
     * 若双端队列为空，则返回 true ，否则返回 false  。
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 若双端队列满了，则返回 true ，否则返回 false 。
     */
    public boolean isFull() {
        return size == data.length;
    }

}
