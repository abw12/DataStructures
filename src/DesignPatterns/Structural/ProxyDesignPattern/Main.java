package DesignPatterns.Structural.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instead of creating the real object directly, the client interacts with the proxy. The proxy decides when and how to forward the client’s request to the real object.
        ExecutorDatabaseProxy obj1 = new ExecutorDatabaseProxy("ADMIN","1234");
        obj1.executeCommand("DELETE");

        ExecutorDatabaseProxy obj2 = new ExecutorDatabaseProxy("NON-ADMIN","4567");
//        obj2.executeCommand("DELETE");
            obj2.executeCommand("CREATE");

    }
}
