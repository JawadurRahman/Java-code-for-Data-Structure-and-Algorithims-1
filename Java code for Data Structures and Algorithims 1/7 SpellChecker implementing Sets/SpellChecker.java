//SpellChecker.java
//Rahman:Jawadur:A00434830:u33
//Submission 07
//Implementing a Spell Checker with with Three Java Sets

/*
    This class is formated & documented and it functions properly.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Collections;

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
    private static HashSet<String> dictionarySet
        = new HashSet<String>();
    private static HashSet<Holder> documentSet
        = new HashSet<Holder>();
    private static int documentSize = 0;
    private static HashSet<Holder> misspellingsSet
        = new HashSet<Holder>();

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

        //add words to dictionarySet
        while (dictionaryFile.hasNext())
        {
            dictionarySet.add(dictionaryFile.next());
        }

        System.out.println
        (
            "\nDocument " + args[1] + " spell-checked with dictionary "
            + args[0]  + ".\n"
        );

        int lineNum = 1;
        while (documentFile.hasNextLine())
        {
            addWordsToDocumentSet(documentFile.nextLine(), lineNum);
            lineNum++;
        }

        //add words to misspellingsSet
        Iterator<Holder> docIter = documentSet.iterator();
        while (docIter.hasNext())
        {
            Holder temp = docIter.next();
            if (!dictionarySet.contains(temp.word))
            {
                misspellingsSet.add(temp);
                misspellings = true;
            }
        }

        int misspellingsSetSize = misspellingsSet.size();
        System.out.println
        (
            "Number of words in dictionary " + args[0] + ": "
            + dictionarySet.size()
        );
        System.out.println
        (
            "Number of words in document " + args[1] + ": "
            + documentSize
        );
        System.out.println
        (
            "Number of misspelled words in document " + args[1] + ": "
            + misspellingsSetSize
        );

        if (!misspellings)
        {
            System.out.println
            (
                "\nNo misspellings were found in "
                + args[1]  + "."
            );
        }
        else
        {
            System.out.println("\nHere is a list of all misspelled words:");

            while (!misspellingsSet.isEmpty())
            {
                System.out.println(Collections.min(misspellingsSet));
                misspellingsSet.remove(Collections.min(misspellingsSet));
            }
        }

        System.out.println();
    }

    /**
        A simple nested class containing a word and a line number.
    */
    private static class Holder implements Comparable<Holder>
    {

        private int lineNum;
        private String word;

        public Holder(int lineNum, String word)
        {
            this.lineNum = lineNum;
            this.word = word;
        }

        public String toString()
        {
            return word + " on line number " + lineNum;
        }

        //To sort by line number
        public int compareTo(Holder other)
        {
            return lineNum - other.lineNum;
        }
    }

    /**
        A method which checks a line for spelling errors and prints the errors
        out with their line number.
    */
    private static void addWordsToDocumentSet(String line, int lineNum)
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
            if (!item.equals(""))
            {
                Holder wordAndLine = new Holder(lineNum, item);

                //add words to documentSet
                documentSet.add(wordAndLine);
                documentSize++;
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
            "Submission 07",
            "Implementing a Spell Checker with with Three Java Sets"
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
