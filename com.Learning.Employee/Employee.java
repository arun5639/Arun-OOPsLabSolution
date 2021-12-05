//Employee Class

public class Employee {

    protected String fName;
    protected String lName;
    protected String deptName;
    protected String companyName = "abc";

    Employee(){
        this.fName = "";
        this.lName = "";
        this.deptName  = "";
    }

    Employee(String name1, String name2){
        this.fName = name1;
        this.lName = name2;
    }

    public void setDeptName(int deptNo){

        switch(deptNo){
            case 1:
                this.deptName = "technical";
                break;
            case 2:
                this.deptName = "admin";
                break;
            case 3:
                this.deptName = "humanresource";
                break;
            case 4:
                this.deptName = "legal";
                break;
        }
    }

    public String getFName(){
        return this.fName;
    }

    public String getLName(){
        return this.lName;
    }

    public String getDept(){
        return this.deptName;
    }  
}
