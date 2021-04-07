
import java.net.*;
import java.io.*;

public class Servidor {

    public static void main(String[] args) throws IOException, EOFException {

        ServerSocket s = new ServerSocket(2001);

        while (true) {
            System.out.println("Esperando conectar...");
            Socket conexao = s.accept();
            System.out.println("Conectou!");
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            System.out.println("Esperando mensagem!");
            String linha = entrada.readUTF();
            System.out.println("Mensagem recebida :" + linha);
            while (linha != null && !(linha.trim().equalsIgnoreCase("SAIR"))) {
                if(linha.trim().equalsIgnoreCase("lalala")){
                    saida.writeUTF("Resposta recebida: " + "lelele");
                    System.out.println("Resposta enviada!");
                    linha = entrada.readUTF();
                }
                else {
                    saida.writeUTF("Resposta recebida: " + linha);
                    linha = entrada.readUTF();
                    System.out.println("Resposta enviada!");
                }
            }
            saida.writeUTF(linha);
            System.out.println("Conexão encerrada!");

            conexao.close();
        }
    }
}