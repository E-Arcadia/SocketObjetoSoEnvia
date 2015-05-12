package SocketCliente;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextField;

import pacote.ObjetoMensagem;
import pacote.ObjetoMensagem.Acao;

public class cli {

	public static void main(String[] args) throws Exception, IOException {
		ObjectOutputStream saida = null;
		String nomeUsuario;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		nomeUsuario = teclado.nextLine();
		Socket cliente = new Socket("127.0.0.1", 12345);
		if (cliente != null) {
			System.out.println("O cliente se conectou ao servidor!");
			saida = new ObjectOutputStream(cliente.getOutputStream());
			Boolean continua = true;
			System.out.println("Digite a mensagem: ");
			while (continua && teclado.hasNextLine()) {
				ObjetoMensagem umaMensagem = new ObjetoMensagem();
				umaMensagem.setName(nomeUsuario);
				String mensagem = teclado.nextLine();
				if(!mensagem.equalsIgnoreCase("sair")){
					umaMensagem.setMensagemAcao(mensagem, Acao.NOVA_MENSAGEM);
					System.out.println("Digite a mensagem: ");
				}else{
					umaMensagem.setMensagemAcao(mensagem, Acao.DESCONECTAR);
					continua = false;
				}
				saida.writeObject(umaMensagem);
			}; 
			System.out.println("-- Conexão encerrada. --");
		}

		saida.close();
		teclado.close();
		cliente.close();
	}
}
