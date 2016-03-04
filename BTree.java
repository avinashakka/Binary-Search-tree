
public class BTree 
{
	Node root = null;
	
	public void insert(int val)
	{
		if(this.root == null)
		{
			this.root = new Node();
			this.root.value = val;
			this.root.right = null;
			this.root.left = null;			
		}
		else
		{
			if(val < this.root.value)
			{
				this.root.left = InsertNode(this.root.left,val);
			}
			else
			{
				this.root.right = InsertNode(this.root.right,val);
			}
		}
		
	}
	
	public Node InsertNode(Node N, int val)
	{
		if(N == null)
		{
			N = new Node();
			N.value = val;
			N.right = null;
			N.left = null;
			return N;
		}
		else
		{
			if(val < N.value)
			{
				N.left = InsertNode(N.left,val);
				return N;
			}
			else
			{
				N.right = InsertNode(N.right,val);
				return N;				
			}
			
		}
		
	}
	
	public boolean search(int val)
	{
		if(this.root == null)
		{
			return false;
		}
		else if(this.root.value == val)
		{
			return true;
		}
		else
		{
			Node next = root;
			while(next != null)
			{
				if(val > next.value)
					next = next.right;
				else if(val < next.value)
					next = next.left;
				else
					return true;
				
			}
		}
		return false;
	}
	
	public void delete(int val)
	{
		if(this.root == null)
		{
			
		}
		else
			this.root = deleteNode(this.root,val);
	}
	
	public int pickMinRight(Node R)
	{
		if(R.left == null)
		{
			return R.value;
		}
		else
		{
			Node next = R;
			while(next.left != null)
			{
				next = next.left;
			}
			return next.value;
		}
	}
	
	public Node deleteNode(Node N,int val)
	{
		if(N == null)
		{
			
		}
		if(N.value == val)
		{
			//so this is the node to be deleted
			//3 scenarious possible
			//1: The node may have no children --> No problem just delete it and return null
			//2: The Node may have just one child --> just cut the node and send the child as the link
			//3: Node has both children
			
			if(N.left == null && N.right == null)
			{
				N = null;
				return N;
			}
			else if(N.left == null || N.right == null)
			{
				if(N.left==null)
				{
					N = N.right;
				}
				else
				{
					N = N.left;
				}
			}
			else
			{
				int min = pickMinRight(N.right);
				N.right = deleteNode(N.right,min);
				Node temp = new Node();
				temp.left = N.left;
				temp.right = N.right;
				temp.value = min;
				N = temp;
			}
			
		}
		else
		{
			if(N.value > val)
			{
				if(N.left != null)
				{
					N.left =  deleteNode(N.left,val);
				}
				else
					return N;
			}
			else
			{
				if(N.right != null)
				{
					N.right = deleteNode(N.right,val);
				}
				else
					return N;
			}			
		}
		return N;
	}
	
	public void display()
	{
		System.out.println("The Binary Search tree:");
		
		if(root == null)
			System.out.println("Empty tree !");
		else
		{
			String x = "";
			displayNode(this.root);
			System.out.println();		
		}	
		
	}
	

	public void displayNode(Node N)
	{
		if(N==null)
		{
			//System.out.println("null");
			return;
		}
		System.out.println();
		System.out.print("Parent: "+N.value);
		if(N.left != null)
		{
			System.out.print("Left Child: "+N.left.value);
		}
		if(N.right!=null)
		{
			System.out.print("Right Child: "+N.right.value);
		}
		
		if(N.left != null)
		{
			displayNode(N.left);
		}
		if(N.right!=null)
		{
			displayNode(N.right);
		}
		//System.out.println();
			/*String NewIndent;
			if(indent=="")
			{
				NewIndent = "..";
			}
			else
			{
				NewIndent = "..."+indent;
			}
			
			displayNode(N.left,NewIndent);
			System.out.println(indent+N.value);
			displayNode(N.right,NewIndent);*/
		
	}

}
