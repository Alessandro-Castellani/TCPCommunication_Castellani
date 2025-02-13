/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpcommunication;

import java.io.IOException;

/**
 *
 * @author user
 */
public class MainClient {
    
    
    public static void main(String[] args) throws IOException{
        Client c1 = new Client("Alessandro");
        c1.connetti("localhost", 2000);
        c1.scrivi();
        c1.chiudi();
    } 
}
