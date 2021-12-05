import java.util.Scanner;

public class ITSupportAdmin {
    static CredentialService cs = new CredentialService();
    static Employee emp = new Employee();    
    static Scanner sc = new Scanner(System.in);
    static String firstName;
    static String lastName;
    static int deptNum=0;
    static boolean isValid = false;

    public static void main(String [] args){
              
        getInput();
        emp = new Employee(firstName, lastName);
        emp.setDeptName(deptNum);
        cs.setEmail(emp);
        cs.setPwd();
        cs.showCredentials(emp);
    }

    public static void getInput(){
        
        System.out.println("Enter the Employee details -> ");
        System.out.println("Enter First Name ->");
        firstName = sc.next();
        sc.nextLine();
        System.out.println("Enter Last Name ->");
        lastName = sc.next();
        sc.nextLine();

        int iteration = 1;
        
        while((!isValid) && iteration <= 3){
            System.out.println("Enter Department No # ->");
            System.out.println("1. Technical");
            System.out.println("2. Admin");
            System.out.println("3. Human Resource");
            System.out.println("4. Legal");

            deptNum = sc.nextInt(); 
            iteration ++;
            isValid = validateDeptnum(deptNum);
            
            if (iteration > 3){
                System.out.println("Maximum Attempts reached - Function Terminated....");
                sc.close();
                System.exit(0);
            }
        }
    }

    public static boolean validateDeptnum(int deptNum){

        if (deptNum >= 1 && deptNum <=4){
            return true;
        }
        else{
            System.out.println("Invalid department Num !!..");
            return false;
        }
    }
}
