package health.com;

import java.util.ArrayList;

public class Login {
    public static ArrayList <User> users=new ArrayList<User>();


    public Login(){
        User osama = new User();
        osama.name="admin";
        osama.password="admin123";
        users.add(osama);
    }


    public boolean isValid(String name){
        for (int i=0;i<users.size();i++){
            System.out.println(Login.users.get(i).name);
            if(users.get(i).name.equals(name)){
                return true;
            }
        }
        return false ;
    }


    @Override
    public int hashCode() {
        int y=0;
        return 9;
    }
}
