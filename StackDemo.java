import java.util.*;

class Stack
{
	ArrayList<Integer> arr;
	int top = -1;
	
	public Stack()
	{
		arr = new ArrayList<Integer>();
	}
	
	public void push(int a)
	{
		arr.add(a);
		top++;
	}
	public int pop()
	{
		if(top != -1)
		{
			int temp = arr.remove(top);
			top--;
			return temp;
		}
		else
		{
			//no elements available
			return -1;
		}
	}
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void show()
	{
		for(int i =0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
	}
	public ArrayList<Integer> reverse()
	{
		Stack s = new Stack();
		for(int i =0;i<arr.size();i++)
		{
			s.push(arr.get(i));
		}
		arr.clear();
		for(int i =0;i<s.arr.size();i++)
		{
			arr.add(s.pop());
		}
		return arr;
	}
}
public class StackDemo
{
	public static void main(String args[])
	{
		Stack s = new Stack();
		String expression = "(a+b)(a-b)[";
		
		s.push(1);
		s.push(2);
		s.show();
		
		System.out.println("Pop operation!" + s.pop());
		
		s.push(4);
		s.push(5);
		
		s.show();
		
		
		
		Stack balanceParenthesis = new Stack();
		for(int i =0;i<expression.length();i++)
		{
			char c = expression.charAt(i); 
			if(c == '(' || c == '{' || c == '[')
			{
				
				balanceParenthesis.push(c);
			}
			else if(c==')')
			{
				if(balanceParenthesis.arr.get(balanceParenthesis.top) == (int)'(')
				{
					int temp = balanceParenthesis.pop();
				}
			}
			else if(c=='}')
			{
				if(balanceParenthesis.arr.get(balanceParenthesis.top) == (int)'{')
				{
					int temp = balanceParenthesis.pop();
				}
			}
			else if(c==']')
			{
				if(balanceParenthesis.arr.get(balanceParenthesis.top) == (int)'[')
				{
					int temp = balanceParenthesis.pop();
				}
			}
		}
		
		if(balanceParenthesis.isEmpty())
		{
			System.out.println("Parenthesis are balanced!");
		}
		else
		{
			System.out.println("Parenthesis are not balanced!");
		}
	}	
}
		