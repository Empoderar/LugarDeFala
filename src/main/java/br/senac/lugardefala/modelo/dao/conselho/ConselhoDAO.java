<<<<<<<< HEAD:src/main/java/br/senac/modelo/dao/conselho/ConselhoDAO.java
package br.senac.modelo.dao.conselho;
========
package br.senac.lugardefala.modelo.dao.conselho;
>>>>>>>> 066659a11423408d8e1de7872524a108b3a39336:src/main/java/br/senac/lugardefala/modelo/dao/conselho/ConselhoDAO.java

import java.util.List;

import br.senac.modelo.entidade.conselho.Conselho;

public interface ConselhoDAO {

	void inserirConselho();

	void deletarConselho();

	void atualizarConselho();

	List<Conselho> recuperarClientes();

	Conselho recuperarContatoCliente(Conselho conselho);
}
