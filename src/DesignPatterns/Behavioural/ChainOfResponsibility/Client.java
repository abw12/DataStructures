package DesignPatterns.Behavioural.ChainOfResponsibility;

public class Client {

    public static void main(String[] args) {
        Level1Support level1Support = new Level1Support();
        Level2Support level2Support = new Level2Support();
        Level3Support level3Support = new Level3Support();

        //setting upt the handler chain ( can modify it anytime without making any other changes
        level1Support.setNextHandler(level2Support);
        level2Support.setNextHandler(level3Support);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        // always client sending the first request to the level1support
        level1Support.processRequest(request1);
        level1Support.processRequest(request2);
        level1Support.processRequest(request3);
    }
}
