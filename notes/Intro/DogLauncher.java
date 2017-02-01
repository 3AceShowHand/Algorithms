public class DogLauncher{
    public static void main(String[] args){

        Dog smalldog;               // Declaration of a dog instance.
        new Dog(20);                // Instantiation of the Dog class as a Dog object.
        smalldog = new Dog(5);      // Instantiation and Assignment.
        Dog d = new Dog(51);        // Declaration, Instantiation and assign().
        d.makeNoise();
        
        // useage of static method.
        Dog d2 = new Dog(100);
        Dog bigger = Dog.maxDog(d, d2);
        bigger.makeNoise();

        // how to use args.
        int i = 0;
        int sum = 0;
        while(i < args.length){
            sum += Integer.parseInt(args[i]);
            i = i + 1;
        }
        System.out.println(sum);
    }
}