class LinkedListNode
{
	int data;
	LinkedListNode nextNode;
	static LinkedListNode head = new LinkedListNode(); 
	
	LinkedListNode()
	{
		this.data = 0;
		this.nextNode = null;
	}
	public void addElementAtEnd(int data)
	{
		LinkedListNode node = new LinkedListNode();
		node.data = data;
		node.nextNode = null;
		LinkedListNode prevNode = this;
		//System.out.println(node.data);
		
		while(prevNode.nextNode != null)
		{
			prevNode = prevNode.nextNode;
		}
		prevNode.nextNode = node;
	}
	public void addElementAtStart(int data)
	{
		LinkedListNode tempNode = this.nextNode;
		LinkedListNode node = new LinkedListNode();
		node.data = data;
		this.nextNode = node;
		
		node.nextNode = tempNode;
		
	}
	public void addElementAt(int data,int pos)
	{
		int i = 1;
		LinkedListNode tempNode = this.nextNode;
		LinkedListNode node = new LinkedListNode();
		node.data = data;
		
		while(i < pos-1)
		{
			tempNode = tempNode.nextNode;
			i+=1;
		}
		node.nextNode = tempNode.nextNode;
		tempNode.nextNode = node;
		
	}
	public void deleteAt(int pos)
	{
		int i = 1;
		LinkedListNode tempNode = this.nextNode;
		
		while(i < pos-1)
		{
			tempNode = tempNode.nextNode;
			i+=1;
		}
		tempNode.nextNode = tempNode.nextNode.nextNode;
	}
	public void displayList()
	{
		LinkedListNode prevNode = this.nextNode;
		//System.out.println(node.data);
		
		while(prevNode != null)
		{
			System.out.println(prevNode.data);
			prevNode = prevNode.nextNode;
		}
	}
	public void reverseList()
	{
		LinkedListNode prevNode = null;
		LinkedListNode current = this.nextNode;
		LinkedListNode temp;
		
		while(current != null)
		{
			
			temp = current.nextNode;
			current.nextNode = prevNode;
			prevNode = current;
			current = temp;
		}
		this.nextNode = prevNode;
	}
	public String printRecursively()
	{
		if(this.nextNode != null)
			return "" + this.nextNode.data + " " + this.nextNode.printRecursively();
		else
			return "";
	}
	public String printReverseRecursively()
	{
		if(this.nextNode == null)
		{
			return "";
		}
		else
		{
			return "" + this.nextNode.printReverseRecursively() + " " +this.nextNode.data;
		}			
	}
	public void reverseRecursively()
	{
		LinkedListNode temp = this;
		
		if(this.nextNode == null)
		{
			System.out.println("Head is " +this.data);
			head.nextNode = this;
		}
		else if(temp.data !=0)
		{
			temp.nextNode.reverseRecursively();
			LinkedListNode node = temp.nextNode;
			node.nextNode = temp;
			temp.nextNode = null;
			System.out.println("Exchanging for "+ node.data +" and " +temp.data);
			
		}
		else
		{
			temp.nextNode.reverseRecursively();
		}
	}
}		

public class LLDemo
{
	public static void main(String[] args)
	{
		LinkedListNode head = new LinkedListNode();
		
		head.addElementAtEnd(1);
		head.addElementAtEnd(2);
		head.addElementAtEnd(3);
		
		head.addElementAtStart(4);
		head.addElementAtStart(5);
		
		head.addElementAt(11,2);
		head.displayList();
		head.deleteAt(3);
		head.displayList();
		
		head.reverseList();
		head.displayList();
		
		System.out.println();
		System.out.println(head.printRecursively());
		System.out.println();
		System.out.println(head.printReverseRecursively());
		
		head.displayList();
		head.reverseRecursively();
		head.head.displayList();
		
		//System.out.println(head.printReverseRecursively());
	}
}