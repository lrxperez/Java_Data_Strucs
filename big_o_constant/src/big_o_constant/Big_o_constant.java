package big_o_constant;

public class Big_o_constant {

    public static void main(String[] args) {
        
        int s1_steps =0;
        int N;
        
        System.out.print("Enter an integer value for N: ");
        N = new java.util.Scanner(System.in).nextInt(); // LOOK AT THIS SHORTHAND FOR SCANNER
        
        int s=0; s1_steps++; //s1
        
        System.out.printf("S1 executed %d times\n", s1_steps);
        
    }
    
}
