/*
##The Array and the evil wizard##
Once upon a time, far far away; Harry was getting ready for the final battle with the great evil wizard Zoron. Zoron was too powerful indeed! to defeat him, Harry has only one chance. He has to collect a total of n magical items, and throw them at Zoron in a very specific order. Harry was up to this task, he collected all the magical items and numbered them 1 to n. He also did his studies to figure out the exact order in which he should use them. Thankfully he was successful in his quest, and he ended up recording that specific order in his secrete array of wisdom. 

In the morning of the great battle, Weezy, the sneaky assistant of Zoron -who has overheard the plan- sneaked to Harry's place and used his magic to alter the contents of the array of wisdom!. However Weezy's magic was not not enough to inflict lots of change on the array of wisdom. He was not able to change the order at all, but he was able to affect one number only, and change this number to zero.     

A mere 1 minute before the battle, Harry was shocked learn that Weezy altered his array!!. He needs to fix it and restore it to the correct state as soon as possible!

And now in the story, your turn comes. You, as a skilled java programmer can help Harry. You just have to write the correct code.

So, write a java method called helpHarry(int [] array) that takes the changed array and fixes it.

Be careful:

You may not change anything in the array but the affected cell.
Your code needs to be quick. Harry does not have any time left.
*/

void helpHarry(int [] array){
    long sumRealArray = (long)array.length * (array.length+1)/2;
    int sumAlteredArray = 0;
    int itemIndex = 0;
    for(int i=0;i<array.length;i++){
        sumAlteredArray += array[i];
        if(array[i] == 0)
            itemIndex = i;
    }
    array[itemIndex] = (int)(sumRealArray - sumAlteredArray);
}
