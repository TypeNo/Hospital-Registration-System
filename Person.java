public class Person {//
    protected String AccName;
    protected String pwd;

    Person(String AccName, String pwd){//constructor
        this.AccName = AccName;
        this.pwd = pwd;
    }
    public String getAccName(){//getter of the AccName
        return AccName;
    }
    public String getpwd(){//getter of the pwd
        return pwd;
    }
    public void Display(){}//Initial Display function
    public void remove(){}//Initial Remove function
}
