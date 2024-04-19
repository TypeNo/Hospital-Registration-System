import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testing2ver2 {   
    public static void main(String[] args){
        //Scanner
        Scanner input = new Scanner(System.in);

        //Entity Declaration
        Vector<Patient> patients = new Vector<>();                              //Patient
        Vector<Doctor> doctors = new Vector<>();                                //Doctor
        Administrator admin = new Administrator(null, null);        //Admin

        boolean operationLoop = true;                                           //System Operation Looping Flag
        while(operationLoop){                                                   
            int Choice1=0;                                                      //First Layered Interface choice 
            boolean InputCorrect1 =false;                                       //Mismatch Input Flag Initialization
            while(!InputCorrect1){                                              //Input Retry Looping for InputMismatchException
                try{                                                            //InputMismatchExecption Try and Catch
                    mainMenu();                                                 //Main Menu 

                    Choice1=input.nextInt();
                    InputCorrect1=true;                                         //Deactivate Input Retry Looping Flag
                }catch(InputMismatchException ex){
                    input.nextLine();
                }
            }
            InputCorrect1=false;                                                //Mismatch Input Flag Initialization
            boolean LoopFlag=true;                                              //Section Looping Flag
            int Choice2=0;
            boolean Terminate=false;                                            //Second Layered Interface choice for Register Interface
            switch (Choice1){                                                   //Switch case for Choice1 - Option: 1.) Register 2.) Login 3.) Exit
                case 1:                                                         //if Choice1 is first choice - Register
                    boolean RegistrationLoop = true;                            //Registration Section Looping Flag
                    while(RegistrationLoop){
                        while(!InputCorrect1){                                  //Input Retry Looping for InputMismatchException
                            try{                                                //Try and Catch 
                                registerMenu();                                 //Register Menu
                                Choice2 = input.nextInt();
                                InputCorrect1=true;
                                input.nextLine();
                            }catch(InputMismatchException ex){
                                input.nextLine();

                            }
                        }
                        switch(Choice2){                                        //Switch csse for Choice2   - Option: 1.) Patient 2.) Doctor 3.) Administrator 4.) Return                                    
                            case 1:                                             //if Choice2 is first choice - Patient
                                String PaAccName=null;
                                //Patient Registration Start--------------------------------------------------
                                System.out.println("\n=========================================");  
                                System.out.println("Patient register page");  
                                System.out.println("=========================================");    
                                System.out.println("Enter your account name:");
                                PaAccName = input.nextLine();
                                if(!patients.isEmpty()){                                                                                //if there is none of patients
                                    while(LoopFlag){                                                                                    //Section Looping
                                        for(int i=0;i<patients.size();i++){                                                             //Looping through patient vector
                                            if(patients.get(i).getAccName().equals(PaAccName)){                                         //Error Display if acc registered exists
                                                //Error Message Displaying--------------------------------------------------           
                                                System.out.println("\n=========================================");
                                                System.out.println("The account has existed.Please register a new account");
                                                System.out.println("Click 1 to exit the page or click any button if want to retry");
                                                if (input.nextLine().equals("1")) {
                                                    Terminate = true;   //Set Terminate to true to exit to the main menu
                                                    LoopFlag = false;  // Set LoopFlag to false to exit the outer while loop
                                                    break;
                                                }

                                                System.out.println("\n=========================================");
                                                System.out.println("Enter your account name:");
                                                System.out.println("=========================================");
                                //---------------------------------------------------------------------------
                                                PaAccName = input.nextLine();
                                                LoopFlag=true;                                                                                                         
                                                break;
                                            }
                                            LoopFlag=false;                                                                            //Deactivate Section Looping Flag

                                        }
                                    }

                                }
                                if(Terminate){
                                    break;
                                }
                                System.out.println("Enter your password:");
                                String PaPwd = input.nextLine();
                                System.out.println("Enter your name:");
                                String PaName = input.nextLine();

                                admin.addPatient(patients,new Patient(PaAccName, PaPwd, PaName));                                      //Add new patient into patient vector
                                System.out.println("\nPatient registered successfully!\n");
                                break;
                                //Patient Registration End 
                            case 2:                                                                                                    //if choice2 is second choice - Doctor
                               //Doctor Registration--------------------------------------------------
                                System.out.println("\n=========================================");
                                System.out.println("Doctor register page"); 
                                System.out.println("=========================================");
                                System.out.println("Enter your account name:");
                                String DrAccName = input.nextLine();
                                if(!doctors.isEmpty()){                                                                               //if there is none of doctor
                                    while(LoopFlag){                                                                                  //Section Looping
                                        for(int i=0;i<doctors.size();i++){                                                            //Looping through doctor vector
                                            if(doctors.get(i).getAccName().equals(DrAccName)){                                        //Error Display if acc registered exists
                                                //Error Message Displaying--------------------------------------------------
                                                System.out.println("\n=========================================");
                                                System.out.println("The account has existed.Please register a new account");
                                                System.out.println("Click 1 to exit the page or click any button if want to retry");
                                                if (input.nextLine().equals("1")) {
                                                    Terminate = true;   //Set Terminate to true to exit to the main menu
                                                    LoopFlag = false;  // Set LoopFlag to false to exit the outer while loop
                                                    break;
                                                }
                                                System.out.println("\n=========================================");
                                                System.out.println("Enter your account name:");
                                                System.out.println("=========================================");
                                                //Error Message Displaying--------------------------------------------------
                                                DrAccName = input.nextLine();
                                                LoopFlag=true;
                                                break;
                                            }
                                            LoopFlag=false;                                                                            //Deactivate Section Looping Flag

                                        }
                                    }

                                }
                                if(Terminate==true){
                                    break;
                                }
                                System.out.println("Enter your password:");
                                String DrPwd = input.nextLine();
                                System.out.println("Enter your name:");
                                String DrName = input.nextLine();
                                System.out.println("Enter your speciality:");
                                String speciality = input.nextLine();

                                admin.addDoctor(doctors,new Doctor(DrAccName, DrPwd, DrName, speciality));                         //Add new doctor to doctor vector
                                System.out.println("\nDoctor registered successfully!\n");
                                //Doctor Registration End---------------------------------------------------------------------------

                                break;
                            case 3:                                                                                                   //if choice2 is third choice - Administrator
                                //Admin Registration Start--------------------------------------------------    
                                if(admin.getAccName()!=null){                                                                         //Error Display if a admin has existed
                                    //Error Message Displaying-------------------------------------------------
                                    System.out.println("\n=========================================");
                                    System.out.println("There 's only one administrator for the system. Extra registration is not allowed");
                                    //Error Message Displaying-------------------------------------------------
                                    break;
                                }
                                System.out.println("\n=========================================");
                                System.out.println("Administrator register page"); 
                                System.out.println("=========================================");
                                
                                System.out.println("Enter your account name:");
                                String AdAccName = input.nextLine();
                                System.out.println("Enter your password:");
                                String AdPwd = input.nextLine();

                                admin.setAccName(AdAccName);
                                admin.setPwd(AdPwd);                        
                                System.out.println("\nAdministrator registered successfully!\n");
                                //Admin Registration End------------------------------------------------
                                break;  
                            case 4:                                                                                                   //if choice2 is fouth choice - Return
                                RegistrationLoop = false;
                        }             
                        break;    
                    }
                    break;    
                case 2:                                                                                                               //if Choice1 is second choice - Login 
                    InputCorrect1=false;                                                                                              //Mismatch Input Flag intiialization
                    int Choice3=0;                                                                                                    //Third Layered Interface choice for Login Interface
                    while(!InputCorrect1){                                                                                            //Input Retry Looping for Input
                        try{                                                                                                          //InputMismatchException Try and Catch
                            loginMenu();                                                                                              //Login Menu
                            Choice3 = input.nextInt();
                            input.nextLine();
                            InputCorrect1=true;                                                                                       //Deactivate Input Retry Looping Flag
                        }catch(InputMismatchException ex){
                            input.nextLine();
                        }
                    }
                    boolean LoginLoop = true;                                                                                         //Login Looping Flag Initialization
                    while(LoginLoop){                                                                                                 //Login Looping
                        switch(Choice3){                                                                                              //Switch case for Choice3
                            case 1:                                                                                                   //if Choice3 is first choice - Patient
                                //Patient Login Start------------------------------------------------
                                System.out.println("Enter your account name: ");
                                String PaAccName = input.nextLine();
                                System.out.println("Enter your password: ");
                                String PaPwd = input.nextLine();

                                boolean PaAccNameMatch = false;                                                                       //Error Flag for Account Name Not Matching
                                boolean PaPasswordMatch = false;                                                                      //Error Flag for Password Not Matching
                                int PaIndex = -1;             
                                while ((!PaPasswordMatch || !PaAccNameMatch)&&!Terminate) {                                                         //Password or Account Mismatch Looping
                                    for (int i = 0; i < patients.size(); i++) {                                                       //Looping through Patient vector
                                        if (PaPwd.equals(patients.get(i).getpwd())){                                                  //If Password is matched
                                            PaIndex = i;                                                                              //Initalize to the index where password is matched
                                            if(PaAccName.equals(patients.get(PaIndex).getAccName())){                                 //If Account is matched also
                                                PaAccNameMatch = true;                                                                //Deactivate Error Flag
                                                PaPasswordMatch = true; 
                                                break; 
                                            }                                            
                                        }
                                    }
                                    if (!PaPasswordMatch || !PaAccNameMatch) {                                                        //If there is none of account matched
                                        //Error Message Displaying--------------------------------------------------           
                                        System.out.println("Invalid input!");
                                        System.out.println("Click 1 to exit the page or click any button if want to retry");
                                        if (input.nextLine().equals("1")) {
                                            Terminate = true;
                                            break;
                                        }
                                        
                                        //Error Message Displaying--------------------------------------------------           
                                        //Procedure Repeat----------------------------------------------------------               
                                        System.out.println("Enter your account name: ");
                                        PaAccName = input.nextLine();
                                        System.out.println("Enter your password: ");
                                        PaPwd = input.nextLine();
                                        //Procedure Repeat----------------------------------------------------------               
                                    }                                  
                                }
                                if(Terminate){
                                    LoginLoop=false;
                                    break;
                                }  
                                Boolean PatientOperation = true;                                                                    //Patient Session Termination Flag Initialization
                                //Patient Info Printing------------------------------------------------------------
                                System.out.println(patients.get(PaIndex).toString());
                                //Patient Info Printing------------------------------------------------------------
                                System.out.println("Press 1 to return");    
                                while(PatientOperation){                                                                           //Patient Session Looping
                                    InputCorrect1=false;                                                                           //Mismatch Input Flag Initialization
                                    int back=0;                                                                                    //Back value   
                                    while(InputCorrect1==false){                                                                   //Input Retry Looping for Input
                                        try{                                                                                       //InputMismatchException Try and Catch
                                            back = input.nextInt();                                                                
                                            input.nextLine();                                                                       
                                            InputCorrect1=true;
                                            
                                        }catch(InputMismatchException ex){
                                            input.nextLine();
                                        }
                                    }
                                    if(back == 1){                                                                                 //if back value=1
                                        LoginLoop = false;                                                                         //Terminate Patient Operation & Login Session 
                                        PatientOperation=false;    
                                    }                              
                                }
                                //Patient Login End------------------------------------------------
                                break;  
                            case 2:
                                //Doctor Login Start------------------------------------------------
                                System.out.println("Enter your account name: ");
                                String DrAccName = input.nextLine();
                                System.out.println("Enter your password: ");
                                String DrPwd = input.nextLine();

                                boolean DrAccNameMatch = false;                                                                   //Error Flag for Account Name Not Matching
                                boolean DrPasswordMatch = false;                                                                  //Error Flag for Password Not Matching
                                int DrIndex = -1;                                                                                 //Index for Vector Element that has matched password
                                while (!DrAccNameMatch || !DrPasswordMatch) {                                                     //Password or Account Mismatch Looping
                                    for (int i = 0; i < doctors.size(); i++) {                                                    //Looping through Doctor vector
                                        if (DrPwd.equals(doctors.get(i).getpwd())){                                               //If Password is matched
                                            DrIndex = i;                                                                          //Initalize to the index where password is matched
                                            if(DrAccName.equals(doctors.get(DrIndex).getAccName())){                              //If Account is matched also
                                                DrAccNameMatch = true;                                                            //Deactivate Error Flag
                                                DrPasswordMatch = true; 
                                                break; 
                                            }                                            
                                        }
                                    }
                                    if (!DrAccNameMatch || !DrPasswordMatch) {                                                    //If there is none of account matched
                                        System.out.println("Invalid input!");
                                        System.out.println("Click 1 to exit the page or click any button if want to retry");
                                        if (input.nextLine().equals("1")) {
                                            Terminate = true;
                                            break;
                                        }
                                        System.out.println("Enter your account name: ");
                                        DrAccName = input.nextLine();
                                        System.out.println("Enter your password: ");
                                        DrPwd = input.nextLine();
                                    }                                  
                                }
                                if(Terminate){
                                    LoginLoop=false;
                                    break;
                                }  
                                Boolean DoctorOperation = true;                                                                 //Doctor Session Termination Flag Initialization
                                System.out.println(doctors.get(DrIndex).toString());                                     
                                System.out.println("Press 1 to return");
                                while(DoctorOperation){                                                                         //Doctor Session Looping
                                    InputCorrect1=false;                                                                        //Mismatch Input Flag Initialization
                                    int back=0;                                                                                 //Back value  
                                    while(InputCorrect1==false){                                                                //Input Retry Looping for Input
                                        try{                                                                                    //InputMismatchException Try and Catch
                                            back=input.nextInt();
                                            input.nextLine();
                                            InputCorrect1=true;

                                        }catch(InputMismatchException ex){
                                            input.nextLine();
                                        }
                                    }
                                   
                                    if(back == 1){                                                                              //if back value=1
                                        LoginLoop = false;                                                                      //Terminate Doctor Operation & Login Session 
                                        DoctorOperation=false;
                                    }
                                }
                                break; 
                            case 3:
                                //Adminstrator Login Start------------------------------------------------
                                System.out.println("Enter your account name: ");
                                String AdAccName = input.nextLine();
                                System.out.println("Enter your password: ");
                                String AdPwd = input.nextLine();

                                boolean AdAccNameMatch = false;                                                                //Error Flag for Account Name Not Matching 
                                boolean AdPasswordMatch = false;                                                               //Error Flag for Password Not Matching
                                
                                while (!AdPasswordMatch || !AdAccNameMatch) {                                                  //Password or Account Mismatch Looping
                                    if (AdPwd.equals(admin.getpwd())){                                                         //If Password is matched
                                        if(AdAccName.equals(admin.getAccName())){                                              //If Account is matched also
                                            AdAccNameMatch = true;                                                             //Deactivate Error Flag
                                            AdPasswordMatch = true; 
                                            break; 
                                        }                                            
                                    }                                                                               
                                    if (!AdPasswordMatch || !AdAccNameMatch) {                                                 //If there is none of account matched
                                        //Error Message Displaying--------------------------------------------------  
                                        System.out.println("Invalid input!");
                                        System.out.println("Click 1 to exit the page or click any button if want to retry");
                                        if (input.nextLine().equals("1")) {
                                            Terminate = true;
                                            break;
                                        }
                                        
                                        //Error Message Displaying--------------------------------------------------  
                                        //Procedure Repeat----------------------------------------------------------
                                        System.out.println("Enter your account name: ");
                                        AdAccName = input.nextLine();
                                        System.out.println("Enter your password: ");
                                        AdPwd = input.nextLine();
                                        //Procedure Repeat---------------------------------------------------------- 
                                    }
                                }
                                if(Terminate){
                                    LoginLoop=false;
                                    break;
                                }  
                                Boolean AdminOperation = true;                                                                    //Adminstrator Session Termination Flag Initialization
                                while(AdminOperation){                                                                            //Adminstrator Session Looping
                                    Boolean inputCorrect = false;                                                                 //Mismatch Input Flag Initialization
                                    int Choice4 = 0;                                                                              //Third Layered Interface chocie for Adminstrator Control Panel Interface
                                    while(!inputCorrect){                                                                         //Input Retry Looping for InputMismatchException
                                        try{                                                                                      //InputMismatchException Try and Catch
                                            AdminMenu();                                                                          //Admin Main Menu
                                            Choice4 = input.nextInt();              
                                            inputCorrect = true;                                                                  //Deactivate Input Retry Looping Flag                          
                                            input.nextLine();
                                        }catch(InputMismatchException ex){
                                            input.nextLine();
                                        }   
                                    }                          
                                    switch(Choice4){                                                                              //Switch case for Choice4 - Option: 1.) Display all user info 2.) Manage doctor and patient

                                        case 1:                                                                                   //if Choice4 is first choice - Display all user info
                                            admin.Display(doctors,patients);                                                      //Displaying all user info
                                            break;
                                        case 2:                                                                                   //If Choice4 is second choice - Mnaage doctor and patient
                                          if(patients.isEmpty()||doctors.isEmpty()){
                                            System.out.println("There is none of patients or doctors or both in the system.Hence there 's no need to manage them"); //Message to avoid the admistrator to get access 
                                            break;                                                                                                                    //to this management functionality to avoid
                                          }                                                                                                                           //unnecessary problems
                                          else{                                       
                                            Scanner input2 = new Scanner(System.in);
                                            admin.Manage(input2, patients, doctors);                                              //Patient and Doctor Management
                                            break;
                                          }
                                        case 3:
                                            AdminOperation = false;                                                               //Terminate Adminstrator Operation & Login Session
                                            LoginLoop = false;
                                            break;
                                    }  
                                }
                                break;
                            case 4:
                                LoginLoop = false;                                                                                //Terminate Login Session
                        }
                    }
                break;  
                case 3:
                    operationLoop = false;                                  
            }   
        }
    input.close();
}
       
    public static void mainMenu(){
        System.out.println("=========================================");
        System.out.println("Hospital Registration System"); 
        System.out.println("=========================================");
        
        System.out.println("Choose an operation: \n");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit\n");
    }

    public static void registerMenu(){
        System.out.println("\n=========================================");
        System.out.println("Registration Page"); 
        System.out.println("=========================================");
        System.out.println("Choose your identity: \n");
        System.out.println("1. Patient");
        System.out.println("2. Doctor");
        System.out.println("3. Administrator");
        System.out.println("4. Return\n");
    }

    public static void loginMenu(){
        System.out.println("\n=========================================");
        System.out.println("Login Page"); 
        System.out.println("=========================================");       
        System.out.println("Choose your identity: \n");
        System.out.println("1. Patient");
        System.out.println("2. Doctor");
        System.out.println("3. Administrator");
        System.out.println("4. Return\n");
    }
    public static void PatientMenu(){
        System.out.println("\n=========================================");
        System.out.println("Patient information page"); 
        System.out.println("=========================================");
    }

    public static void AdminMenu(){
        System.out.println("\n=========================================");
        System.out.println("Administrator operation page"); 
        System.out.println("=========================================");
        System.out.println("Choose an operation to perform\n");
        System.out.println("1. Display all user info");
        System.out.println("2. Manage doctor and patient");
        System.out.println("3. Return\n");
    }
}


