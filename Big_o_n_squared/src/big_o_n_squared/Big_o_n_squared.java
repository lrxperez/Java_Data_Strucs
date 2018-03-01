package big_o_n_squared;

public class Big_o_n_squared {

    public static void main(String[] args) {
        
        int s1_steps =0, s2_steps=0, s3_steps=0, s4_steps=0;
        int N;
        
        System.out.print("Enter an integer value for N: ");
        N = new java.util.Scanner(System.in).nextInt(); // LOOK AT THIS SHORTHAND FOR SCANNER
        
        int s=0; s1_steps++; //s1
        s2_steps++;
        for(int i=1; i<=N; s2_steps++,i++) //s2
        {    
            s3_steps++;
            for(int j=1; j<=N; s3_steps++,j++) //s3
            {
                s = s + i; s4_steps++; //s4
            } 
        } 
        System.out.printf("S1 executed %d times\n", s1_steps);
        System.out.printf("S2 executed %d times\n", s2_steps);
        System.out.printf("S3 executed %d times\n", s3_steps);
        System.out.printf("S4 executed %d times\n", s4_steps);
    }
    
}
