/*
Harry Escapes the Volcano 
Three weeks ago, no one imagined that you will be solving problems as hard as the ones you solved. And no one imagined that the great Zoron will be leaving the world for good. Yes! Harry has won. But it is not the time for celebrations yet! Remember? Harry had to come to the grate volcano in order to fight Zoron. And now, sensing the doom of his master, the great volcano erupts violently, and Harry needs to escape fast.

Starting at the top of the great volcano, Harry needs to go down the whole mountain to reach the safe ground. But Zoron's place is full of traps. In his way down, Harry must pass on these traps as he has no other choice (No! the eagles will not save the day Mr. Gandalf :D)  the traps are laid in rows from top to bottom, with each row having one more trap than the row preceding it, and each trap is marked with the amount of damage it gives as shown in the picture below. Harry can go down one row at a time and he can only move to an adjacent trap on the row below.

*** image.png ***


If you are given the trap map as a 2d array (where the first row contains 1 number, the second contains 2 numbers, the nth contains n numbers … and so on), write a java method that calculates the minimum amount of damage Harry must take in order for him to reach safety. For example, the minimum amount of damage in the picture above is 21 and can be achieved by moving along the highlighted traps. Note that you don't have to give Harry the traps or the map, you only need to tell him that the minimum amount of damage is 21, and he will take care of the rest. But be careful, If you tell him the correct number he will survive. Tell him the wrong info and Harry will be doomed!  

Notes:

All traps have positive damage value, no traps with 0 and no traps with negative damage.
The array you are given in a square array (n*n) that is zero padded. i.e. the first row has one number and the remaining cells in the row are filled with zeros
The trap on the top is located at arr[0][0], the two traps in the row below it at arr[1][0] , arr[1][1]. On the nth row at arr[n][0] ~~arr[n][n].
We do not care about the runtime of your solution in this question so you can feel free about that. 

For example:

Test	                        Input	                      Result
calculateMinDamage(arr);      image_above array:          21
                              1 0 0 0 0 
                              6 8 0 0 0 
                              4 2 3 0 0 
                              9 7 5 1 0 
                              14 12 9 8 10 

*/

public static long calculateMinDamage(int[][] arr) {
    return minWay(arr,0,0);
}
public static long minWay(int[][] arr,int n,int m){
    if(n==arr.length-1)
    return arr[n][m];
    if(minWay(arr,n+1,m)<=minWay(arr,n+1,m+1))
        return arr[n][m] + minWay(arr,n+1,m);
    else
        return arr[n][m] + minWay(arr,n+1,m+1);
}
