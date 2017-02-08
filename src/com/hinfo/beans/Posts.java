/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinfo.beans;

import java.io.Serializable;
import java.sql.Array;
import java.util.Calendar;

/**
 *
 * @author henrique
 */
public class Posts implements Serializable{
    int id;
    String resumo;
    String mensagem;
    Calendar dataPostagem;
    String tags;
    String autor;
    
    
    public Posts(){
        
    }

    public Posts(String resumo, String mensagem, String tags, String autor) {
        this.resumo = resumo;
        this.mensagem = mensagem;
        this.tags = tags;
        this.autor = autor;
    }
 
    public Posts(int id, String mensagem, String tags, String autor) {
        this.id = id;
        this.mensagem = mensagem;
        this.tags = tags;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Calendar getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Calendar dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
