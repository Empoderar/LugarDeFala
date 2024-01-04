package br.senac.lugardefala.modelo.dao.denuncia;

import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaConselho;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaModerador;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaRelato;
import br.senac.lugardefala.modelo.entidade.denuncia.DenunciaUsuario;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;
import br.senac.lugardefala.modelo.enumeracao.Status;

public interface DenunciaDAO {

	void inserirDenuncia(Denuncia denuncia);

	void inserirDenunciaModerador(DenunciaModerador denunciaModerador);

    void inserirDenunciaRelato(DenunciaRelato denunciaRelato);

    void inserirDenunciaUsuario(DenunciaUsuario denunciaUsuario);
    
    void inserirDenunciaConselho(DenunciaConselho denunciaConselho);

	void deletarDenuncia(Denuncia denuncia);

	void atualizarDenuncia(Denuncia denuncia);

	Denuncia recuperarDenunciaUsuario(Usuario usuario);
	
	Denuncia recuperarDenunciaDeRelatoStatus(Relato relato,Status status);
	
	Denuncia recuperarDenunciaDeRelatoRelato(Relato relato);
	
	Denuncia recuperarDenunciaDeConselhoStatus(Conselho conselho,Status status);
	
	Denuncia recuperarDenunciaDeConselhoRelato(Conselho conselho,Relato relato);
	
	Denuncia recuperarDenunciaDeUsuarioStatus(Usuario usuario, Status status);
	
	Denuncia recuperarDenunciaDeUsuarioUsuario(Usuario usuario);

	
}
