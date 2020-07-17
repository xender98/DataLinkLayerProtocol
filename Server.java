import java.net.*;
import java.io.*;
import java.util.*;
 class Frame implements Serializable{
private static final long serialVersionUID =-2724548458236966324L;
 int seq;
	 String frame;
	 
	 public Frame(int u,String s){
		 this.seq=u;
		 this.frame=s;
	 }
	 public void put(){
		 

	 }
 	 public void get(){
System.out.println(this.seq+" "+this.frame);	
	}

 }
public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private ObjectInputStream in       =  null;
 
    // constructor with port
    public Server(int port)
    {
		 
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new ObjectInputStream(socket.getInputStream());
 
            Frame line = null;
			int u=0;
            // reads message from client until "Over" is sent
            while (u<10)
            {
                try
                {
                    line = (Frame)in.readObject();
					line.get();
 
                }
                catch(Exception i)
                {
                    System.out.println("my error:"+i);
                }
				u++;
            }
            //System.out.println("Closing connection");
 
            // close connection
         //   socket.close();
         //   in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])throws ClassNotFoundException
    {
        Server server = new Server(5000);
    }
}