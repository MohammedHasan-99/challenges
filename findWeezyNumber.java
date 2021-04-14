/*
Weezy Strikes Again! 
Thanks to your help last week; Harry was able to use the magical items in the correct order to defeat the evil Zoron in the great battle. Unfortunately for Harry, despite Zoron being wounded, he manages to escape. Zoron is now in his volcano - yes he lives in a volcano 🌋 - gathering his strength. Harry now needs to move fast. He needs to get to Zoron and deliver the final blow before he regains his unbeatable strength. Fortunately for Harry, he has his array of wisdom with him, and he can use it to defeat Zoron again. 

Standing across the field was Weezy, furious to learn that you had his previous magic undone, he gathers his strength and casts a new vicious spell on the array of wisdom. This new spell is so powerful that it increases the size of the array by 1 and takes one random number that is in the array, and cause it to duplicate and fill in 2 or more cells, how many times is this number duplicate? we don't know. it depends on how angry Weezy was at the moment!

Now, we need to fix the array of wisdom again. It is a more challenging task this time. The first step wee needs to do is to find that number that Weezy duplicated (let's call it the Weezy number). But it is the array of wisdom we are dealing with here, we still can not make any changes to this array. and we do not have the magical resources to create another structure to hold the numbers for us.. and we still need to do this task very very quickly, otherwise Zoron will regain his strength and all what we did will be for nothing! 

Now, your help is needed again. As the skilled java programmer, you are, you can help by writing the correct code.

So, write a java method called findWeezyNumber(int [] array) that takes the changed array of wisdom and returns that illusive Weezy number we are looking for.

Be careful:

- Note that weezy changed the size of the array of wisdom ( it is now of size n+1), however it still contains the numbers from 1 to n in a particular order (with the new changes Weezy introduced)    
- You may not change anything in the array.
- Your code needs to be quick. We do not have any time left.
- You do not have the resources to create any other structure that is the size of the array.
- There is only one Weezy number in the array.
- The array of wisdom always has a size > 3 so you don't have to worry about that.
*/

public static int findWeezyNumber(int[] array) {
    int tortoise = array[0];       
    int hare = array[array[0]];     
    while(hare != tortoise){        
        tortoise = array[tortoise]; 
        hare = array[array[hare]];  
    }
    tortoise = 0;                  
    while(hare != tortoise){       
        tortoise = array[tortoise]; 
                                    
        hare = array[hare];        
    }
    return tortoise;
    
}
