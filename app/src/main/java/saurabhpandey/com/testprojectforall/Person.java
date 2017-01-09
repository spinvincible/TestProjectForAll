package saurabhpandey.com.testprojectforall;

/**
 * Created by Nixxmare on 1/10/2017.
 */

public class Person {

    private String name;
    private String email;
    private String hobby;

    public Person(){

    }


    public Person(String name , String email , String hobby){
        this.name= name;
        this.email = email;
        this.hobby = hobby;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHobby() {
        return hobby;
    }
}
