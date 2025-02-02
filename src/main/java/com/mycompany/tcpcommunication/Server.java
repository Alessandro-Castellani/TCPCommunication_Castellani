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
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int porta;
    
    public Server(int porta){
        this.porta=porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException e) {
            System.err.println("Server non in ascolto " + e);
        }
    }
    
    public Socket attendi(){
        try{
            clientSocket = serverSocket.accept();
        } catch (IOException e){
            System.err.println(e);
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
            
        }
    }
    
    public void termina(){
        
    }
}
