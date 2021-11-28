package top.luobogan.fresh.sort;

/***
 * Created by LuoboGan
 * Date:2021/11/14
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] list = {2,32,56,22,11,34,2,7,10,6,1};
        sort(list);
    }

    private static void sort(int[] list){

        //边界条件
        if(list == null || list.length < 2){
            return ;
        }

        int N = list.length;
        for(int i = 0; i< N; i++){
            int minValueIndex = i;
            for(int j = i+1; j < N; j++){
                minValueIndex = list[j] < list[minValueIndex] ? j : minValueIndex;
            }
            swap(list,i,minValueIndex);
        }
        printArray(list);

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
