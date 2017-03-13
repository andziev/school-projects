import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

public class PM10 {

    public static void main (String [] args) {
        
    	Scanner sc = new Scanner (System.in);
        int N = Integer.parseInt (sc.nextLine());
        Map <String,Opstina> map = new HashMap <> (N);
        
        for(int i=0; i<N; i++) {
        	String [] parts = sc.nextLine().split("\\s++");
            String opstina = parts[0];
            double zagaduvanje = Double.parseDouble(parts[1]);

            if(map.containsKey(opstina)) {
            	Opstina insert = map.get(opstina);
                double key = insert.getZag ();
                int value = insert.getNum ();
                map.put(opstina,new Opstina (key+zagaduvanje,value+1));
            }
            else {
            	map.put(opstina,new Opstina (zagaduvanje,1));
            }
        }
        String check = sc.nextLine();
        Opstina opstina = map.get(check);        
       
        double key = opstina.getZag ();
        int value = opstina.getNum ();
        DecimalFormat df = new DecimalFormat("######.##");        
        System.out.println(df.format(key/value));
    }
}

class Opstina {
    
    private double zagaduvanje;
    private int number;
    
    public Opstina (double zagaduvanje,int number) {
        this.zagaduvanje = zagaduvanje;
        this.number = number;
    }
    public double getZag () {
    	return zagaduvanje;
    }
    public int getNum () {
    	return number;
    }
}
