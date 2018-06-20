import java.util.*;
import java.util.InputMismatchException;

	class Stack 
	{

	static int x;
	    Object[] data = new Object[6];
	    int node = 0;
	   int currentSize = 6;
	   
		public Object get(int index) 
		{
	        return data[index];
	    }
	    public void add(Object value) 
		{
	        if (this.currentSize == this.node) 
			{
	            reinitializeArray();
	        }
	        this.data[node] = value;
	        node++;
	        System.out.println("Added " + value + " at Node " + (this.node - 1));
	    }

	    public void set(int index, Object value) 
		{
	        this.data[index] = value;
	    }

	    public void reinitializeArray() 
		{
	        System.out.println("\nReinitializing Array with size " + (currentSize +(currentSize/2)));
	        Object[] temp = new Object[currentSize +(currentSize/2)];
	        currentSize = currentSize +(currentSize/2);
	        for (int i = 0; i < node; i++) 
			{
	            temp[i] = this.data[i];
	        }
	        this.data = temp;
	    }

	    public Object getCurrentNode() 
		{
	        return node;
	    }

	    public Object getCurrentSize() 
		{
	        return currentSize;
	    }

	    public static void main(String[] args) 
		{
	        dynamic<Integer> arr1 = new dynamic<Integer>();
			System.out.println("Options:");
			System.out.println("1. Add");
			System.out.println("2. Get");
			System.out.println("3. Set");
			System.out.println("4. Current Node");
			System.out.println("4. Current Size");
			System.out.println("6. Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a choice");
			int a = sc.nextInt();
			while(a != 6)
			{
				if(a == 1)
				{
					System.out.println("Enter the number you want to enter:");
					int n = sc.nextInt();
					arr1.add(new Integer(n));
				}
				
				if(a == 2)
				{
					System.out.println("Enter the index you want to get:");
					x = sc.nextInt();
					if((arr1.get(x)) == null || (x > arr1.currentSize))
					{
						throw new ArrayIndexOutOfBoundsException("Invalid Index");
					}
					else
					{	
						System.out.println(arr1.get(x));
					}
				}
				
				if(a == 3)
				{
					System.out.println("Enter the index you want to set:");
					int n = sc.nextInt();
					System.out.println("Enter the number you want to set:");
					int n1 = sc.nextInt();
					arr1.set(n,new Integer(n1));
				}
				if(a == 4)
				{
					System.out.println("\nCurrent Node: " + arr1.getCurrentNode());
				}
				
				if(a == 5)
				{
					System.out.println(" Current Size: " + arr1.getCurrentSize());
				}
				
				System.out.println("Enter a number");
				a = sc.nextInt();
			}
	    }
	}