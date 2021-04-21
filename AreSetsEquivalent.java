/*

Given two Arrays A and B of n integers each, possibly containing duplicates. 
Write a Java method for an efficient in-place algorithm for determining if A and B contain the same set of elements. 
(set here means the mathematical notion of a set, so, all duplicates of an element are represented as one)


For example:

Test	                            Input	                        Result
AreSetsEquivalent(arr, brr)       [1, 5, 1, 4]                  case #1: true
                                  [1, 5, 4, 5, 4, 1]

AreSetsEquivalent(arr, brr)       [1, 10, 3, 5, 8, 8]           case #2: false
                                  [1, 7, 8, 3, 5, 7]


*/

public static boolean AreSetsEquivalent(int [] arr, int[] brr){
    Arrays.sort(arr);
    Arrays.sort(brr);
    if(arr[0] != brr[0])
        return false;
    int i =1,j=1;
    while (i<arr.length&&j<brr.length){
        if(arr[i] == brr[j]){
            i++;
            j++;
        }
        else if(arr[i] < brr[j]){
            if(i==arr.length-1 || brr[j-1] < arr[i])
                return false;
            i++;
        }
        else if(arr[i] > brr[j]){
            if(j==brr.length-1 || arr[i-1] < brr[j])
                return false;
            j++;
        }
    }
    return  true;
}
