package Lab7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RPN {
	
	private static String postfix;
	private static String infix = "";
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Infix");
		infix = in.nextLine();
		
		postfix = infixToPostfix(infix);
		
		System.out.println("Postfix equivalent: "+ postfix);
		
		int result = evauluation(postfix);
		System.out.println("Evaulation Result: "+result);
		
		
	}
		

	private static Map<String, Integer> operators = new HashMap<String, Integer>(){
		{
			put("-", 1);
			put("+", 2);
			put("*", 3);
			put("/", 4);
		}
	};
//8-2+8/4+6-1-6/2
	

	
    private static boolean isHigerPrec(String str1, String str2) {
        return operators.get(str2) >= operators.get(str1);
    }
    
    
	private static String infixToPostfix(String infix) {
		
		System.out.println("Given Infix: "+infix);
		System.out.println("Changing to Postfix...");
	
        StringBuilder postfix_string = new StringBuilder();
		CS401StackLinkedListImpl<String> stack = new CS401StackLinkedListImpl<String>();
		
		
		 for (String token : infix.split("\\s")){
			
			
			if(operators.containsKey(token)){
				
				if(stack.size() == 0)
					stack.push(token);
				
				else{
					while(stack.size()>0 && isHigerPrec(token, stack.top())){
						postfix_string.append(stack.pop()).append(' ');
						System.out.println(postfix_string);
					}
					stack.push(token);	
				}
			}
				
			else {		
				postfix_string.append(token).append(' ');
			}
		}
		
		while (stack.size() > 0)
			postfix_string.append(stack.pop()).append(' ');// = postfix_string + stack.pop();
			
		return postfix_string.toString();
		
			
	}
	
	private static int evauluation(String postfix) {
		
		CS401StackLinkedListImpl<Integer> stackNew = new CS401StackLinkedListImpl<Integer>();
		int l = postfix.length();
		int count = 0;
		int res = 0;
		
		for(String token: postfix.split("\\s")){
			
			char ch = token.charAt(0);
			
			if(Character.isDigit(ch))  {
		          stackNew.push(Integer.parseInt(String.valueOf(ch)));
			}
			
			else{
				int x = stackNew.pop();  
				int y = stackNew.pop();  
				
				switch(ch){ 
				
					case '+':
						res = x+y;
						break;  
					
					case '-':
						res = y-x;  
						break;  
					case '*':
						res = x*y;  
						break;  
					case '/':
						res = y/x;
						break;  
					
					default: return res;
						//break;
				}  
				stackNew.push(res);
			}
		}
		res = stackNew.pop();
		return res;
	}
}
