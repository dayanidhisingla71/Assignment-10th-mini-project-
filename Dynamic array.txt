import java.util.Scanner;
public class DynamicArray {
	    int i=0,j=0;
		int n=8;
		int arr[];
			public DynamicArray() {
				arr = new int[n];
		}
			public int size()
		{
			return i;
		}
		public boolean isEmpty()
		{
			if(size()==0)
				return true;
			else
				return false;
		}
		
		public int get(int a)
		{
			if(a<0 || a>i)
			{
				throw new ArrayIndexOutOfBoundsException("Entered index is not valid.");
			}
			else
			{
				return arr[a];
			}
		}
		
		public void add(int a)
		{
			if(i==arr.length)
			{
				Make();
			}
			else
			{
				arr[i] = a;
				i++;
			}
		}
		
		public void Make()
		{
			int newarr[] = arr;
			arr = new int[(int) (arr.length*1.5)];
			for(int j = 0; j<newarr.length; j++)
			{
				arr[j] = newarr[j];
			}
		}
		
		public void add(int a, int index)
		{
			int temp = 0;
			if(index<0)
				throw new ArrayIndexOutOfBoundsException("Index not valid.");
			else if(i==arr.length)
				Make();
				for(j=0 ; j<arr.length; j++)
				{
					if(j==index)
					{
						temp = arr[j];
						break;
					}
				}
				arr[index] = a;
				for(int j = index+1;j<i+1;j++)
				{
					int temp2;
					temp2 = arr[j];
					arr[j] = temp;
					temp = temp2;
				}
				i++;
			}
		
		public int removeLast()
		{
			if(i<1)
				throw new ArrayIndexOutOfBoundsException("No last element.");
			else
			{
				int ele = arr[i-1];
				arr[i-1] = 0;
				i--;
				return ele;
			}
		}	
		
		public void show()
		{
			for(int j=0;j<arr.length;j++)
				System.out.print(arr[j] + " ");
			System.out.println();
		}
		
		public void clear() {
			for(int j=0; j<i; j++)
			{
				arr[j] = 0;
			}
			System.out.println("Array is cleared");
		}

		public static void main(String[] args) {
			
			DynamicArray ar = new DynamicArray();
			
			int choice, element, index;
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Add element in last");
			System.out.println("2. Add element at specific index");
			System.out.println("3. Remove last item");
			System.out.println("4. Check if array is empty");
			System.out.println("5. Get element at index");
			System.out.println("6. Get size of array");
			System.out.println("7. Display array");
			System.out.println("8. Clear array");
			System.out.println("9. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			while(choice != 9)
			{
				switch(choice)
				{
				case 1:
					System.out.print("Enter element: ");
					element = sc.nextInt();
					ar.add(element);
					break;
				case 2:
					System.out.print("Enter element: ");
					element = sc.nextInt();
					System.out.print("Enter index: ");
					index = sc.nextInt();
					ar.add(element, index);
					break;
				case 3:
					int ele = ar.removeLast();
					System.out.println("Element removed: " + ele);
					break;
				case 4:
					if(ar.isEmpty())
						System.out.println("Array is empty");
					else
						System.out.println("Array is not empty");
					break;
				case 5:
					
					System.out.print("Enter index: ");
					index = sc.nextInt();
					ar.get(index);
					break;
				case 6:
					int size = ar.size();
					System.out.println("Size of array: " + size);
					break;
				case 7:
					ar.show();
					break;
				case 8:
					ar.clear();
					break;
				}
				System.out.println("1. Add the element in last");
				System.out.println("2. Add the element at specific index");
				System.out.println("3. Remove the last item");
				System.out.println("4. Checking if the array is empty or not");
				System.out.println("5. Get element at index");
				System.out.println("6. Getvthe size of array");
				System.out.println("7. Display the array");
				System.out.println("8. Clear the array");
				System.out.println("9. Exit");
				System.out.print("Enter choice: ");
				choice = sc.nextInt();
			}		
			sc.close();
		}
	}

