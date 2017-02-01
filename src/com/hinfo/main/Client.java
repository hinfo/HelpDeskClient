package com.hinfo.main;


import com.hinfo.beans.Tag;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;



 

public class Client extends java.applet.Applet {

    private static final long serialVersionUID = 8955982032825384670L;

        String mensagem = "";

        public void doTest() {

              try {
                  
                  /**
                   * Faz a conexao passando por parametros IP e porta
                   * 
                   */
                Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
                
                /**
                 * Procura pelo serviço no servidor
                 * Cria um objeto 
                 */
                
                ConectaBD obj = (ConectaBD) myRegistry.lookup("servico");
                
                /**
                 * Executa método remoto
                 * e retorna para variável no client
                 */
                Connection conn = obj.conectar();
                obj.adicionarTags(new Tag("Henrique"));
                //System.out.println(mensagem);

            } catch (Exception e) {

                System.out.println("Ocorreu uma exceção");
                  System.out.println("Verifique se o servidor está online");

                e.printStackTrace();

            }

        }
        public static void main(String[] args) {
        Client main = new Client();
        main.doTest();
    }

}

