//SpellChecker.java
//Rahman:Jawadur:A00434830:u33
//Submission 05
//Implementing a Spell Checker with a ResizableArrayBag Class

/*
    This class is formated & documented and it functions properly.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
    This program is a very simple "spell checker". It compares each
    word in a given document against each word in a "dictionary" of words
    that are all spelled correctly. If it finds a word that is not spelled
    correctly, it reports the misspelled word and the line on which it occurs
    by displaying an appropriate one-line message on the standard output.
*/
public class SpellChecker
{

    private static Scanner dictionaryFile;
    private static Scanner documentFile;
    private static boolean misspellings = false;
    private static BagInterface<String> dictionaryBag
        = new ResizableArrayBag<>();

    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            //Display opening screen and program info
            displayOpeningScreen();
            displayProgramInfo();
            return;
        }

        checkComdLineInput(args);
        checkInputFiles(args);

        while (dictionaryFile.hasNext())
        {
            dictionaryBag.add(dictionaryFile.next());
        }

        System.out.println
        (
            "\nSpellchecking document " + args[1] + " with dictionary "
            + args[0]  + ":"
        );

        int lineNum = 1;
        while (documentFile.hasNextLine())
        {
            checkIfLineHasErrors(documentFile.nextLine(), lineNum);
            lineNum++;
        }

        if (!misspellings)
        {
            System.out.println("No misspellings were found.");
        }
        Utils.pause();
    }

    /**
        A method which checks a line for spelling errors and prints the errors
        out with their line number.
    */
    private static void checkIfLineHasErrors(String line, int lineNum)
    {
        line = line.trim().toLowerCase();

        int lineLength = line.length();
        for (int i = 0; i < lineLength; i++)
        {
            if (line.charAt(i) < 'a' || line.charAt(i) > 'z')
            {
                line = line.replace(line.charAt(i), ' ');
            }
        }

        line = line.trim();
        String delimiter = "\\s+";
        String[] words = line.split(delimiter);


        for (String item : words)
        {
            if (!dictionaryBag.contains(item) && !item.equals(""))
            {
                System.out.println
                (
                    item + " on Line " + lineNum + " is spelled"
                    + " incorrectly."
                );
                misspellings = true;
            }
        }
    }

    /**
        A method which prints out Identification information.
    */
    private static void displayOpeningScreen()
    {
        OpeningScreen openingScreen = new OpeningScreen
        (
            "Rahman:Jawadur:A00434830:u33",
            "Submission 05",
            "Implementing a Spell Checker with a ResizableArrayBag Class"
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
            SpellChecker.class.getResourceAsStream("SpellChecker.txt")
        );
        textItems.displayItem("ProgramDescription");
    }

    /**
        A method which ensures that there are only two command-line inputs.
        If this is not the case, a suitable message is displayed, followed
        by a pause, after which the program terminates.
    */
    private static void checkComdLineInput(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println
            (
                "\nError: Must be exactly two command-line inputs.\n"
                + "Program now terminating."
            );
            Utils.pause();
            System.exit(0);
        }
    }

    /**
        A method which ensures that the input files exist and can be opened
        for reading. If the do exist they are opened. If they do not exist,
        a suitable message will be displayed, followed by a pause, after
        which the program will terminate.
    */
    private static void checkInputFiles(String[] args)
    {
        boolean dictionaryFileFound = false;
        try
        {
            dictionaryFile = new Scanner(new File(args[0]));
            dictionaryFileFound = true;
            documentFile = new Scanner(new File(args[1]));
        }
        catch (FileNotFoundException fnf)
        {
            if (!dictionaryFileFound)
            {
                System.out.println
                (
                    "\nError opening dictionary file "
                    + args[0] + "."
                );
            }
            else
            {
                System.out.println
                (
                    "\nError opening document file "
                    + args[1] + "."
                );
            }

            System.out.println("Program now terminating.");
            Utils.pause();
            System.exit(0);
        }
    }
}
