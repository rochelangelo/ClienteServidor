import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class servidor {

	public static void main(String args[]) throws IOException{
		
            int num1, num2, total;
            
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("---Servidor aberto a conexão!---" + "\n   Aguardando conexão");
            Socket cliente = servidor.accept();
            System.out.println("\nConexão com Cliente: " + cliente.getInetAddress().getHostAddress());
                
            ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream numeros = new ObjectInputStream(cliente.getInputStream());
                
            num1 = numeros.readInt();
            num2 = numeros.readInt();
               
            total = num1 + num2;
            
            resultado.writeInt(total);
            resultado.flush();
            
            resultado.close();
            numeros.close();
            cliente.close();
            servidor.close();
		
	}
}
