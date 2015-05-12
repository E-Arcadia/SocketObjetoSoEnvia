package SocketServer;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pacote.ObjetoMensagem;
import pacote.ObjetoMensagem.Acao;

public class srv {

	public static void main(String[] args) throws Exception {
		ObjetoMensagem aMensagem = null;
		// Cria um serviço Socket
		@SuppressWarnings("resource")
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		// Aguarda pedido de conexão
		Socket cliente = servidor.accept(); // metodo blocante

		// Recebe objetos do cliente
		ObjectInputStream entrada = new ObjectInputStream(
				cliente.getInputStream());
		try {
			while ((aMensagem = (ObjetoMensagem) entrada.readObject()) != null) {
				if(aMensagem.getAction() == Acao.DESCONECTAR){
					System.out.println("Cliente "+ aMensagem.getName() +" - Encerrou a conexão.");
					break;
				}
					
				System.out.println(aMensagem.toString());
			}
		} catch (Exception e) {
			System.out.println("Cliente "+ aMensagem.getName() +" - Interrompeu conexão.");
		}

	}
}
