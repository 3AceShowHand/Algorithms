/*
1. All code in java must be part of a class.
2. For code to run we need public static void main(String[] args)
*/
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello world");

        /*
        3. Java variable must have a specific type which can never change.
        4. Types are verified before the code even run.
        */
        int x = 0;
        while(x < 10){
            System.out.println(x);
            x = x + 1;
        }
        System.out.println(larger(-5, 10));
    }
    
    /*
    5. Functions must be declared as part of a class in Java, all functions are methods.
    6. Functions in Java only return one value.
    */    
    
    /** Returns the larger of x and y. */
    public static int larger(int x, int y){
        if (x > y)
            return x;
        return y;
    }
}



