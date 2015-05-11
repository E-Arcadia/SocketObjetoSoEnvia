package SocketCliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import pacote.ObjetoMensagem;
import pacote.ObjetoMensagem.Acao;

public class cli {

	public static void main(String[] args) throws Exception, IOException {
		ObjectOutputStream saida = null;
		ObjetoMensagem umaMensagem = new ObjetoMensagem();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		umaMensagem.setName(teclado.nextLine());
		Socket cliente = new Socket("127.0.0.1", 12345);
		if (cliente != null) {
			System.out.println("O cliente se conectou ao servidor!");

			saida = new ObjectOutputStream(cliente.getOutputStream());

			while (teclado.hasNextLine()) {
				umaMensagem.setMensagemAcao(teclado.nextLine(),
						Acao.NOVA_MENSAGEM);
				saida.writeObject(umaMensagem);
				saida.flush();
			}
		}

		saida.close();
		teclado.close();
		cliente.close();
	}
}
