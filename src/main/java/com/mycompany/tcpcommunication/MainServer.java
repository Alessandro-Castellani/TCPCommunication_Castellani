/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;

import java.net.Socket;

public class MainServer {
    
    public static void main(String[] args) {
        Server s = new Server(2000);
        Socket ss = s.attendi();        /* RESTITUISCE UN SOCKET */
    }
}
