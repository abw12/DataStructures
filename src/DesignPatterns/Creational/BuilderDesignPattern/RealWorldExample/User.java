package DesignPatterns.Creational.BuilderDesignPattern.RealWorldExample;

public class User {
    //All members are private
    private final String firstName; //required
    private final String lastName; //required
    private final int phnNumber; //optional
    private final int age; //optional
    private final String email; //optional

    private User(UserBuilder builder){
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.age=builder.age;
        this.phnNumber= builder.phnNumber;
        this.email= builder.email;
    }

    //Create only getters and No Setters since we need object immutability
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhnNumber() {
        return phnNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phnNumber=" + phnNumber +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

      static class UserBuilder {

        private final String firstName; //this is required field in user obj hence its final
        private final String lastName; //this is required field in user obj hence its final
        private int age;
        private int phnNumber;
        private String email;

        public UserBuilder(String firstName,String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }

        public UserBuilder withAge(int age){
            this.age=age;
            return this;
        }

        public UserBuilder withPhnNumber(int phnNumber){
            this.phnNumber=phnNumber;
            return this;
        }

        public UserBuilder withEmail(String email){
            this.email=email;
            return this;
        }

        public User build(){
            //passing the current instance of the UserBuilder class
            return new User(this);
        }

    }

}




