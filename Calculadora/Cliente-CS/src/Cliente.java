import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException{
		
            int num1;
            int num2;
            Scanner teclado = new Scanner(System.in);
            
            Socket cliente = new Socket("127.0.0.1", 1234);
            System.out.println("---Bem vindo ao servidor calculadora!---" + "\n   Clente Conectado ao servidor");
            
            ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream numeros = new ObjectOutputStream(cliente.getOutputStream());
            
            while(!teclado.equals("sair")){
                
                System.out.print("Digite o primeiro valor:\n");
                num1 = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Digite o segundo valor:\n");
                num2 = teclado.nextInt();

                numeros.writeInt(num1);
                numeros.writeInt(num2);
                numeros.flush();

                int soma = resultado.readInt();
                System.out.println("Resultado da soma: " + soma + "\n");
                            
            }
            
            
            
            resultado.close();
            numeros.close();
            cliente.close();

	}

}
