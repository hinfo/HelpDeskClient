/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinfo.main;

import com.hinfo.beans.Tag;
import java.awt.List;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author henrique
 */
public class Testes implements Serializable{

    public static final long serialVersionUID = 7599760334248887500L;

    public static void main(String[] args) throws RemoteException, ClassNotFoundException, 
            SQLException, NotBoundException {
        
        Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
        ConectaBD obj = (ConectaBD) myRegistry.lookup("servico");
        System.out.println("Resposta: " + obj.mensagem());
        String tagNome;
        ArrayList lista = new ArrayList();
        try {
            lista = obj.listarTags();
            
            for (int i = 0; i < lista.size(); i++){
                System.out.println("" + lista.toArray()[i]);
            }
                             
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro remoto: " + e);
        }
        
        
            
    }
    
}
