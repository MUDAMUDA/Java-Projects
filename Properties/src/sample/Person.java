package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

   private StringProperty firstName = new SimpleStringProperty(this,"firstName", "");

   // reutrns the firstname value (i.e PeePee)
    public String getFirstName() {
        return firstName.get();
    }
    //Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
