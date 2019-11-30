package nz.ac.massey.cs.sdc.tutorial5;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class ooo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lecturer lec1 = new Lecturer(1, "Michael", "Scofield");
		Lecturer lec2 = new Lecturer(1, "Michael", "Scofield");
		Map<Lecturer, String> aaa = new IdentityHashMap();
		aaa.put(lec1, "1231231321");
		
		System.out.println(aaa.get(lec2));
		System.out.println(aaa.get(lec1));
	}

}
