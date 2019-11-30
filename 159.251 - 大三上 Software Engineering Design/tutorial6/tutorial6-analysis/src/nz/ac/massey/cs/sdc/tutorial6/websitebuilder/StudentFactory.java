package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import java.util.Random;

public class StudentFactory {
	
	private static final String[] LAST_NAMES = {
		"Smith","Miller","MacDonald","Key","Taylor","O'Brien","Bush","Gupta","Wang","Sanchez","Mueller"
	};
	private static final String[] FIRST_NAMES = {
		"John","Jim","Bob","Kate","James","Brian","Basil","George","Liz","Linda","Anna","Maria"
	};
	private static final String[] DEGREES = {
		"BInfSci SE","BSC CS","BE CSE","BSc Mathematics","BE Food Technology","BSc Chemistry"
	};

	private static int LAST_ID = 0;
	
	private static String getRandomValue(String[] values) {
		Random random = new Random();
		return values[random.nextInt(values.length)];	
	}
	public static Student createRandomStudent() {
		Student s = new Student();
		s.setId(++LAST_ID);
		s.setName(getRandomValue(LAST_NAMES));
		s.setFirstName(getRandomValue(FIRST_NAMES));
		s.setDegree(getRandomValue(DEGREES));
		return s;
	}

	
//	public static void main(String[] args) {
//		for (int i=0;i<10;i++) {
//			System.out.println(createRandomStudent());
//		}
//	}
}
