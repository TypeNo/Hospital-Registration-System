import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator extends Person{//Inherits from PersonS
    public Administrator(String AccName, String pwd){ // adminstrator's constructor with AccName and pwd as parameter
        super(AccName, pwd);//set parameters to parent's constructor using "super"
    }

    public void setAccName(String AccName){
        super.AccName = AccName;//setter of account name to the parent class's accName 
    }

    public void setPwd(String pwd){
        super.pwd = pwd;//setter of password to the parent class's pwd
    }

    public void addPatient(Vector<Patient>patients , Patient patient){
        patients.add(patient);//add the patient to the vector patients
    }

    public void addDoctor(Vector<Doctor>doctors,Doctor doctor){
        doctors.add(doctor);//add tbe doctor to the vector doctors
    }
    
    public void DisplayPatient(int i, Vector<Patient>patients){ //display the patient information with the index i from the patients vector
        System.out.println("\n-----------------------------------------");
        System.out.println("Display Patient Info." );
        System.out.println("-----------------------------------------");
        System.out.print("Patient No." + (i+1)); 
        System.out.print(patients.get(i).toString()); // toString function that will return patient information in String type
    }

    public void DisplayDoctor(int i, Vector<Doctor>doctors){ //display the doctor information with the index i from the doctors vector
        System.out.println("-----------------------------------------");
        System.out.println("Display Doctor Info." );
        System.out.println("-----------------------------------------");
        System.out.println("Doctor No." + (i+1));
        System.out.print(doctors.get(i).toString()); //toString function that will return doctor information in String type
    }

    public void Display(Vector<Doctor> doctors, Vector<Patient>patients){ //Overwrite the display function to display all doctors and patients information from their vector 
        System.out.println("\n-----------------------------------------");
        System.out.println("Display Patient Info." );
        System.out.println("-----------------------------------------");
        for(int i = 0; i<patients.size(); i++){ // use for loop to display all the patient information
            System.out.print("Patient No." + (i+1));
            System.out.print(patients.get(i).toString()+ "\n");
        }
        System.out.println("-----------------------------------------");
        System.out.println("Display Doctor Info." );
        System.out.println("-----------------------------------------");
        for(int i = 0; i<doctors.size(); i++){ //use for loop to display all the doctor information
            System.out.println("Doctor No." + (i+1));
            System.out.print(doctors.get(i).toString()+ "\n");
        }
    }

    public void Manage(Scanner input, Vector<Patient> p, Vector<Doctor> d){//function to add doctor to patient/remove patient from doctor
        System.out.println("Enter [add]/[remove] to assign/remove");
        String choice = input.nextLine();
        if(choice.equals("add")){//if user enter "add"
            boolean CorrectSize = false;//set a boolean to ensure the index entered by the user is valid(index<vector size)
          
            while(!CorrectSize){
                System.out.println("\n-----------------------------------------");
                System.out.println("Doctor List" );
                System.out.println("-----------------------------------------");
                for(int i = 0; i<d.size(); i++){//use for loop to display the doctor list for the user to refer
                    System.out.print("Doctor No." + (i+1) + ": ");
                    System.out.println(d.get(i).getName());
                }
                boolean inputCorrect = false;//set a boolean to ensuring correct input type
                int D = 0;
                while(!inputCorrect){//while input type = false
                    try{//exception handling
                        System.out.println("\nEnter doctor No. to assign a doctor");                    
                        D = input.nextInt();//select a doctor
                        inputCorrect = true;//set the inputCorrect to true to quit the loop
                        input.nextLine();
                    }catch(InputMismatchException ex){//catch the InputMismatchException exception
                        input.nextLine();//clear the entered value to avoid infinite loop
                    }
                    if(D>d.size() || D<0){//error message is printed out if the entered index number>doctor vector size
                        System.out.println("Invalid doctor no. !");
                        inputCorrect = false;//set the boolean to false to remain in the while loop

                    } 
                }

                System.out.println("\n-----------------------------------------");
                System.out.println("Patient List" );
                System.out.println("-----------------------------------------");
                for(int i = 0; i<p.size(); i++){//use for loop to display the patient list for the user to refer
                    System.out.print("Patient No." + (i+1) + ": ");
                    System.out.println(p.get(i).getName());
                }
                boolean inputCorrect1 = false;//set a boolean value to ensuring the correct input type
                int P = 0;
                while(!inputCorrect1){//while input type = false
                    try{//exception handling
                        System.out.println("\nEnter patient No. to assign doctor to that patient");
                        P = input.nextInt();//select a patient
                        inputCorrect1 = true;//set the inputCorrect1 to true to quit the while loop
                        input.nextLine();
                    }catch(InputMismatchException ex){//catch the InputMismatchException exception
                        input.nextLine();//clear the entered value to avoid infinite loop
                    }
                    if (P > p.size() || P<0){//error message is printed out if the entered index number>patient vector size
                    System.out.println("Invalid patient no. !");
                    inputCorrect1 = false;//set the boolean to false to remain in the while loop
                }
                
                }
                 
                if (P > 0 && P <= p.size() && D > 0 && D <= d.size()) {
                    if (p.get(P - 1).addDoctor(d.get(D - 1))) {//add the selected doctor to the selected patient
                        d.get(D - 1).addPatient(p.get(P - 1));//add the selected patient to the selected doctor
                    }
                    CorrectSize = true;//set the boolean to true to exit the correctSize while loop
                } 
                
                 
            }           
        }
        else if(choice.equals("remove")){//if user entered "remove"
            System.out.println("\n-----------------------------------------");
            System.out.println("Doctor List" );
            System.out.println("-----------------------------------------");
            for(int i = 0; i<d.size(); i++){//use a for loop to display the doctor list for the user to refer
                System.out.print("Doctor No." + (i+1) + ": ");
                System.out.println(d.get(i).getName());
            } 
            boolean inputCorrect2 = false;//set a boolean value to make sure the user entered correct data type
            while(!inputCorrect2){
               try{//exception handling
                    System.out.println("Which Doctor to be removed from patient?");
                    int D = input.nextInt();//input doctor index
                    d.get(D-1).remove(); //call remove function of the doctor class
                    inputCorrect2 = true;//set the inputCorrect2 boolean to true to exit the while loop
                }catch(InputMismatchException ex){//catch the InputMismatchException exception
                    input.nextLine();//clear the entered data to avoid infinite looping
                }
            }         
        }
    }
}
