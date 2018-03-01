package big_o_mystery_2;

public class Big_o_mystery_2 {

    public static void main(String[] args) {
        
        int s1_steps =0, s2_steps=0, s3_steps=0, s4_steps=0, s5_steps=0;
        int s6_steps = 0;
        int N;
        
        System.out.print("Enter an integer value for N: ");
        N = new java.util.Scanner(System.in).nextInt(); // LOOK AT THIS SHORTHAND FOR SCANNER
        
        int s=0; s1_steps++; //s1
        s2_steps++;
        for(int i=1; i<=N; s2_steps++,i++) //s2
        {    
            s3_steps++;
            for(int j=1; j<=N; s3_steps++,j++) //s3 THIS FOR LOOP WILL RUN N SQUARED TIMES
            {
                s4_steps++; //s4
                s=s+j;
            } 
            
            s5_steps++;
            for(int k=1; k<=N; s5_steps++, k*=2)  //s5 THIS FOR LOOP WILL ALSO RUN N SQUARED TIMES
            {
                s=s+k;
                s6_steps++; //s6
            }
        } 
        System.out.printf("S1 executed %d times\n", s1_steps);
        System.out.printf("S2 executed %d times\n", s2_steps);
        System.out.printf("S3 executed %d times\n", s3_steps);
        System.out.printf("S4 executed %d times\n", s4_steps);
        System.out.printf("S5 executed %d times\n", s5_steps);
        System.out.printf("S6 executed %d times\n", s6_steps);
    }
    
}
