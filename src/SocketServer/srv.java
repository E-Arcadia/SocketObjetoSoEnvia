package SocketServer;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pacote.ObjetoMensagem;


public class srv {

	public static void main(String[] args) throws Exception {
		ObjetoMensagem aMensagem;
		// Cria um serviço Socket
		@SuppressWarnings("resource")
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		// Aguarda pedido de conexão
		Socket cliente = servidor.accept(); // metodo blocante

		//Recebe objetos do cliente
		ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		while ((aMensagem = (ObjetoMensagem) entrada.readObject()) != null) {
			System.out.println(aMensagem.toString());
		}
	}
}
