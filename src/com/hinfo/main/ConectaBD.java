/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinfo.main;

import com.hinfo.beans.Posts;
import com.hinfo.beans.Tag;
import com.hinfo.beans.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public interface ConectaBD extends Remote{
    public Connection conectar() throws ClassNotFoundException, RemoteException;
    public void executaSQL(String sql) throws SQLException, RemoteException;
    public void consultarUsuarios(int id) throws RemoteException, ClassNotFoundException;
    public String adicionarPost(Posts post) throws SQLException, RemoteException;
    public void desconectar(Connection conn) throws RemoteException;
    public void adicionarUsuario(Usuario usuario) throws SQLException, RemoteException;
    public void adicionarTags(Tag tag) throws SQLException, RemoteException;
    public ArrayList consultaPosts(String resumo, String tag) throws SQLException, RemoteException;
    public String consultarTags(int id) throws ClassNotFoundException, RemoteException;
    public String  mensagem() throws RemoteException; 
    public ArrayList listarTags() throws RemoteException, ClassNotFoundException;
}
