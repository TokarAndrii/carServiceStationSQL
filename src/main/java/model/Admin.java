package model;

public class Admin extends Worker {


    private volatile static Admin uniqueinstance;
    private String password;
    private WorkerTypes workerTypes;
    private  String firstName;
    private  String secondName;
    private long salary;
    private String login;

    public Admin() {
       workerTypes=WorkerTypes.ADMINISTRATOR;
        firstName="testAdminFirstName";
        secondName="testAdminSecondName";
        password="admin";
        login="admin";
        salary=1;
    }

    public static Admin getUniqueinstance(){
       if(uniqueinstance==null){
           synchronized (Admin.class){
               if (uniqueinstance==null){
                   uniqueinstance=new Admin();
               }
           }
       }
        return uniqueinstance;
   }

}
