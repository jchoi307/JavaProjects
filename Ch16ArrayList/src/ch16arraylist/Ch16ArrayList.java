/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16arraylist;

/**
 *
 * @author Matt
 */
public class Ch16ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        My_ArrayList staff = new My_ArrayList();
        staff.addLast("Diana");
        staff.addLast("Harry");
        for (int i = 1; i <= 10; i++)
        {
            staff.addLast("Tom" + i);      
        }
        staff.add(0, "Juliet");
        staff.remove(1);
        for (int i = 0; i < staff.size(); i++)
        {
            System.out.println(staff.get(i));
        }
        System.out.println(staff.size());
        System.out.println(staff);
                */
        /*
        My_Stack testStack = new My_Stack();
        for(int i = 0; i < 12; i++){
            testStack.push(new String("test " + i));
        }
        System.out.println("pushed");
        while(!testStack.isEmpty()){
            System.out.println(testStack.pop());
        }
        testStack.push("test 42");
        testStack.push("test 43");
        System.out.println(testStack.peek());
        System.out.println(testStack.pop());
                */
        /*
        My_Queue testQ = new My_Queue();
        for(int i = 0; i < 10; i++){
            testQ.add(new String("test " + i));
        }
        while(!testQ.isEmpty()){
            System.out.println(testQ.remove());
        }
                */
        My_LinkedList testList = new My_LinkedList();
        for(int i = 0; i < 6; i++){
            testList.addFirst(new String("test #" + i));
        }
        //System.out.println(testList.getFirst());
        testList.addLast("x");
        //System.out.println(testList.getLast());
        testList.add(3, "fourth in list");
        My_ListIterator iter = testList.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("---reversed---");
        testList.reverse();
        My_ListIterator iter2 = testList.listIterator();
        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }
        System.out.println("----------");
        //testList.printListReverse();
        testList.revPrint();
        System.out.println(testList.sizeRec());
        
    }
}
