package br.senac.lugardefala.visao;

import java.util.List;

import exemplo.modelo.dao.cliente.ClienteDAO;
import exemplo.modelo.dao.cliente.ClienteDAOImpl;
import exemplo.modelo.dao.contato.ContatoDAO;
import exemplo.modelo.dao.contato.ContatoDAOImpl;
import exemplo.modelo.dao.endereco.EnderecoDAO;
import exemplo.modelo.dao.endereco.EnderecoDAOImpl;
import exemplo.modelo.dao.pedido.PedidoDAO;
import exemplo.modelo.dao.pedido.PedidoDAOImpl;
import exemplo.modelo.entidade.cliente.Cliente;
import exemplo.modelo.entidade.contato.Contato;
import exemplo.modelo.entidade.endereco.Endereco;
import exemplo.modelo.entidade.pedido.Pedido;

public class Principal {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		ContatoDAO contatoDAO = new ContatoDAOImpl();
		RelatoDAO relatoDAO = new RelatoDAOImpl();
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

		String nome = "Allan";
		String cpf = "123.456.789-10";

		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setCpf(cpf);
		
		clienteDAO.inserirCliente(usuario);
		
		String telefone = "3332-3232";
		String email = "allan@email.com.br";
		
		Contato contato = new Contato();

		contato.setTelefone(telefone);
		contato.setEmail(email);

		contato.setCliente(usuario);
		
		contatoDAO.inserirContato(contato);

		String logradouro = "Avenida Brasil";
		short numero = 600;

		Relato relato = new Relato();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);

		logradouro = "Avenida Brasil";
		numero = 610;

		relato = new Relato();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);

		logradouro = "Avenida Brasil";
		numero = 650;

		relato = new Endereco();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);
		clienteDAO.atualizarCliente(usuario);
		
		int quantidade = 10;
		Pedido pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);
		
		pedidoDAO.inserirPedido(pedido);

		quantidade = 15;
		pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);

		pedidoDAO.inserirPedido(pedido);
		
		quantidade = 20;
		pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);
		
		pedidoDAO.inserirPedido(pedido);

		nome = "Renato";
		cpf = "321.456.789-10";

		usuario = new Cliente();

		usuario.setNome(nome);
		usuario.setCpf(cpf);
		
		clienteDAO.inserirCliente(usuario);
		
		telefone = "3332-3030";
		email = "renato@email.com.br";
		
		contato = new Contato();

		contato.setTelefone(telefone);
		contato.setEmail(email);

		contato.setCliente(usuario);
		
		contatoDAO.inserirContato(contato);

		logradouro = "Avenida  das Comunidades";
		numero = 600;
		relato = new Endereco();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);

		logradouro = "Avenida  das Comunidades";
		numero = 610;

		relato = new Endereco();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);

		logradouro = "Avenida  das Comunidades";
		numero = 650;

		relato = new Endereco();

		relato.setLogradouro(logradouro);
		relato.setNumero(numero);

		usuario.adicionarEndereco(relato);
		
		enderecoDAO.inserirEndereco(relato);
		clienteDAO.atualizarCliente(usuario);

		quantidade = 10;
		pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);
		
		pedidoDAO.inserirPedido(pedido);

		quantidade = 15;
		pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);
		
		pedidoDAO.inserirPedido(pedido);

		quantidade = 20;
		pedido = new Pedido();

		pedido.setQuantidade(quantidade);
		pedido.setCliente(usuario);

		usuario.adicionarPedido(pedido);
		
		pedidoDAO.inserirPedido(pedido);
		
		List<Cliente> clientes = clienteDAO.recuperarClientes();
		List<Endereco> enderecos = null;
		List<Pedido> pedidos = null;
		
		Contato contatoRecuperado = null;
		
		System.out.println("Os clientes cadastrados são:\n");
		
		for(Cliente clienteCadastrado : clientes) {
			
			System.out.println("Nome: " + clienteCadastrado.getNome());
			System.out.println("CPF: " + clienteCadastrado.getCpf());
			System.out.println();
			
			contatoRecuperado = contatoDAO.recuperarContatoCliente(clienteCadastrado);
			
			System.out.println("Contato: ");
			System.out.println();
			System.out.println("Telefone: " + contatoRecuperado.getTelefone());
			System.out.println("E-mail: " + contatoRecuperado.getEmail());
			System.out.println();
			
			System.out.println("Endereços: ");
			System.out.println();
			
			enderecos = enderecoDAO.recuperarEnderecosCliente(clienteCadastrado);
			
			for(Endereco enderecoRecuperado : enderecos) {
			System.out.println("Logradouro: " + enderecoRecuperado.getLogradouro());
			System.out.println("Número: " + enderecoRecuperado.getNumero());

			}
			
			System.out.println("Pedidos: ");
			System.out.println();
			
			pedidos = pedidoDAO.recuperarPedidosCliente(clienteCadastrado);
			
			for(Pedido pedidoRecuperado : pedidos) {
			System.out.println("Quantidade: " + pedidoRecuperado.getQuantidade());

			}
		}
	}
}