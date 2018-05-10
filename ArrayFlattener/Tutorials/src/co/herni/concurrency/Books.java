package co.herni.concurrency;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Books {
	  final Map<Integer, String> map = new ConcurrentHashMap<>();
	   int add(String title) {
	    final Integer next = this.map.size() + 1;
	    this.map.put(next, title);
	    return next;
	  }
	  String title(int id) {
	    return this.map.get(id);
	  }
	  public Books() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Books [map=" + map + "]";
	}
	
	public static void main(String[] args) throws IOException {
		
		//anagram
		String one, two = one = null;
		one = "asder";
		//one.chars().filter(c -> c <= c).sorted().forEach(c -> System.out.print(c+" "));
		//char[] chars = one.toCharArray();
		//one.chars().
		//System.out.println(70%5);
		
		
		//System.out.println(sum);
		
		/*Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = null;
		try {
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);*/
		//List<scb> scbsList = new ArrayList<>();/*
//		for(int i=0;i<numscb;i++){
//			scb sccb = new Books().new scb(i,"afiliado"+i,getNumber(i));
//			scbsList.add(sccb);
//		}
		//System.out.println(scbsList);
		
//		int s = 0;
//		int[] sd = {20,10,11,12,13,4,8,7,9,6};
//		List<Integer> percs = new ArrayList<>(Arrays.asList());
//		for(int k = 0; k<sd.length;k++)
//			percs.add(sd[k]);
//		List<user> userrList = new ArrayList<>();
//		System.out.println();
//		Collections.sort(percs,	(Integer in1, Integer in2) -> in1 - in2 );
		
		/*user userr = new Books().new user(i,"user"+i,-1);
		userr.numForms = getUsernumform(i);
		System.out.print(i+". ");
		System.out.println(userr.numForms);
		userrList.add(userr);*//*
		for(int i=numusers-1;i>=0;i--){
			
			int forms = ( (percs.get(i)*12000) / 100);
			System.out.println(forms);
			s+=forms;
		}
		System.out.println(s);
		
		System.out.println(percs);
		//Integer.p
		
		String text = "Text to save to file";
		Files.write(Paths.get("./fileName.txt"), text.getBytes());*/
		final String toProperCase = "  this  fucking job sucKs you fuckinG piece of a sHite  ";
		//System.out.println(toProperCase);
		//System.out.println(toProperCase(toProperCase));
		//System.out.println(swapCase(toProperCase));
		//System.out.println(super_reduced_string("aabbccffe"));
		//System.out.println(wordsInCamelCase("saveChangesInTheEditorA"));
		//System.out.println(twoCharaters("jababdjd"));
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
		
		
		//jababdjd
		//sin J: ababdd -- invalid
		//sin A: jbbdjd -- invalid
		//sin B: jdbdd -- invalid
		//sin D: jababj -- valid
		
		
	}
}