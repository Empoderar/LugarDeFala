package br.senac.lugardefala.modelo.dao.usuario;

import br.senac.lugardefala.modelo.entidade.comunidade.Comunidade;
import br.senac.lugardefala.modelo.entidade.conselho.Conselho;
import br.senac.lugardefala.modelo.entidade.denuncia.Denuncia;
import br.senac.lugardefala.modelo.entidade.relato.Relato;
import br.senac.lugardefala.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

    void inserirUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);

    void atualizarUsuario(Usuario usuario);

    Usuario recuperarUsuarioNome(String nome);
   
   	Usuario recuperarUsuarioComunidade(Comunidade comunidade);
   	
   	Usuario recuperarUsuarioConselho(Conselho conselho);
   	
   	Usuario recuperarUsuarioDenuncia(Denuncia denuncia);
   	
   	Usuario recuperarUsuarioRelato(Relato relato);
}