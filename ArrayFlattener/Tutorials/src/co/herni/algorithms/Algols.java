package co.herni.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Algols {
	private static final int numusers = 10;
	
	public static void main(String[] args) {
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
		
		for(int i=0;i<arr.length;i++){
			Integer[][] sf = arr[i];
			System.out.print("[");
			for (int j = 0; j < sf.length; j++) {
				Integer[] sff = sf[j];
				System.out.print("[[");
				for (int k = 0; k < sff.length; k++) {
					Integer in = sff[k];
					if(k==sff.length-1)
						System.out.print(in);
					else
						System.out.print(in+",");
				}
				System.out.print("],");
			}
			System.out.print("]");
		}
		
		System.out.println(Arrays.toString(flattenMultidimensionalIntegerArray(arr)));
	}
	
	static Integer[] flattenMultidimensionalIntegerArray(Object[] arr){
		
		List<Object> tempList = new ArrayList<>();
				
		for (Object objt : arr) {
			if (objt.getClass().isArray())
				tempList = flatten(objt, tempList);
			else
				tempList.add(objt);
		}
		//System.out.println(tempList);
		//Integer[] res = (Integer[])tempList.toArray();
		return null;
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
	
	//https://www.hackerrank.com/challenges/two-characters/problem
	 	static int twoCharaters(String s) {
			if(s.length() == 1)
				return 1;
			if(s.length() == 2 && s.charAt(0) == s.charAt(1))
				return 0;
			else {
			String r = null;
			HashMap<Character, Integer> d = new HashMap<>();
			
			for (int i = 0; i < s.length(); i++) {
				char key = s.charAt(i);
				if(d.containsKey(key))
					d.put(key, d.get(key).intValue()+1);
				else
					d.put(key, 1);
			}
			System.out.println(d);
			for (Character t : d.keySet()) {
				r = getString(s,t);
				if(!validString(r))
				{
					System.out.println(r);
					return twoCharaters(r);
				}
			}
	        return r.length();}
	    }
		
		
		private static String getString(String s, Character t) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != t)
					sb.append(s.charAt(i));
			}
			return sb.toString();
		}
		
		private static boolean validString(String r) {
			int n= r.length();
			for (int i = 0; i < r.length(); i++) {
				char c = r.charAt(i);
				if(i < n-1){
					char cc = r.charAt(i+1);
					if(cc == c)
						return false;
				}
			}
			return true;
		}
		/**
		 * https://www.hackerrank.com/challenges/strong-password/problem 
		 * @param n
		 * @param password
		 * @return
		 */
		static int strongPassword(int n, String p) {
			
			int[] left = {0,0,0,0};		
					
			for (int i = 0; i < n; i++) {
				char ch = p.charAt(i);
				if(ch >=65 && ch <= 90  && left[0] != 1){//Upper case
					//upperCase = true;
					left[0] = 1;
					//continue;
				}
				else if(ch >=97 && ch <= 122 && left[1] != 1){//Lower case
					//lowerCase = true;
					left[1] = 1;
					//continue;
				}
				else if(ch >=48 && ch <= 57  && left[2] != 1){//Number
					//number = true;
					left[2] = 1;
					//continue;
				}
				else if(isSpecialCharacter(ch) && left[3] != 1){
					//specialCharacter = true;
					left[3] = 1;
					//continue;
				}
			}
			System.out.println(Arrays.toString(left));
			if(n >= 6 &&  left[0] == 1 && left[1] == 1 && left[2] == 1 && left[3] == 1)
				return 0;
			else {
				if(n<6 &&  left[0] == 1 && left[1] == 1 && left[2] == 1 && left[3] == 1){				
					return 6-n;
				}
				else {
					int ret = 0;
					for (int j = 0; j < left.length; j++) {
						if(left[j] == 0)
							ret++;
					}
					
					int s = ret+n;
					if(s <6)
						return (6-s) + ret;
					return ret;
				}
			}
	    }
		
		private static boolean isSpecialCharacter(char ch) {
			if( (ch >= 32 && ch <=47) || (ch >= 58 && ch <=64) || (ch >= 91 && ch <=96) )
				return true;
			return false;
		}
		/**
		 * Finds the number of words in a string formatted in Camel Case
		 * @param cc
		 * @return
		 */
		public static int wordsInCamelCase(String cc){
			int words = 0;
			int n = cc.length();
			for (int i = 0; i < n; i++) {
				char ch = cc.charAt(i);
				if(ch >= 65 && ch <= 90)
					words++;
			}
			return words+1;
		}
		
		public static String toProperCase(String toProperCase) {
			String ret = toProperCase.trim();
			StringBuilder sb = new StringBuilder();
			char ch = '/';
			sb.append(Character.toUpperCase(ret.charAt(0)));
			for(int i=1; i<ret.length() && ch != ' '; i++){
				ch = ret.charAt(i);
				if(ch == ' '  &&  ret.charAt(i+1) != ' ')
				{
					sb.append(ch);
					sb.append(Character.toUpperCase(ret.charAt(i+1)));
					i = i+1;
					ch = '/';
				}
				else if(ch == ' '){
					sb.append(ch);
					ch = '/';
				}
				else
					sb.append(Character.toLowerCase(ch));
			}
			return sb.toString();
		}
		
		public static String swapCase(String toProperCase) {
			String ret = toProperCase.trim();
			StringBuilder sb = new StringBuilder();
			char ch = '/';
			for(int i=0; i<ret.length(); i++){
				ch = ret.charAt(i);
				
					if(Character.isUpperCase(ch))
						sb.append(Character.toLowerCase(ch));
					else
						sb.append(Character.toUpperCase(ch));
			}
			return sb.toString();
		}
		
		static String super_reduced_string(String s){
			if(s.length() == 0)
				return "Empty String";
			if(s.length() == 1)
				return s;
			
	        List<Character> letters = new ArrayList<>();
	        for(int i=0;i<s.length();i++){
	            char ch = s.charAt(i);
	            letters.add(ch);
	        }
	        //System.out.println(letters);
	        
	        int n = letters.size();
	        for(int i=0;i<n;i++){
	            n = letters.size();
	            if(n == 0)
	                return super_reduced_string("");
	            else if(i == -1)
	            	continue;
	        	char ch = letters.get(i);
	            if(i < n-1){
	                char chn = letters.get(i+1);
	                if(ch == chn){
	                    letters.remove(i);
	                    letters.remove(i);
	                    i= i - 2;
	                }
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        for(Character ss : letters)
	            sb.append(ss);
	        return sb.toString();
	    }
		
		private static Integer getLetterPosition(int i, String ret) {
			char ns = ' ';
			for (int j = i+1; ns == ' '; j++) {
				ns = ret.charAt(j);
				if(ns != ' ')
					return j;
			}
			return -1;
		}
		private static Integer getUsernumform(int userPosition) {
			int accs = 23000;
			int percToAll = accs/numusers;
			int newPercToCurrentUser = userPosition + (numusers - userPosition) - (userPosition*100);
			
			return newPercToCurrentUser;
		}
		private static int getNumber(Integer i) {
			return 0;
		}

		private class scb{
			Integer id;
			String name;
			Integer numForms;
			scb(int id, String name, int numForms){
				this.id = id;
				this.name = name;
				this.numForms = numForms;
			}
		}
		private class user{
			Integer id;
			String name;
			Integer numForms;
			user(int id, String name, int numForms){
				this.id = id;
				this.name = name;
				this.numForms = numForms;
			}
		}
}
