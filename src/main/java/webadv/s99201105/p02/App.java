package webadv.s99201105.p02;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) {

    	saveUser("17201309", sha256hex("123456"));
    	Scanner input = new Scanner(System.in);

    	String userName="";
    	String password="";
    	String[] user = getUser();

    	while(true) {
		System.out.println("请输入账号：");
		userName = input.nextLine();
		System.out.println("请输入密码：");
		password =input.nextLine();
		if(userName.equals(user[0]) &&sha256hex(password).equals(user[1])) {
	    		System.out.println("登录成功");
	    		break;
		}else 
	    		System.out.println("账号或者密码错误！请重新输入");
	 
   	 }
    }

    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

    public static void saveUser(String userName,String password) {
        BufferedWriter out;
	try {
	    out = new BufferedWriter(new FileWriter("user.txt",true));
	    out.write(userName+"\n");
	    out.write(password);
	    out.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static String[] getUser() {
    	String[] user = new String[2];
    	try {
	        BufferedReader in = new BufferedReader(new FileReader("user.txt"));
        	        user[0] = in.readLine();
        	        user[1] = in.readLine();
	        in.close();
	    } catch (IOException e) {
	    }
	    return user;
    }
}