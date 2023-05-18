package top.luobogan.map;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/design-hashmap/
 * 设计哈希映射
 */
public class Easy_706_DesignHashmap {

    private static final int BASE = 1000;

    /**
     * data数组，数组里面是链表，链表元素是 Node 节点
     * Node节点元素包含 key value
     */
    private LinkedList[] data;

    public Easy_706_DesignHashmap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Node>();
        }
    }

    /**
     * 向 HashMap 插入一个键值对 (key, value) 。
     * 如果 key 已经存在于映射中，则更新其对应的值 value 。
     */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        // 在队尾添加元素
        data[h].offerLast(new Node(key, value));
    }

    /**
     * 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1
     */
    public int get(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                return node.value;
            }
        }
        return -1;
    }

    /**
     * 如果映射中存在 key 的映射，则移除 key 和它所对应的 value
     */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                data[h].remove(node);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }

    /**
     * 拉链法里面的Node节点
     */
    private class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
