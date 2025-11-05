package EnumPractice;

public class Pizza {

    private PizzaStatus pizzaStatus;
    private enum PizzaStatus{
        //Need to provide the parameter since constructor expect it (timeToDeliver)
        // these are known as the enum type
        ORDERED(5){
            //we can override the instance method in the enum type
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2){
            @Override
            public boolean isReady() {
                return super.isReady();
            }
        },
        Delivered(0){
            @Override
            public boolean iDelivered() {
                return super.iDelivered();
            }
        };

        //fields,methods and constructor in enum
        private int timeTODelivery;

        public boolean isOrdered(){return false;}

        public boolean iDelivered(){return false;}

        public boolean isReady(){return false;}

        public int getTimeToDelivery(){
            return timeTODelivery;
        }

        //All enum type(ORDERED,DELIVERED,READY) of the enum class PizzaStatus will use this constructor
        // signature
        PizzaStatus(int timeToDelivery){
            this.timeTODelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable(){
        return getPizzaStatus() == PizzaStatus.READY;
    }

    public void printTimeToDeliver(){
        System.out.println("Time to delivery is " + this.getPizzaStatus().getTimeToDelivery());
    }

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }
}
