//EmployeeProcessor.java
//Rahman:Jawadur:A00434830:u33
//Submission 09
//Processing Employees

/*
    This class is formated & documented and it functions properly.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class EmployeeProcessor
{
    private static Scanner inFile;
    private static List<Employee> employeeData = new ArrayList<>();

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
        readAndStoreData();
        displayData(args);
        inFile.close();
        Utils.pause();
    }

    /**
        Display the data in the order specifed by the Command line input.
    */
    private static void displayData(String[] args)
    {
        System.out.print("\nHere are the employees, ");
        if (args.length == 1)
        {
            System.out.println("in the order read in from the file:");
        }
        else
        {
            if (args[1].equals("bylastname"))
            {
                System.out.println("sorted by last name:");
                Collections.sort(employeeData);
            }

            if (args[1].equals("bygender"))
            {
                System.out.println("sorted by gender:");
                Comparator<Employee> compareBygender
                    = (e1, e2) -> e1.getGender() - e2.getGender();

                ;
                Collections.sort(employeeData, compareBygender
                                 .thenComparing(Comparator.naturalOrder()));
            }

            if (args[1].equals("byhiredate"))
            {
                System.out.println("sorted by hire date:");

                Collections.sort(employeeData,
                (e1, e2) -> e1.getHireDate() - e2.getHireDate());
            }

            if (args[1].equals("bysalary"))
            {
                System.out.println("sorted by salary:");

                Collections.sort(employeeData,
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
            }
        }
        for (Employee empData : employeeData)
        {
            System.out.println(empData);
        }

    }

    /**
        Read the Employee data from a file and store it in the ArrayList.
    */
    private static void readAndStoreData()
    {
        String[] temp;
        while (inFile.hasNextLine())
        {
            temp = inFile.nextLine().split(",");
            employeeData.add(new Employee(temp[0], temp[1].charAt(0),
            Integer.parseInt(temp[2]), Double.parseDouble(temp[3])));
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
            "Submission 09",
            "Processing Employees"
        );
        openingScreen.display();
        System.out.println();
    }

    /**
        A method which prints out the program information.
    */
    private static void displayProgramInfo()
    {
        TextItems textItems = new TextItems
        (
            EmployeeProcessor
            .class.getResourceAsStream("EmployeeProcessor.txt")
        );
        textItems.displayItem("ProgramDescription");
    }

    /**
        A method which: ensures that there are at most two command-line inputs,
        calls checkInputFile method, and checks that the requested processing
        command is understood. If there are any errors with the command Line
        input, a suitable message is displayed, followed by a pause, after
        which the program terminates.
    */
    private static void checkComdLineInput(String[] args)
    {
        if (args.length > 2)
        {
            System.out.println
            (
                "\nError:\nToo many command-line inputs.\n"
                + "Program now terminating."
            );
            Utils.pause();
            System.exit(0);
        }

        checkInputFile(args);

        if (args.length == 2)
        {
            if (!args[1].equals("bylastname") && !args[1].equals("bygender")
            && !args[1].equals("byhiredate") && !args[1].equals("bysalary"))
            {
                System.out.println
                (
                    "\nError:\nProcessing command not understood.\n"
                    + "Program now terminating."
                );
                Utils.pause();
                System.exit(0);
            }
        }
    }

    /**
        A method which ensures that the input file exists and can be opened
        for reading. If it does exist they are opened. If it does not exist,
        a suitable message will be displayed, followed by a pause, after
        which the program will terminate.
    */
    private static void checkInputFile(String[] args)
    {
        boolean inFileFound = false;
        try
        {
            inFile = new Scanner(new File(args[0]));
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println
            (
                "\nError:\nFile "
                + args[0] + " not found."
            );

            System.out.println("Program now terminating.");
            Utils.pause();
            System.exit(0);
        }
    }
}
