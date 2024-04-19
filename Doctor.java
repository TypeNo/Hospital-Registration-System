import java.util.Vector;
import java.util.Scanner;

public class Doctor extends Person{//inherits from Person
    private String Name;
    private String Speciality;
    Vector<Patient> assignPatients= new Vector<>();//set a patient vector in doctor class
    
    public Doctor(String AccName, String pwd, String Name, String Speciality){//doctor constructor
        super(AccName, pwd); //set the parent class cosntructor using "super"
        this.Name = Name;//set the Name of the class = parameter Name
        this.Speciality = Speciality;//set the Speciality of the class = parameter Speciality
    }

    public String getName(){//getter of Name
        return Name;
    }

    public String getSpeciality(){//getter of Speciality
        return Speciality;
    }

    public void Display(){ //Overwrite the display function to print out the Doctor name and specility
        System.out.println("Doctor Information");
        System.out.println("Doctor name: " + Name);
        System.out.println("Doctor speciality: " + Speciality);
    }

    public void addPatient(Patient patient){//add the patient to the assignPatients' vector
        assignPatients.add(patient);
    }

    public void remove(){//overwrite the remove function to remove the patient from the vector
        if(assignPatients.isEmpty()){//if the vector is empty
            System.out.println("This doctor has no patient assigned to him");
            return;
        }
        Scanner obj1 = new Scanner(System.in);//create a scanner class object to enter data
        System.out.println("-----------------------------------------");
        System.out.println("Patient List" );
        System.out.println("-----------------------------------------");
        for(int i = 0; i<assignPatients.size(); i++){//use a for loop to display the patient list for the user to refer
            System.out.print("Patient No." + (i+1) + ": ");
            System.out.println(assignPatients.get(i).getName());
        }
        System.out.print("Remove patient no: ");
        int i = obj1.nextInt();//select a patient
        assignPatients.get(i-1).remove();//remove the patient
        assignPatients.removeElementAt(i-1);
        System.out.println("Patient removed successfully!");
    }

    public String toString(){//overwrite of the toString function
        Display();
        StringBuilder assignedPa = new StringBuilder();//use a string builder class object to return several String data

        if(assignPatients.isEmpty()){//if vector is empty
            assignedPa.append("No patient is assigned!").append("\n");
        }
        else{
            for(int i=0;i<assignPatients.size();i++){//show all assigned patient
                String PaName = assignPatients.get(i).getName();
                assignedPa.append("Patient assigned ").append(i+1).append(": ").append(PaName).append("\n");
            }
        }
        return assignedPa.toString();//return the StringBuilder object.toString() 
    }
}
