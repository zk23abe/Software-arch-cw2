import java.util.*;

public class Person {
    public Person(String personId, String fullName, Date dob) {
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
    }

    public String getPersonId() {
        return personId;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }



    String personId;
    String fullName;
    Date dob;
}


