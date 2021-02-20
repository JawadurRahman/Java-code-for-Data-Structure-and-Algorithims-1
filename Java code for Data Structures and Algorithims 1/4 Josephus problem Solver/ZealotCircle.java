//ZealotCircle.java
//Rahman:Jawadur:A00434830:u33
//Submission 04
//Solving the Josephus Problem

/*
    Class is formated and documented, and it functions properly
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
    A class for creating a "circle of zealots" in which every nth zealot is
    eliminated until only one remains (and survives), and advising
    a particular member of that circle (Josepus, or "Joe") which position
    he should occupy to avoid elimination.
*/
public class ZealotCircle
{
    Node head;
    private int numberOfZealots;
    private int eliminationGap;
    private int seed;
    final String[] ZEALOT_NAMES =
    {
        "Ace", "Ada", "Ali", "Amy", "Ann", "Art", "Ava", "Bea", "Ben", "Bob",
        "Boz", "Cal", "Cam", "Dag", "Dan", "Deb", "Don", "Dot", "Eva", "Eve",
        "Fay", "Gil", "Guy", "Hal", "Ian", "Jan", "Jim", "Joe", "Kay", "Ken",
        "Kim", "Liz", "Mac", "Nan", "Ora", "Pam", "Red", "Rex", "Rik", "Rip",
        "Rob", "Rod", "Ron", "Roy", "Sam", "Tim", "Tom", "Uma", "Val", "Wes"
    };

    /**
        Creates an object of ZealotCircle
    */
    public ZealotCircle
    (
        int numberOfZealots,
        int eliminationGap
    )
    {
        this(numberOfZealots, eliminationGap, -1);
    }

    /**
        Creates an object of ZealotCircle with a seed
    */
    public ZealotCircle
    (
        int numberOfZealots,
        int eliminationGap,
        int seed
    )
    {
        this.numberOfZealots = numberOfZealots;
        this.eliminationGap = eliminationGap;
        this.seed = seed;
    }

    /**
        Advises Joe who to switch positions with, or to stay in his current 
        position.
    */
    public void adviseJosephus()
    {
        if (head.name != "Joe")
        {
            System.out.println
            (
                "Tell Joe he'd better exchange positions with " 
                + head.name + "."
            );
        }
        else
        {
            System.out.println("Tell our ol' buddy Joe to stay put.\n");
        }
    }

    /**
        Displays the names of all the Zealots currently alive in the circle, 
        Maximum of 15 names per line.
    */
    public void displayAllZealots()
    {
        System.out.print(head.name + " ");
        Node currentNode = head.next;
        int numLoops = 1;
        while (currentNode != head)
        {
            System.out.print(currentNode.name + " ");
            currentNode = currentNode.next;
            numLoops++;
            if (numLoops == 15)
            {
                System.out.println();
                numLoops = 0;
            }
        }
        if (numLoops != 0)
        {
            System.out.println();
        }
    }

    /**
        Eliminates all the Zealots one by one until there is only one Zealot
        left. Prints out the name of the victim when they are is eliminated.
    */
    public void eliminateZealots()
    {
        System.out.println
        (
            "\nThe elimination gap is " + eliminationGap
            + " and now we start the elimination:\n"
        );
        
        Node currentNode = head;
        int nextPersonNumber = 2;
        
        // In case the gap is 1, start pointer at tail 
        if (eliminationGap == 1)
        {
            while (currentNode.next != head)
            {
                currentNode = currentNode.next;
            }
        }

        while (numberOfZealots > 1 && eliminationGap > 0)
        {
            String nameOfLastEliminated = "";
            if (nextPersonNumber >= eliminationGap)
            {
                nameOfLastEliminated = currentNode.next.name;
                
                //if head has to be eliminated, changes the head
                if (currentNode.next == head)
                {
                    head = currentNode.next.next;
                }
                
                currentNode.next = currentNode.next.next;
                nextPersonNumber = 1;
                numberOfZealots--;

                System.out.println
                (
                    "The current victim is " + nameOfLastEliminated
                    + " and here are the remaining zealots:"
                );
                displayAllZealots();
                Utils.pause();
            }

            if (eliminationGap != 1)
            {
                currentNode = currentNode.next;
            }
            nextPersonNumber++;

        }
    }

    /**
        Creates the zealot Circle using nodes.   
    */
    public void createAndModifySequence()
    {
        
        ArrayList<String> shortNamesList
            = new ArrayList<>(Arrays.asList(ZEALOT_NAMES));
        boolean isJoeInBeginingOfList = false;
        Random rand = new Random(seed);
        while (!isJoeInBeginingOfList) 
        {
            if (seed > 0)
            {
                Collections.shuffle(shortNamesList, rand);
            }
            else
            {
                Collections.shuffle(shortNamesList);
            }
            for (int i = 0; i < numberOfZealots; i++)
            {
                if (shortNamesList.get(i).equals("Joe"))
                {
                    isJoeInBeginingOfList = true;
                    break;
                }
            }
        }

        Node firstNode;
        Node nextNode;
        firstNode = new Node();
        firstNode.name = shortNamesList.get(0);
        Node lastNode = firstNode;
        nextNode = firstNode;

        for (int i = 1 ; i <= numberOfZealots - 2; i++)
        {
            firstNode = new Node();
            firstNode.name = shortNamesList.get(i);
            firstNode.next = nextNode;
            nextNode = firstNode;
        }

        head = new Node();
        head.name = shortNamesList.get(numberOfZealots - 1);
        head.next = firstNode;

        //makes circular
        lastNode.next = head;
    }

    //A simple Node class containing String data for a name.
    private class Node
    {
        private String name;
        private Node next;

        public Node()
        {
            name = null;
            next = null;
        }

    }
}
