/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */

public class Client {

    /**
     *
     */
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    private String colore;
    private Socket socket = null;
    int port = 1906;
    InetAddress serverAddress;
    InputStream is;
    Scanner streamIn = null;
    OutputStream os;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;
    

    // Costruttore con nome e colore
    public Client(String nomeDefault, String coloreDefault){
        colore=coloreDefault;
        
    }
    
    // Costruttore con solo nome
    public Client(String nomeDefault){
    }
    
    // Metodo connetti 
    public void connetti(String nomeServer, int portaServer){
        try {
            // istanza esplicita del socket che potrebbe sollevare eccezioni di input/output
            socket = new Socket(nomeServer, portaServer);
            System.out.println(this.colore + "1) Connessione avvenuta");
        } catch (IOException e){
            System.err.println("Errore nella fase di connessione: "+ e);
        }
    }
    
    public void scrivi() throws IOException{
        os = socket.getOutputStream();
        streamOut = new PrintWriter(os);
        streamOut.flush();
        messaggioOut = "Eccomi!";
        streamOut.println(messaggioOut);
        streamOut.flush();
    }
    
    public void leggi() throws IOException{
        streamIn = new Scanner(is);
        is = socket.getInputStream();
        messaggioIn = streamIn.nextLine();
        System.out.println("Messaggio del server: " + messaggioIn);
    }
    
    public void chiudi(){
        try {
            // chiusura del socket
            if (socket != null) {
                socket.close();
                System.out.println("Connessione chiusa.");
            }
        } catch (IOException e) {
            System.err.println("Errore nella chiusura della connessione: " + e);
        }
    }
}
