package big_o_n;

public class Big_o_n {

    public static void main(String[] args) {
        
        int s1_steps =0, s2_steps=0, s3_steps=0;
        int N;
        
        System.out.print("Enter an integer value for N: ");
        N = new java.util.Scanner(System.in).nextInt(); // LOOK AT THIS SHORTHAND FOR SCANNER
        
        int s=0; s1_steps++; //s1
        s2_steps++;
        for(int i=1; i<=N; s2_steps++,i++) //s2
        {    
            s = s + i; s3_steps++;
        } 
        System.out.printf("S1 executed %d times\n", s1_steps);
        System.out.printf("S1 executed %d times\n", s2_steps);
        System.out.printf("S1 executed %d times\n", s3_steps);
    }
    
}
