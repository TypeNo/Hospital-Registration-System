public class Patient extends Person{//Inherits from Person
    private String Name;
    private Doctor assignedDr;

    public Patient(String AccName, String pwd, String Name){//Patient Constructor
        super(AccName, pwd);//set the parent class constructor using "super"
        this.Name = Name;//set the Name of the class = parameter Name
    }

    public String getName(){//getter of the Name
        return Name;
    }
    public void Display(){//Overwrite the Display function to display the patient information
        System.out.println("\nPatient Information");
        System.out.println("Patient name: " + Name);
    }
    public boolean addDoctor(Doctor dr){//##uml changes
        if(assignedDr!=null){//if the patient already has a doctor
            if(assignedDr==dr){//if the same doctor assigned to the same patient
                System.out.println("The doctor has already been assigned to this patient");
                return false;
            }
            //if the patient already assigned another doctor
            System.out.println("\n-----------------------------------------");
            System.out.println("This patient has already been assigned a doctor. If you want to assign another new doctor to him, please remove the current responsible doctor");
            System.out.println("The current responsible doctor is "+assignedDr.getAccName());
            System.out.println("\n-----------------------------------------");
            return false;
        }
        //if the patient has no doctor
        assignedDr = dr;
        System.out.println("Patient assigned successfully!");
        return true;
    }

    public void remove(){//Overwrite the remove function to remove the doctor by set the assignedDr object = null 
        assignedDr = null;  
    }
    public String toString(){//Overwrite the toString function
        Display(); 
        String showDr;
        if(assignedDr == null){//if no doctor is assigned
            showDr = "No doctor is assigned!\n";
        }
        else{//if got doctor, then return showDr
            String DrName = assignedDr.getName();
            showDr = "Doctor assigned: " + DrName;
        }
        return showDr;
    } 
}