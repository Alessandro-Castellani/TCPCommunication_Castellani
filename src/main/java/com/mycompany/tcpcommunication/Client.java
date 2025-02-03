/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author user
 */

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

    // Costruttore con nome e colore
    public Client(String nomeDefault, String coloreDefault){
        nome=nomeDefault;
        colore=coloreDefault;
    }
    
    // Costruttore con solo nome
    public Client(String nomeDefault){
        nome=nomeDefault;
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
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
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
