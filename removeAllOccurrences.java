
/*
Write a recursive java method named  removeAllOccurrences (Node<Integer> head, int item) that takes the head of a singly linked list and removes all occurrences of an item from that singly linked list. 
Your method should return a reference to the first node of the resulting list.

*/

public static Node<Integer> removeAllOccurrences (Node<Integer> head, int item){
    if(head == null) return null;

    if(head.getElement() == item) return removeAllOccurrences (head.getNext(), item);

    head.next= removeAllOccurrences (head.getNext(), item);
    return head;
}
