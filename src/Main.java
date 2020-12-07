/**
 * ThomasWilliamson #588206
 * Reference: http://www.java2s.com/ref/java/java-algorithms-binary-search-tree-animation.html
 * 
 * This class is the main entry point of the tree viewer application
 */







public class Main {
  

  public static void main(String[] args) {
	  TreeSet<Integer> nodes = new TreeSet<>();
	  TreeSet<Integer> nodes2 = new TreeSet<>();
		TreeSet<Patient> ps1 = new TreeSet<Patient>();
		int[] list = {12,13,14};
		
		nodes.add(13);
		nodes.add(15);
		nodes.add(3);
		
		nodes2.add(13);
		nodes2.add(15);
		nodes2.add(3);
		System.out.println(nodes.contains(13));
		
		ps1.add(new Patient(9000111000l,"existing pt",0,0));
		
		TreeSet<Integer> treeset2 = new TreeSet<>();
		TreeSet<String> stringSet = new TreeSet<>();
		
		stringSet.add("Hello");
		stringSet.add("World");
		boolean contain = stringSet.contains("Hello");
		System.out.println(contain);
		System.out.println(nodes.contains(13));
		
		treeset2.add(14);
		treeset2.add(15);
		treeset2.add(17);
		
		ps1.toArray();
		Object[] nodeArray = treeset2.toArray();
		
		for (int i = 0; i<nodeArray.length;i++) {
			//System.out.print(nodeArray[i] + " ");
		}
		
		//System.out.println(nodes.contains(13));
		//nodes.clear();
		//System.out.println(nodes.contains(13));
		//System.out.println(nodes.contains(2));
		
		
			Object[] testArr = treeset2.toArray();
			//System.out.println(testArr[0]);
			//System.out.println(testArr[1]);
			for(int i = 0; i<testArr.length; i++) {
				//System.out.println(i + ": " + testArr[i]);
			}
			for(Object obj:testArr) {
				if (!treeset2.contains(obj)) {
					//System.out.println("test toArray() on set of String objects");		
				}
			}
		
  }
}