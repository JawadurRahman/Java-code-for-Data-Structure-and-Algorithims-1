//Employee.java
//Rahman:Jawadur:A00434830:u33
//Submission 09
//Processing Employees

/**
    This class is formated and funtions properly.
*/
public class Employee implements Comparable<Employee>
{
    private String name;    //First Last
    private char gender;    //M, F or O(Other)
    private int hireDate;   //yyyymmdd
    private double salary;  //dddddd.cc (up to)

    public Employee
    (
        String name,
        char gender,
        int hireDate,
        double salary
    )
    {
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public char getGender()
    {
        return gender;
    }

    public int getHireDate()
    {
        return hireDate;
    }

    public double getSalary()
    {
        return salary;
    }

    public String toString()
    {
        String formattedSalary = String.format("%9.2f", salary);
        String delimiter = "\\s";
        String[] nameArr = name.split(delimiter);
        return nameArr[1] + ", " + nameArr[0] + "\n  " + gender + "  Hired: "
               + hireDate + "  Salary: $" + formattedSalary;
    }

    public int compareTo(Employee other)
    {
        return this.name.split("\\s")[1].compareTo(other.name.split("\\s")[1]);
    }
}
