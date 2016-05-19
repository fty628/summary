package com.fty.sort;

public class SortUtil {

	public static void exchange(Object[] source, int i, int selected){
		if( i != selected){
			Object temp = source[i];
			source[i] = source[selected];
			source[selected] = temp;
		}
	}
	
	public static <T extends Comparable<T>> boolean compare(T source, T target, boolean ascend){
		 int compare = source.compareTo(target); 
		 
		 if (compare != 0 && (compare < 0 == ascend)) { 
            return true;
         }
		 return false;
	}
}
