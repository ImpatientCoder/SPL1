package animation;

public class Test
{
    public static void main(String[] args)
    {
    	for (int i = 0; i < 10; i++)
        {
            System.out.println("i = " + i);
            try 
            {
                Thread.sleep(1000);
            }catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    	
     }// end of the main method
    
} //end of the class

// The Thread.sleep() need to be executed inside a 
// try-catch block and we need to catch the 
// InterruptedException.


// Using Thread.sleep() we can add delay in our 
// application in a millisecond time. For the example 
// below the program will take a deep breath for one 
// second before continue to print the next value of 
// the loop.