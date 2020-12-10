import java.util.ArrayList;
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
	  TreeSet<String> colours = new TreeSet<>();
	  TreeSet<String> colours2 = new TreeSet<>();
	  colours.add("purple");
	  colours.add("blue");
	  nodes.add(0);
	  nodes.add(1);
	  nodes.add(2);
	  nodes.add(7);
	  nodes2.add(0);
	  nodes2.add(1);
	  nodes2.add(2);
	  nodes2.add(5);
	System.out.println(nodes.toArray()[0]);
	
	ArrayList<String> color_list = new ArrayList<String>(4);
	
	
	color_list.add("blue");
	color_list.add("red");
	color_list.add("green");
	color_list.add("orange");
	
	colours2.addAll(colours);
	
	System.out.println(colours.addAll(color_list));
	for (int i = 0; i<colours2.size(); i++) {
		System.out.println(colours2.toArray()[i]);
	}
	
	
	  
	  
	  
	  
	  
	  
		
  }
}