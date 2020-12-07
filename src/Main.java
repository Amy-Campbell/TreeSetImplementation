/**
 * ThomasWilliamson #588206
 * Reference: http://www.java2s.com/ref/java/java-algorithms-binary-search-tree-animation.html
 * 
 * This class is the main entry point of the tree viewer application
 */


import java.util.TreeSet;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
//    AVLTree<Integer> tree = new AVLTree<>(); // Create a tree
//
//    BorderPane pane = new BorderPane();
//    AVLTView view = new AVLTView(tree); // Create a View
//    pane.setCenter(view);
//
//    TextField tfKey = new TextField();
//    tfKey.setPrefColumnCount(3);
//    tfKey.setAlignment(Pos.BASELINE_RIGHT);
//    Button btInsert = new Button("Insert");
//    Button btDelete = new Button("Delete");
//    HBox hBox = new HBox(5);
//    hBox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete);
//    hBox.setAlignment(Pos.CENTER);
//    pane.setBottom(hBox);
//
//    btInsert.setOnAction(e -> {
//      int key = Integer.parseInt(tfKey.getText());
//      if (tree.search(key)) { // key is in the tree already
//        view.displayTree();
//        view.setStatus(key + " is already in the tree");
//      } else {
//        tree.insert(key); // Insert a new key
//        view.displayTree();
//        view.setStatus(key + " is inserted in the tree");
//      }
//    });
//
//    btDelete.setOnAction(e -> {
//      int key = Integer.parseInt(tfKey.getText());
//      if (!tree.search(key)) { // key is not in the tree
//        view.displayTree();
//        view.setStatus(key + " is not in the tree");
//      } else {
//        tree.delete(key); // Delete a key
//        view.displayTree();
//        view.setStatus(key + " is deleted from the tree");
//      }
//    });
//
//    // Create a scene and place the pane in the stage
//    Scene scene = new Scene(pane, 450, 250);
//    primaryStage.setTitle("AVLTreeAnimation");
//    primaryStage.setScene(scene);
//    primaryStage.show();
//    
//    tree.insert(5);
//    tree.insert(3);
//    tree.insert(13);
//    tree.insert(15);
//    tree.insert(10);
//    tree.insert(7); 
//        
//    tree.insert(12);
//    
//    view.displayTree();
	  TreeSet<Integer> nodes = new TreeSet<>();
		TreeSet<Patient> ps1 = new TreeSet<Patient>();
		int[] list = {12,13,14};
		
		nodes.add(13);
		nodes.add(15);
		nodes.add(3);
		ps1.add(new Patient(9000111000l,"existing pt",0,0));
		
		TreeSet<Integer> treeset2 = new TreeSet<>();
		
		treeset2.add(14);
		
		treeset2.addAll(nodes);
		
		ps1.toArray();
		Object[] nodeArray = treeset2.toArray();
		
		for (int i = 0; i<nodeArray.length;i++) {
			System.out.println(nodeArray[i]);
		}
		
		System.out.println(nodes.contains(13));
		nodes.clear();
		System.out.println(nodes.contains(13));
		System.out.println(nodes.contains(2));
  }

  public static void main(String[] args) {
    launch(args);
  }
}