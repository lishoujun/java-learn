package testing.interview;

/**
 * 参加某公司测试工程师面试被问到：如何替换字符串中的a、b为c
 * 
 * @author lsjun
 */
public class CharReplace {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "abcabc";
		char[] from = { 'a', 'b' };
		char to = 'c';
		// 实现1
		System.out.println(replace(source, from, to));
		// 实现2
		System.out.println(replace2(source, from, to));
		// 实现3
		System.out.println(replace3(source, from, to));
	}

	private static String replace3(String source, char[] from, char to) {
		// String 的 replaceAll 方法不改变原来的值
		// replaceAll 根据正则替换
		source = source.replaceAll("[ab]", String.valueOf(to));
		return source;
	}

	private static String replace2(String source, char[] from, char to) {
		for (char c : from) {
			// String 的 replace 方法不改变原来的值
			source = source.replace(c, to);
		}
		return source;
	}

	private static char[] replace(String source, char[] from, char to) {
		char[] tmp = source.toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			if (charInarray(tmp[i], from)) {
				tmp[i] = to;
			}
		}
		return tmp;
	}

	private static boolean charInarray(char c, char[] from) {
		for (char i : from) {
			if (i == c)
				return true;
		}
		return false;
	}
}
