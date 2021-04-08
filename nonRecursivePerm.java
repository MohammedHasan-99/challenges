/*
Write a non-recursive Java method for printing all permutations of the numbers {1,2, ..., n}
Hint: use an explicit stack

Test	                            Input	       Result
permutationNorRecursive(num);       2           21
                                                12
*/

public static void permutationNorRecursive(int n){
    String num = "";
    for(int i = 1;i<=n ;i++)
    num += i;
    
    Stack<String> s1 = new Stack<String>(); 
    Stack<String> s2 = new Stack<String>(); 
    for(int i=0;i<n ;i++){
        s1.push(num.charAt(i) + "");
        s2.push(num.substring(0,i) + num.substring(i+1));
    }
    while(!s1.empty()){
        String part1 = s1.pop();
        String part2 = s2.pop();
        if(part2.length() == 0)
            System.out.println(part1);
            
        else{
            for(int i=0;i<part2.length();i++){
                char c = part2.charAt(i);
                String temp = part1 + c;
                s1.push(temp);
                s2.push(part2.substring(0,i) + part2.substring(i+1));
            }    
        }
    }

}
