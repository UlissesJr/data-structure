package top.luobogan.fresh.sort;

/**
 * Created by LuoboGan
 * Date:2021/11/14
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] list = {2,32,56,22,11,34,2,7,10,6,1};
        sort(list);
    }

    public static int[] sort(int[] list){

        // 边界条件
        if(list == null ){
            return null;
        }

        if(list.length < 2){
            return list;
        }

        int N = list.length;
        for(int i = 0; i < N ; i++){
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for(int j = 0; j< N-i-1; j++){
                if(list[j] > list[j+1]){
                    swap(list,j,j+1);
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }

        printArray(list);
        return list;
    }

    private static void printArray(int[] list){
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 交换列表内的两个数字
     * @param list
     * @param firstIndex
     * @param LastIndex
     */
    private static void swap(int[] list ,Integer firstIndex,Integer LastIndex){
        int tmp = list[firstIndex];
        list[firstIndex] = list[LastIndex];
        list[LastIndex] = tmp;
    }

}
