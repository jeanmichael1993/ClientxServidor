import java.net.*;
import java.io.*;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket conexao = new Socket("127.0.0.1", 2001);
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

        String linha;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Digite mensagem: ");
            linha = teclado.readLine();
            System.out.println("Mensagem enviada. ");
            saida.writeUTF(linha);
            System.out.println("Esperando Resposta. ");
            linha = entrada.readUTF();
            if (linha.equalsIgnoreCase("SAIR")) {
                System.out.println("Desconectando!");
                break;
            }
            System.out.println(linha);
        }

    }

}