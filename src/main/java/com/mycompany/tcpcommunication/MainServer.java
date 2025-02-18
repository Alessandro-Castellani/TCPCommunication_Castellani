/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;

import java.io.IOException;
import java.net.Socket;

public class MainServer {
    
    public static void main(String[] args) throws IOException {
        Server server = new Server(2000);
        Socket ss = server.attendi();        /* RESTITUISCE UN SOCKET */
        try {
            server.leggi();   // Legge il messaggio dal client
            server.scrivi();  // Risponde al client
        } catch (IOException e) {
            System.err.println("Errore durante la comunicazione: " + e);
        } finally {
            server.chiudi();
            server.termina();
        }

    }
}
