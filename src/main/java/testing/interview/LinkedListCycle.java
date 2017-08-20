package testing.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * 
 * @author lishoujun 
 * https://github.com/lishoujun/java-learn
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		final int size = 100000;
		LinkedList<Integer> linkedList = new LinkedList<>();
		long linkedListAddStartTime = new Date().getTime();
		System.out.println(linkedListAddStartTime);
		for (int i = 0; i < size; i++) {
			linkedList.add(0, i);
		}
		long linkedListAddEndTime = new Date().getTime();
		System.out.println("linkedListTime:" + (linkedListAddEndTime - linkedListAddStartTime));

		ArrayList<Integer> arrayList = new ArrayList<>();
		long arrayListStartTime = new Date().getTime();
		for (int i = 0; i < size; i++) {
			arrayList.add(0, i);
		}
		long arrayListEndTime = new Date().getTime();

		System.out.println("arrayListTime:" + (arrayListEndTime - arrayListStartTime));
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
