import java.util.*;
import java.net.*;
import java.io.*;
 class Frame implements Serializable
{
	private static final long serialVersionUID =-2724548458236966324L;
	int seq;
	String frame;
	public Frame(int u,String s){
		 this.seq=u;
		 this.frame=s;
	 }
	 
	
	public void get()
	{
		System.out.println(this.seq+" "+this.frame);
	}
}
public class Client11
{
	

    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private ObjectInputStream is=null;
	private ObjectOutputStream  os=null;
	
	public Client11(String address, int port)
	{
		Frame[] arr=new Frame[10];
	 arr[0]=new Frame(23,"Darshan");
	 arr[1]=new Frame(22,"Utsav");
	 arr[2]=new Frame(24,"Varun");
	 arr[3]=new Frame(25,"Mariyam");
	 arr[4]=new Frame(21,"Crains");
	 arr[5]=new Frame(20,"Umang");
	 arr[6]=new Frame(1,"aaa");
	 arr[7]=new Frame(2,"abc");
	 arr[8]=new Frame(3,"xyz");
	 arr[9]=new Frame(4,"11xyz");
        try
        {



            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            //is  = new ObjectInputStream(System.in);
			
            // sends output to the socket
            os    = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(Exception i)
        {
            System.out.println(i);
        }
 
        // string to read message from input
        Frame line;
		//Scanner sc=new Scanner(System.in);
 
        // keep reading until "Over" is input
        int u=0;
		while (u<10)
        {
            try
            {
                line=arr[u];
                os.writeObject(line);
            }
            catch(Exception i)
            {
                System.out.println(i);
            }
			u++;
        }
 
        // close the connection
        try
        {
           
			
			os.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[]) throws ClassNotFoundException
    {
        Client11 client = new Client11("192.168.0.101",5000);
    }
}