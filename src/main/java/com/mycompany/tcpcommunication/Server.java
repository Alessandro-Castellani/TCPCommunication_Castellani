 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Server {
    private ServerSocket serverSocket;  // IL CONNECTION SOCKET
    private Socket Socket;        // IL DATA SOCKET
    private int port = 1906;
    InputStream is;
    Scanner streamIn = null;
    OutputStream os;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;



    
    // costruttore di Server 
    public Server(int port){
        this.port=port;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Il server è in ascolto");
        } catch (IOException e) {
            System.err.println("Server non in ascolto " + e);
        }
    }

    // FINORA ABBIAMO FATTO SOCKET, BIND E LISTEN, ORA FACCIAMO ACCEPT

    public Socket attendi(){
        try{
            Socket = serverSocket.accept();
            System.out.println("Server connesso con il client");
            os = Socket.getOutputStream();
            streamOut = new PrintWriter(os);
            is = Socket.getInputStream();
            streamIn = new Scanner(is);
        } catch (IOException e){
            System.err.println("Problemi di connessione con il client" + e);
        }
        return Socket;
    }
    
    public void scrivi() throws IOException{
        System.out.println("Spedisco il messaggio al client");
        messaggioOut = "Ciao client! Ti aspettavo";
        streamOut.println(messaggioOut);
        streamOut.flush();
    }
    
    public void leggi() throws IOException{
        System.out.println("Leggo il messaggio del client!");
        messaggioIn = streamIn.nextLine();
        System.out.println("Messaggio del client: " + messaggioIn);
        System.out.println("----------------------------------");
    }
    
    public void chiudi(){
        try {
            if (Socket != null) {
                Socket.close();
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public void termina(){
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}
