import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class csvReader {

    public static void main (String [] args) {

        String csvFile = "C:/Users/kruz/Desktop/Navigation.csv";        
          
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            MyTreeNode root = new MyTreeNode(null);
            Set <Item> items = new TreeSet<>();
        	
            reader.lines()
		    .skip(1)
            	    .map(line -> line.split(";"))
                    .forEach(parts -> {
                        if(parts[3].equals("False")) 
                            items.add(new Item(parts[0],parts[1],parts[2],parts[4]));});
            reader.close();
            			
            for(Item item : items) {
            	if(item.getParentID() == null)
            	    root.addChild(item);
            	else
            	    builder(root, item);
            }            
            printer(root,".");
        }

        catch(IOException e) {
            System.out.println("File with that name in this path " + csvFile + " was not found");
        }
    }

    static void builder (MyTreeNode root, Item item) {
        for(MyTreeNode node : root.getChildren()) {
            if(node.getData().getID() == item.getParentID()) {
                node.addChild(item);
                return;
            }
            builder(node,item);
        }
    }

    static void printer (MyTreeNode  root, String token) {
        for(MyTreeNode node : root.getChildren()) {
            System.out.println(token + " " + node.getData());
            printer(node,token + "...");
        }
    }
}

class Item implements Comparable<Item> {

    private int ID;
    private String name;
    private Integer parentID;
    private String path;

    public Item(String ID, String name, String parentID, String path) {
        this.ID = Integer.parseInt(ID);
        this.name = name;
        this.parentID = parentID.equals("NULL") ? null : Integer.parseInt(parentID);
        this.path = path;
    }

    public int getID() {
        return ID;
    }

    public Integer getParentID() {
        return parentID;
    }
        
    public int compareTo(Item item) {
    	return path.compareTo(item.path);
    }
    
    public String toString() {
        return name;
    }	
}

class MyTreeNode {

    private Item item = null;
    private List<MyTreeNode> children = new LinkedList<>();

    public MyTreeNode(Item item) {
        this.item = item;
    }

    public void addChild(Item item) {
        MyTreeNode newChild = new MyTreeNode(item);
        children.add(newChild);
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public Item getData() {
        return item;
    }
}