// Codsoft Student grade calculator #Task 2
import java.util.*;
public class studentgrade
{
	public static void main(String[] args)
	{
		System.out.println("!..Welcome to Student Grade calculator..!");

		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the number of subjects: ");

		int numSubjects = scanner.nextInt();
		int[] marks= new int[numSubjects];
		int totalMarks = 0;

		for(int i=0; i<numSubjects; i++)
		{
			System.out.print("Enter the marks of subject "+(i+1)+": ");
			marks[i]=scanner.nextInt();
			totalMarks+=marks[i];
		}
		double percent=(double) totalMarks/(numSubjects*100)*100;
        
        System.out.println("\n");
		System.out.println("Result");
		System.out.println("Your Total marks: "+totalMarks);
		System.out.println("Average percentage: "+percent+"%");

		String grade = calculateGrade(percent);
		System.out.println("Grade: "+grade);
		scanner.close();
	}
	public static String calculateGrade(double percentage) {


		if(percentage>=90) {
			return "A+";
		}
		else if(percentage>=80) {
			return "B+";
		}
		else if(percentage>=70) {
			return "C+";
		}
		else if(percentage>=60) {
			return "D+";
		}
		else if(percentage>=50) {
			return "";
		}
		else {
			return "F";
		}
	}
}
