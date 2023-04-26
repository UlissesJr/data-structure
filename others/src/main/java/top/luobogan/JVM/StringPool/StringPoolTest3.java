package top.luobogan.JVM.StringPool;


import org.junit.Test;

public class StringPoolTest3 {

	public static void main(String[] args) throws Exception {

		String a = new String("1") + new String("1") ;
		String c = a.intern();
		String b = "11" ;
		System.out.println(a == b);
		
	}

	@Test
	public void test(){
		String a = new String("1") + new String("1") ;
		String c = a.intern();
		String b = "11" ;
		System.out.println(c == b);
	}

	@Test
	public void test2(){
		//字符串常量池中存在 ”1“, 并且new 了一个对象s 存在堆中;
		String s = new String("1");
		// 因为返回值没有对象接收，并且字符串常量池中存在 ”1“, 所以 这句话相当于啥也没干
		s.intern();
		// s2 指向了 字符串常量池中的 "1";
		String s2 = "1";
		System.out.println(s == s2); //false

		String s3 = new String("1") + new String("1");
		s3 = s3.intern();
		// 注意，这里的11存在在字符串常量池里，早于s3对象产生，所以s3.intern() 返回的是 常量池里面的11 对象内存地址；
		String s4 = "11";
		//true
		System.out.println(s3 == s4);
	}

	@Test
	public void test3(){
		// 字符串常量池中存在 ”1“；
		String s = new String("1");
		// 对应到常量池中的 "1" ;
		String s2 = "1";
		// s地址修改为常量池中的 "1";
		s = s.intern();
		System.out.println(s == s2);

		// 原理同上
		String s3 = new String("1") + new String("1");
		String s4 = "11";
		s3 = s3.intern();
		System.out.println(s3 == s4);

	}

}
