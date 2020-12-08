import java.util.Collection;

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
		
	  nodes.add(0);
	  nodes.add(1);
	  nodes.add(2);
	  
	  nodes2.addAll(nodes);
	  
	  System.out.println(nodes.contains(0));
	  System.out.println(nodes2.contains(0));
	  
	  
	  
	  
	  
	  
		
  }
}