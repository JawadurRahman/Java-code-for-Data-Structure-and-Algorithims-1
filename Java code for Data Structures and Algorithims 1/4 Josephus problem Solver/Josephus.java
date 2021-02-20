//Josephus.java
//Rahman:Jawadur:A00434830:u33
//Submission 04
//Solving the Josephus Problem

/*
    The driver Class is formated & documented and it functions properly.
*/


/**
    The driver class for the Josephus problem.
*/
public class Josephus
{
    public static void main(String[] args)
    {

        if (args.length == 0)
        {
            //Display opening screen and program info
            displayOpeningScreen();
            displayProgramInfo();
            return;
        }

        int numOfZealots = Integer.parseInt(args[0]);
        int eliminationGap = Integer.parseInt(args[1]);
        ZealotCircle zealots = new ZealotCircle(numOfZealots, eliminationGap);
        if (args.length >= 3)
        {
            int seed = Integer.parseInt(args[2]);
            zealots = new ZealotCircle(numOfZealots, eliminationGap, seed);
        }

        zealots.createAndModifySequence();
        System.out.println
        (
            "\nHere is the full \"circle of zealots\","
            + " including our friend Joe:"
        );
        zealots.displayAllZealots();
        zealots.eliminateZealots();
        zealots.adviseJosephus();
        Utils.pause();
    }

    /**
        A method which prints out Identification information.
    */
    private static void displayOpeningScreen()
    {
        OpeningScreen openingScreen = new OpeningScreen
        (
            "Rahman:Jawadur:A00434830:u33",
            "Submission 04",
            "Solving the Josephus Problem"
        );
        openingScreen.display();
        System.out.println();
    }

    /**
        A method which prints out the program information
    */
    private static void displayProgramInfo()
    {
        TextItems textItems = new TextItems
        (
            Josephus.class.getResourceAsStream("Josephus.txt")
        );
        textItems.displayItem("ProgramDescription");
    }
}
