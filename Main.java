import java.util.Scanner;
public class Main{
    static int[] inputCreditHours(int SubjectCount, int CreditPerSubject[]){
        Scanner y = new Scanner(System.in);
        for(int i = 0; i < SubjectCount; i++){
            System.out.print("Enter Subject " +(i+1) + " Credit Hours: ");
            CreditPerSubject[i] = y.nextInt();
        }
        return CreditPerSubject;
    }
    static int[] inputGradePS(int SubjectCount, int GradePerSubject[]){
        Scanner z = new Scanner(System.in);
        for(int i = 0; i < SubjectCount; i++){
            System.out.print("What grade did you get in Subject "+ (i+1) + "?: " );
            GradePerSubject[i] = z.nextInt();
        }
        return GradePerSubject;
    }
    static double GetGPA(int SubjectCount,int GradePerSubject[], int CreditPerSubject[], double SumOfCreditAndGrade,int CreditHourSum){
        for(int i = 0; i < SubjectCount; i++)
            CreditHourSum+=CreditPerSubject[i];
        for(int i = 0; i < SubjectCount; i++){
            if(GradePerSubject[i] >= 95 && GradePerSubject[i] <= 100)
                SumOfCreditAndGrade += CreditPerSubject[i] * 5;
            else if(GradePerSubject[i] >= 90 && GradePerSubject[i] <= 94)
                SumOfCreditAndGrade += CreditPerSubject[i] * 4.75;
            else if(GradePerSubject[i] >= 85 && GradePerSubject[i] <= 89)
                SumOfCreditAndGrade += CreditPerSubject[i] * 4.5;
            else if(GradePerSubject[i] >= 80 && GradePerSubject[i] <= 84)
                SumOfCreditAndGrade += CreditPerSubject[i] * 4;
            else if(GradePerSubject[i] >= 75 && GradePerSubject[i] <= 79)
                SumOfCreditAndGrade += CreditPerSubject[i] * 3.5;
            else if(GradePerSubject[i] >= 70 && GradePerSubject[i] <= 74)
                SumOfCreditAndGrade += CreditPerSubject[i] * 3;
            else if(GradePerSubject[i] >= 65 && GradePerSubject[i] <= 69)
                SumOfCreditAndGrade += CreditPerSubject[i] * 2.5;
            else if(GradePerSubject[i] >= 60 && GradePerSubject[i] <= 64)
                SumOfCreditAndGrade += CreditPerSubject[i] * 2;
            else
                SumOfCreditAndGrade += CreditPerSubject[i] * 1;
        }
        return SumOfCreditAndGrade / CreditHourSum;
    }
    public static void main(String[] args) {
        double GPA;
        int SubjectCount;
        int CreditHourSum=0;
        double SumOfCreditAndGrade = 0;
        Scanner x = new Scanner(System.in);
        System.out.print("How many Subjects do you have?: ");
        SubjectCount = x.nextInt();
        int[] CreditPerSubject = new int[SubjectCount];
        int[] GradePerSubject = new int[SubjectCount];
        inputCreditHours(SubjectCount,CreditPerSubject);
        inputGradePS(SubjectCount, GradePerSubject);
        GPA = GetGPA(SubjectCount, GradePerSubject, CreditPerSubject, SumOfCreditAndGrade, CreditHourSum);
        System.out.println("Your Final GPA is: "+ GPA + "/5.0");
        x.close();
    }
}