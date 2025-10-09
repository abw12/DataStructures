package GRASP;

import java.util.Objects;

//Information Expert (holds state related to the rider itself.)
public record Rider(String name, int mobNum, String rideDetails) {
    // when record was introduced in java 14 we used to write the constructor like below
    //    public Rider(int name,int mobNum,String riderDetails){
//        this.name =name;
//        this.mobNum = mobNum;
//        this.riderDetails=riderDetails;
//    }

    //in java 17 compact constructor was introduced which allowed to create constructor in record class without defining parameters again
    public Rider{
        Objects.requireNonNull(rideDetails);
        System.out.println(" Rider name :: " + name + " Mobile Number :: " + mobNum + " Rider request :: " + rideDetails);
        // in compact constructor it is fine to not define again all the parameter variables
    }
}
