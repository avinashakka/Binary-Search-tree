import java.util.Scanner;


public class BinaryTree 
{
	public static void main(String[] args)
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Menu: 1:Insert  2:Display  3:Search 4:Delete  0:Exit");
		int input = 1;
		BTree BST = new BTree();
		
		while(input > 0)
		{
			System.out.println("Enter your option: ");
			input = S.nextInt();
			
			switch(input)
			{
			case 1: System.out.println("Enter the value to insert");
			 		int inp = S.nextInt();
					BST.insert(inp);
					break;
			case 2: BST.display();
			 		break;
			 
			case 3: System.out.println("Enter an element to search");
			 		int sea = S.nextInt();
			 		System.out.println("The element searc returned: "+BST.search(sea));
			 		break;
			
			case 4: System.out.println("Enter a number to delete");
			 		int rem = S.nextInt();
			 		BST.delete(rem);
			 		break;
			
			case 0: System.exit(0);
			 		break;
			 default: break;
			}
		}
	}

}
