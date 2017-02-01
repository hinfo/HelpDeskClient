/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinfo.beans;

import java.io.Serializable;

/**
 *
 * @author henrique
 */
public class Tag implements Serializable{
    int id;
    String nome;

    public Tag(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tag(String nome) {
        this.nome = nome;
    }

    public Tag() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
