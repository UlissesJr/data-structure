package top.luobogan.List;

/**
 * Created by LuoboGan
 * Date:2022/11/15
 */
public class LinkedList<E> extends AbstractList<E> implements List<E> {

    /**
     * first 就是 index = 0 的节点
     */
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        // 需要考虑0的特殊情况
        if(index == 0){
            first = new Node<>(element,first);
        }else{
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element,prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        E removeElement ;
        if(index == 0){
            removeElement = first.element;
            first = first.next;
        }else{
            Node<E> prev = node(index - 1);
            removeElement = prev.next.element;
            prev.next = prev.next.next;
        }

        size --;
        return removeElement;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {  // 1
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i; // n
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for(int i = 0 ; i < index ; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

}
