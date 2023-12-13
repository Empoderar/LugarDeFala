package br.senac.modelo.dao.relato;

import java.util.List;

import br.senac.modelo.entidade.relato.Relato;
import br.senac.modelo.entidade.usuario.Usuario;

public interface RelatoDAO {

	void inserirRelato(Relato relato);

	void deletarRelato(Relato relato);

	List<Relato> recuperarRelatos();

	Relato recuperarRelatoUsuario(Usuario usuario);
}