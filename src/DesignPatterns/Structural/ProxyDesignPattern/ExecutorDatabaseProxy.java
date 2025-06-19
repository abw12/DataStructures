package DesignPatterns.Structural.ProxyDesignPattern;


//here we create a proxy class which control the access on who can access the particular DB command or the cmd command
//therefore it is called as proxy design pattern

//The proxy class also implements the same interface as the real object. It holds a reference to the real object and controls access to it.
// The proxy can add extra logic like logging, caching, or security checks before calling the real object’s methods.
public class ExecutorDatabaseProxy implements Executors {
    private boolean isAdmin; //to demonstrate the access control functionality
    private ExecutorCmdImp executorCmdImp; //hold the ref to the real object

    public ExecutorDatabaseProxy(String user,String pwd){
        if(user.equalsIgnoreCase("ADMIN")){
            isAdmin=true;
        }
        executorCmdImp =new ExecutorCmdImp();
    }


    @Override
    public void executeCommand(String query) throws Exception{
        if(isAdmin){
            executorCmdImp.executeCommand(query);
        }else{
            if(query.equalsIgnoreCase("DELETE")){
                throw  new Exception("DELETE command is not allowed for this USER!!");
            }else{
                executorCmdImp.executeCommand(query);
            }
        }
    }
}
