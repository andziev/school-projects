import java.util.*;
 
public class Rodendeni {
    public static void main (String [] args) {
       
        Scanner sc = new Scanner (System.in);      
        int n = Integer.parseInt(sc.nextLine());
        Map <String,String> birthDays = new TreeMap <> ();
        for(int i=0; i<n; i++) {
            String [] parts = sc.nextLine().split("\\s++");
            birthDays.put(parts[0] + " " + parts[1], parts[2]);
        }
        String target = sc.nextLine();
        boolean anyMatch = false;
        for(String name : birthDays.keySet()) {
            String date = birthDays.get(name);
            if(date.substring(0,5).equals(target.substring(0,5))) {
                int days = Integer.parseInt(target.substring(6,10))
                        - Integer.parseInt(date.substring(6,10));
                System.out.format("%s %d\n", name, days);
                anyMatch = true;
            }
        }
        if(!anyMatch)
            System.out.println("Nema");
    }
}
