package com.Learning.CredentialService;

import java.security.SecureRandom;

import com.Learning.Employee.Employee;

//Credential Service class

public class CredentialService {
	
	private String email;
    private String pwd;

    public void setEmail(Employee a){
        this.generateEmail(a);
    }

    public void setPwd(){
        this.generatePwd(8);
    }

    public String getEmail(Employee a){
        return email;
    }

    public String getpwd(){
        return pwd;
    }
    
private void generatePwd(int len){
        
        final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        final String numbers = "0123456789";
        final String splChars = "~!@#$%^&*()_+";

        final String chars = upperCase + lowerCase + numbers + splChars;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        int randomIdx=0;

        for(int i=0; i< len; i++){
            if(i<4){
                switch(i){
                    case 0:
                        randomIdx = random.nextInt(upperCase.length());
                        sb.append(upperCase.charAt(randomIdx));
                        break;
                    case 1:
                        randomIdx = random.nextInt(lowerCase.length());
                        sb.append(lowerCase.charAt(randomIdx));
                        break;
                    case 2:
                        randomIdx = random.nextInt(numbers.length());
                        sb.append(numbers.charAt(randomIdx));
                        break;
                    case 3:
                        randomIdx = random.nextInt(splChars.length());
                        sb.append(splChars.charAt(randomIdx));
                        break;
                }
            }
            else{
                randomIdx = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIdx));
            }
        }

        this.pwd = sb.toString();
    }

    private void generateEmail(Employee a){
        this.email = a.getFName() + a.getLName() + "@" + a.getDept() + "." + a.getCompanyName() + ".com";
    }

    public void showCredentials(Employee a){
        System.out.println("Dear "+a.getFName()+", your generated credentials are as follows");
        System.out.println("Email       --->  "+email);
        System.out.println("Password    --->  "+pwd);
    }
}
