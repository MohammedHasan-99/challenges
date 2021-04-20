/*
In this question, you get the chance to be the hacker your friends would like you to be wink. You get the chance to build a 'brute force password cracker'.

You will be given an imaginary lock that has a boolean method called open. this  'open' method takes a string as a parameter and returns true if the given string matches the lock's password.  

And it's that simple: Write a java method to find out the password for this lock and return it.

Information we know about the password:
 - Allowed set of characters in this lock's password are { a, l, g, o, r, i, t, h, m, 2, 0, @, # }
 - Letters are always in lowercase form
 - All passwords are 3 to 7 characters long
 - The password has at least one letter, one number, and one special character 
 - Answer:(penalty regime: 0, 0, 0, 0, 10, 20, ... %)

*/

static String crack(Lock lock){
    char[] chars = new char[]{'a','l','g','o','r','i','t','h','m','2','0','@','#'};
    String password ="";
    for(int i=3;i<=7;i++){
        password = getPass(i,chars,"",lock);
        try{
            if(lock.open(password)){
                return password;
            }
        }
        catch(NullPointerException nullPointer){  
            continue;                           
        }
    }
    return null;
}
static String getPass(int length,char[] charArray,String pass,Lock lock){
    if(pass.length() == length){
        if(lock.open(pass)){
            return pass;
        }
    }
    else{
        for(int i=0;i<charArray.length;i++){
            String prevPass = pass;
            pass += charArray[i];
            String s = getPass(length,charArray,pass,lock);
            if(s != null) return s;
            pass = prevPass;
        }
    }
    return null;
} 
