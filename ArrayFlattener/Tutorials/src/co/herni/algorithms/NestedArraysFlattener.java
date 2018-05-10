package co.herni.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author hernan_quevedo
 *
 */
public class NestedArraysFlattener {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Sample cubic array with 18 elements, with 3 dimensions and a volume of 18 elements 
		 */
		int h=3, w=3, l=2;
		Integer[][][] arr = new Integer[3][3][];
		for (int i = 0; i < w; i++) {
			Integer[][] el = new Integer[h][];
			for (int j = 0; j < h; j++) {
				Integer[] lon = new Integer[l];
				for (int k = 0; k < lon.length; k++) {
					lon[k] = new Integer(i+j+k);
				}		
				el[j] = lon;
			}
			arr[i] = el;
		}
		
		/**
		 * Array printing
		 */
		for(int i=0;i<arr.length;i++){
			Integer[][] sf = arr[i];
			//System.out.print("[");
			for (int j = 0; j < sf.length; j++) {
				Integer[] sff = sf[j];
				//System.out.print("[");
				for (int k = 0; k < sff.length; k++) {
					Integer in = sff[k];
					if(k==sff.length-1);
						//System.out.print(in);
					else;
						//System.out.print(in+",");
				}
				//System.out.print("],");
			}
			//System.out.print("]");
		}
		
		/**
		 * Flatten array
		 */
		System.out.println(Arrays.toString(flattenMultidimensionalIntegerArray(arr)));
	}
	
	static Integer[] flattenMultidimensionalIntegerArray(Object[] arr){
		
		List<Object> finalIntegerFlattenedList = new ArrayList<>();
		
		for (Object objt : arr) {
			if (objt.getClass().isArray())
				finalIntegerFlattenedList = flatten(objt, finalIntegerFlattenedList);
			else
				finalIntegerFlattenedList.add(objt);
		}
		Integer[] flattenedArray = new Integer[finalIntegerFlattenedList.size()];
		int i = 0;
		for(Object o : finalIntegerFlattenedList){
			flattenedArray[i] = (Integer) o;i++;
		}
		return flattenedArray;
	}
	
	private static List<Object> flatten(Object objt, List<Object> tempList) {
		
		if(!objt.getClass().isArray() ){
			Integer singleElement = (Integer)objt;
			tempList.add(singleElement);
			return tempList;
		}
		else {
			List<Object> resList = tempList;
			int n = Array.getLength(objt);
			Object[] newob = (Object[])objt;
			//System.out.println("the element is an array with size: " + n);
			for(int i = 0;i<n;i++){
				Object ob = newob[i];
				resList = flatten(ob,tempList);
			}
			return resList;
		}		
	}
}
