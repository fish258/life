package nz.ac.massey.cs.pp.tutorial4.id17140713;

import nz.ac.massey.cs.pp.tutorial4.ElementNotFoundException;
import nz.ac.massey.cs.pp.tutorial4.SimpleList;

/**
 * This is the class template you must implement. This means to replace all TODOs 
 * by meaningful code until all tests in MySimpleTests succeed. 
 * RULES:
 * 1. are not allowed to change the definition of the single instance variable
 * 2. you are not allowed to add instance variables
 */
public class MySimpleList implements SimpleList{
	
	// do not change the next line!! 
	private String[] content = new String[5];
	// do not add more instance variables

	@Override
	public void add(String element) {
		// TODO 
		int elementindex = 0;
		if(content[content.length-1]!=null) {
			String[] newContent = new String[content.length*2];
//			System.out.println(newContent.length);
			for (int i = 0;i<content.length;i++) {
				if(content[i]!=null) {
				newContent[i] = content[i];
				}
			}
			newContent[content.length]=element;
			System.out.println("elementindex is" + elementindex);
			this.content = newContent;
			System.out.println(getSize()+"asd"+"newcontent length"+newContent.length);
		}
		else {
			for (int i = 0;i<content.length;i++) {
				if (content[i]==null) {
				content[i] = element;
				System.out.println(getSize());
				break;
				}
			}
		}
	}

	@Override
	public void remove(String element) throws ElementNotFoundException {
		// TODO 
		int a = 0;
		int index = content.length;
		String[] new1 = new String[content.length];
		for (int i = 0;i<content.length;i++) {
			if(content[i]==element) {
				content[i]=null;
				index = i;
				a=1;
			}
			else {
				if (i<index) {
				new1[i]=content[i];
				}
				else {
					new1[i-1]=content[i];
				}
				continue;
			}}
		if (a==0){
			throw new ElementNotFoundException();
			}
		}

	@Override
	public int getSize() {
		// TODO 
		int court = 0;
		for (int i = 0;i<content.length;i++) {
			if(content[i]!=null) {
				court = court+1;
			}
		}
		return court;
	}

	@Override
	public boolean contains(String element) {
		// TODO
		for (int i = 0;i<content.length;i++) {
			if(element != content[i]) {
				continue;
			}
			else {
				return true;
			}
		}
		return false;
	}
}
