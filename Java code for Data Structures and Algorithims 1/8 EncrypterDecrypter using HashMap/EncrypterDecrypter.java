//EncrypterDecrypter.java
//Rahman:Jawadur:A00434830:u33
//Submission 08
//Encrypting and Decrypting Textfiles

/*
    This class is formated & documented and it functions properly.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;
import java.util.*;
import java.util.stream.Collectors;

public class EncrypterDecrypter
{
    private static Scanner inFile;
    private static PrintWriter outFile;

    private static HashMap<Character, Character> encodingMap
        = new HashMap<Character, Character>();
    private static HashMap<Character, Character> decodingMap
        = new HashMap<Character, Character>();
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
        createEncodingKey(args[3]);

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
        A method which encodes a file as per the encoding map.
    */
    private static void encodeFile(String[] args)
    {
        while (inFile.hasNextLine())
        {
            String line = inFile.nextLine();
            int pointer = 0;

            while (pointer < line.length())
            {
                char encodedLetter = encodingMap.get(line.charAt(pointer));
                outFile.print(encodedLetter);
                pointer += 1;
            }

            outFile.print("\n");
        }

        System.out.println
        (
            "\nThe file " + args[1] +  " has been encoded and"
            + " output to the file " + args[2] + ".\n"
        );
    }

    /**
        A method which decodes a file as per the decoding map.
    */
    private static void decodeFile(String[] args)
    {
        while (inFile.hasNextLine())
        {
            String line = inFile.nextLine();
            int pointer = 0;

            while (pointer < line.length())
            {
                char decodedLetter = decodingMap.get(line.charAt(pointer));
                outFile.print(decodedLetter);
                pointer += 1;
            }

            outFile.print("\n");
        }

        System.out.println
        (
            "\nThe file " + args[1] +  " has been decoded and"
            + " output to the file " + args[2] + ".\n"
        );
    }

    /**
        A method that uses the given phrase to create an Encoding Scheme
    */
    private static void createEncodingKey(String s)
    {

        List<String> cypherList = Arrays.asList(s.split(""))
                                  .stream()
                                  .distinct()//remove dublicate characters
                                  .sorted()//placed in Natural Order
                                  .sorted(Comparator.reverseOrder())//reversed
                                  .collect(Collectors.toList());

        //the remaining ASCII characters are added to the end of
        //cypherList, in their natural ASCII order.
        for (int i = 32; i < 127; i++)
        {
            if (!cypherList.contains(String.valueOf((char)i)))
            {
                cypherList.add(String.valueOf((char)i));
            }
        }

        //The now-complete list is reversed one final time.
        Collections.reverse(cypherList);

        String key = cypherList.stream()
                     .collect(Collectors.joining());

        //The key is put in encoding and decoding Maps
        for (int i = 32; i < 127; i++)
        {
            encodingMap.put((char)i, key.charAt(i - 32));
            decodingMap.put(key.charAt(i - 32), (char)i);
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
            "Submission 08",
            "Encrypting and Decrypting Textfiles"
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
            EncrypterDecrypter
            .class.getResourceAsStream("EncrypterDecrypter.txt")
        );
        textItems.displayItem("ProgramDescription");
    }

    /**
        A method which: ensures that there are exactly four command-line inputs,
        that the first input is either "e" or "d", calls checkInputOutputFiles
        method, and checks that the key phrase is at least 10 characters long.
        If there are any errors with the command Line input, a suitable message
        is displayed, followed by a pause, after which the program terminates.
    */
    private static void checkComdLineInput(String[] args)
    {
        if (args.length != 4)
        {
            System.out.println
            (
                "\nError: Incorrect number of parameters.\n"
                + "Program now terminating."
            );
            Utils.pause();
            System.exit(0);
        }

        if (!args[0].equals("e") && !args[0].equals("d"))
        {
            System.out.println
            (
                "\nError: Bad first parameter.\n"
                + "Program now terminating."
            );
            Utils.pause();
            System.exit(0);
        }

        checkInputOutputFiles(args);
        if (args[3].length() < 10)
        {
            System.out.println
            (
                "\nError: Key phrase must not be shorter than 10 characters.\n"
                + "Program now terminating."
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
                    "\nError: Cannot open "
                    + args[1] + " for input."
                );
            }
            else
            {
                System.out.println
                (
                    "\nError: Cannot open "
                    + args[2] + " for output."
                );
            }

            System.out.println("Program now terminating.");
            Utils.pause();
            System.exit(0);
        }
    }
}
