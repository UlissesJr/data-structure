package top.luobogan.JVM.StringPool;

import java.util.Random;

public class StringPoolTest2 {

	static final int MAX = 100 * 100;
	static final String[] arr = new String[MAX];

	public static void main(String[] args) throws Exception {
		Integer[] DB_DATA = new Integer[10];
		Random random = new Random(10 * 10000);
		for (int i = 0; i < DB_DATA.length; i++) {
			DB_DATA[i] = random.nextInt();
			System.out.println(DB_DATA[i]);
		}
		for (int i = 0; i < MAX; i++) {
			// 因为调用了intern() 方法，所以arr数组里面的引用去重之后 引用就只有10个;
			//arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
			// 堆内存有1万个 new 对象，并且因为数组是final修饰的，所以内存不被释放;
			arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
			// arr[i] = String.valueOf(DB_DATA[i % DB_DATA.length]).intern();
			// arr[i] = String.valueOf(DB_DATA[i % DB_DATA.length]);
		}
		System.out.println("等待中。。。。。");
		System.in.read();
	}
}
