/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Server {
    private ServerSocket serverSocket;  // IL CONNECTION SOCKET
    private Socket clientSocket;        // IL DATA SOCKET
    private int porta;
    
    // costruttore di Server 
    public Server(int porta){
        this.porta=porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException e) {
            System.err.println("Server non in ascolto " + e);
        }
    }

    // FINORA ABBIAMO FATTO SOCKET, BIND E LISTEN, ORA FACCIAMO ACCEPT
    
    public Socket attendi(){
        try{
            clientSocket = serverSocket.accept();
            System.out.println("Server connesso con il client");
        } catch (IOException e){
            System.err.println("Problemi di connessione con il client" + e);
        }
        return clientSocket;
    }
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
    }
    
    public void chiudi(){
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }
    
    public void termina(){
        
    }
}
