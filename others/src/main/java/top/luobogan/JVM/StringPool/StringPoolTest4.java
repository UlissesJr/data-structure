package top.luobogan.JVM.StringPool;

public class StringPoolTest4 {

	public static void main(String[] args) throws Exception {
//		Random random = new Random(10);
//		String s1 = new String(random.nextInt() + "").intern();
//		String s2 = new String(random.nextInt() + "").intern();
//		System.out.println(s1 == s2);
		String s3 = new String("1") + new String("2");
		String s4 = "11";
		System.out.println(s3 + s4);
	}
}
