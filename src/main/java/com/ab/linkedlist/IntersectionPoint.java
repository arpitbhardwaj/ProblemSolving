package com.ab.linkedlist;

/**
 * @author Arpit Bhardwaj
 */
public class IntersectionPoint {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        Node head1 = null;
        head1 = customLinkedList.add(1,head1);
        head1 = customLinkedList.add(2,head1);
        head1 = customLinkedList.add(3,head1);
        head1 = customLinkedList.add(4,head1);
        head1 = customLinkedList.add(5,head1);
        head1 = customLinkedList.add(6,head1);

        Node head2 = null;
        head2 = customLinkedList.add(10,head2);
        head2 = customLinkedList.add(4,head2);
        head2 = customLinkedList.add(5,head2);
        head2 = customLinkedList.add(6,head2);

        CustomLinkedList.printLinkedList(head1);
        CustomLinkedList.printLinkedList(head2);

        Node intersectionNode = getIntersection(head1,head2);
        System.out.println("intersection Point is : "+ intersectionNode.data);
    }

    private static Node getIntersection(Node head1, Node head2) {
        int count1 = CustomLinkedList.getNodeCounts(head1);
        int count2 = CustomLinkedList.getNodeCounts(head2);
        int difference = 0;
        Node intersectionNode = null;
        if (count1 > count2){
            difference = count1 - count2;
            intersectionNode = getIntersectionUtil(difference,head1,head2);
        }
        else{
            difference = count2 - count1;
            intersectionNode = getIntersectionUtil(difference,head2,head1);
        }
        return intersectionNode;
    }

    private static Node getIntersectionUtil(int difference, Node largerHead, Node smallerHead) {
        Node largerCurrent = largerHead;
        Node smallerCurrent = smallerHead;

        for (int i = 0; i < difference; i++) {
            if (largerCurrent != null){
                largerCurrent = largerCurrent.next;
            }
        }

        while (largerCurrent != null
        && smallerCurrent != null){
            if (largerCurrent.data == smallerCurrent.data){
                return largerCurrent;
            }
            largerCurrent = largerCurrent.next;
            smallerCurrent = smallerCurrent.next;
        }
        return null;
    }
}
