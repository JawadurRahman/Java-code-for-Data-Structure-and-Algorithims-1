
//EncoderDecoder.java
//Rahman:Jawadur:A00434830:u33
//Submission 03
//Encoding and Decoding Textfiles

/*
    The program works properly, and it is formatted and documented.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
    A class that can encode a plain-text file and write the encoded text
    out to an output textfile, or it can decode a previously-encoded
    file and write the plain text file to an output file. The names
    of the input and output files, and the decision on whether to
    encode or decode, are all read from the command line.  The encoding
    and decoding scheme is described elsewhere.
*/
public class EncoderDecoder
{
    private static Scanner inFile;
    private static PrintWriter outFile;
    public static final int CONSTANT = 123;

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
        checkInputOutputFiles(args);

        if (args[0].equals("e"))
        {
            encodeFile(args);
        }
        else
        {
            decodeFile(args);
        }

        outFile.close();
        inFile.close();
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
            "Submission 02",
            "Encoding and Decoding Textfiles"
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
            EncoderDecoder.class.getResourceAsStream("EncoderDecoder.txt")
        );
        textItems.displayItem("ProgramDescription");
    }

    /**
        A method which ensures that there are only three command-line inputs
        and that the first input is either "e" or "d". If this is not
        the case, a suitable message is displayed, followed by a pause,
        after which the program terminates.
    */
    private static void checkComdLineInput(String[] args)
    {
        if (args.length != 3)
        {
            System.out.println
            (
                "\nError: Exactly three command-line inputs required.\n"
                + "Program now terminating.\n"
            );
            Utils.pause();
            System.exit(0);
        }

        if (!args[0].equals("e") && !args[0].equals("d"))
        {
            System.out.println
            (
                "\nError: Bad first parameter (must be e or d).\n"
                + "Program now terminating.\n"
            );
            Utils.pause();
            System.exit(0);
        }
    }

    /**
        A method which ensures that both the input file and output file exist
        and can be opened for reading and writing. If the do exist they are
        opened. If they do not exist, a suitable message will be displayed,
        followed by a pause, after which the program will terminate.
    */
    private static void checkInputOutputFiles(String[] args)
    {
        boolean inFileFound = false;
        try
        {
            inFile = new Scanner(new File(args[1]));
            inFileFound = true;
            outFile = new PrintWriter(new File(args[2]));
        }
        catch (FileNotFoundException fnf)
        {
            if (!inFileFound)
            {
                System.out.println
                (
                    "\nProblem opening input file "
                    + args[1] + "."
                );
            }
            else
            {
                System.out.println
                (
                    "\nProblem opening output file "
                    + args[2] + "."
                );
            }

            System.out.println("Program now terminating.\n");
            Utils.pause();
            System.exit(0);
        }
    }

    /**
        A method which encodes a file as per the encoding scheme.
    */
    private static void encodeFile(String[] args)
    {
        int outCharCounter = 0;
        while (inFile.hasNextLine())
        {
            String line = inFile.nextLine();
            int pointer = 0;
            final int NEW_LINE_ENCODED = 433;

            while (pointer < line.length())
            {
                int encodedLetter = line.charAt(pointer) + CONSTANT;

                outFile.print(encodedLetter);
                outCharCounter += 3;
                if (outCharCounter == 60)
                {
                    outFile.print("\n");
                    outCharCounter = 0;
                }

                pointer += 1;
            }

            outFile.print(NEW_LINE_ENCODED);
            outCharCounter += 3;

            if (outCharCounter == 60)
            {
                outFile.print("\n");
                outCharCounter = 0;
            }
        }

        System.out.println
        (
            "\nThe input file " + args[1] +  " has been encoded and"
            + " output to the file " + args[2] + ".\n"
        );
    }

    /**
        A method which decodes a file as per the decoding scheme.
    */
    private static void decodeFile(String[] args)
    {
        while (inFile.hasNext())
        {
            String encLine = inFile.next();
            int lineLength = encLine.length();
            int pointer = 3;
            final int NEW_LINE_ENCODED = 433;

            while (pointer <= encLine.length())
            {
                int num =
                    Integer.parseInt(encLine.substring(pointer - 3, pointer));

                if (num == NEW_LINE_ENCODED)
                {
                    outFile.print("\n");
                }
                else
                {
                    char c = (char)(num - CONSTANT);
                    outFile.print(c);

                }
                pointer += 3;
            }
        }

        System.out.println
        (
            "\nThe input file " + args[1] +  " has been decoded and"
            + " output to the file " + args[2] + ".\n"
        );
    }
}
