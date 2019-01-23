package randomPack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		ThreadLocalRandomExample obj = new ThreadLocalRandomExample();
		for(int i = 0; i < 10; i++){
			System.out.println(obj.getRandomList(list));
		}
		
	}

	public int getRandomList(List<Integer> list) {

	    //0-4
	    int index = ThreadLocalRandom.current().nextInt(list.size());		
	    System.out.println("\nIndex :" + index );
	    return list.get(index);
	    
	}
	
}
