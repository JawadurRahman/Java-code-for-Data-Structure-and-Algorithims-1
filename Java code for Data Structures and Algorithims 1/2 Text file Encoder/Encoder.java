
//Encoder.java
//Rahman:Jawadur:A00434830:u33
//Submission 02
//Encoding Files of Plain Text

/*
    The program encodes files properly, it is well formatted and documented.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
    A class to encode files of plain text, one file per run,
    and write the encoded text out to an output textfile. The names
    of the input and output files are both read from the command line.
    The encoding scheme is described elsewhere.
*/
public class Encoder
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

        boolean inFileFound = false;
        try
        {
            inFile = new Scanner(new File(args[0]));
            inFileFound = true;
            outFile = new PrintWriter(new File(args[1]));
        }
        catch (FileNotFoundException fnf)
        {
            if (!inFileFound)
            {
                System.out.println
                (
                    "\nProblem opening input file "
                    + args[0] + "."
                );
            }
            else
            {
                System.out.println
                (
                    "\nProblem opening output file "
                    + args[1] + "."
                );
            }

            System.out.println("Program now terminating.\n");
            pause();
            System.exit(0);
        }


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
        outFile.close();
        inFile.close();
        System.out.println
        (
            "\nThe input file " + args[0] +  " has been encoded and"
            + " output to the file " + args[1] + ".\n"
        );


        pause();
    }

    /**
        A method which prints out Identification information.
    */
    private static void displayOpeningScreen()
    {
        System.out.println
        (
            "\n\n\n\n\n\n\n\n\n\n"
            + "\t\tRahman:Jawadur:A00434830:u33"
            + "\n\t\tSubmission 02\n\t\tEncoding Files of Plain Text"
            + "\n\n\n\n\n\n\n\n\n\n\n"
        );
        pause();
        System.out.println();
    }

    /**
        A method which prints out the program information
    */
    private static void displayProgramInfo()
    {
        System.out.println
        (
            "This program encodes a file of plain text and writes the encoded "
            + "text out to\nan output file.\n\n"
            + "The program takes two command-line parameters:\n\n"
            + "1. The first command-line parameter must be the name of the "
            + "input file, and\n   if the file is not in the current directory"
            + " it may include the path to the\n   file. This is the file "
            + "containing the plain text.\n"
            + "2. The second command-line parameter must be the name of the "
            + "output file, and\n   if the file is to be written to a location"
            + " other than the current directory,\n   it may include the path "
            + "to the file. This is the file that will contain the\n"
            + "   encoded text.\n\n"
            + "The program performs two error checks to make sure that both "
            + "the input file\nand the output file exist and can be opened for"
            + " reading (in the case of input)\nand writing (in the case of "
            + "output). If either check fails, a suitable message\nwill be "
            + "displayed, followed by a pause, after which the program will "
            + "terminate.\n\n"
            + "The program does no other error checking, so it is the user's "
            + "responsibility to\nmake sure that the above-listed parameters "
            + "are both present, correct, and given\nin the correct order. If "
            + "this is not the case, the program is not responsible\n"
            + "for what happens.\n\t\t\t\t\t\t\t\t  Screen 1 of 1"
        );
        pause();

    }

    /**
        A method to prompt the user and then pause waiting for the user to
        press the Enter key
    */
    private static void pause()
    {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Press Enter to continue ... ");
        kbd.nextLine();
    }

}
