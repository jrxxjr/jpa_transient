package br.com.tidicas.main;

import java.util.Date;
import java.util.logging.Logger;
import br.com.tidicas.dao.BlogDao;
import br.com.tidicas.dao.CategoriaDao;
import br.com.tidicas.model.Blog;
import br.com.tidicas.model.Categoria;
import junit.framework.TestCase;

/**
 * Classe para geração das tabelas e teste com operacoes crud  
 *   
 * @author Evaldo Junior
 *
 */
public class TesteCrudJpa extends TestCase {

	private static final Logger LOGGER = Logger.getLogger(TesteCrudJpa.class.getName());

	public static void testCrud() {

		CategoriaDao daoCategoria = new CategoriaDao();
		BlogDao daoBlog = new BlogDao();

		// 1 Entidade Categoria
		Categoria categoria1 = new Categoria();
		categoria1.setDescricao("categoria 1");

		Categoria categoria2 = new Categoria();
		categoria2.setDescricao("categoria 2");

		daoCategoria.adiciona(categoria1);

		daoCategoria.adiciona(categoria2);

		categoria1 = daoCategoria.busca(categoria1.getCodigo());
		LOGGER.info("retorno :" + categoria1.getCodigo());

		categoria2 = daoCategoria.busca(categoria2.getCodigo());
		LOGGER.info("retorno :" + categoria2.getCodigo());

		categoria1.setDescricao("categoria1 update");
		categoria1 = daoCategoria.atualiza(categoria1);

		categoria2.setDescricao("categoria2 update");
		categoria2 = daoCategoria.atualiza(categoria2);

		// 2 Entidade Blog
		Blog blog1 = new Blog();
		blog1.setCategoria(categoria2);
		blog1.setConteudo("conteúdo teste");
		blog1.setDtevento(new Date());
		blog1.setPublicar(0);
		blog1.setTitulo("titulo");
		
		daoBlog.adiciona(blog1);

		blog1 = daoBlog.busca(blog1.getCodigo());
		LOGGER.info("retorno:" + blog1.getTitulo());

		blog1.setConteudo("conteúdo teste update");
		blog1.setDtevento(new Date());
		blog1.setPublicar(0);
		blog1.setTitulo("título update");

		daoBlog.atualiza(blog1);

		blog1 = daoBlog.busca(blog1.getCodigo());
		LOGGER.info("retorno:" + blog1.getTitulo());

		// tratar a flag publicar - camada de apresentacao
		LOGGER.info("flag a ser exibida na camada de apresentacao:" + blog1.getFlPublicar());

		daoBlog.remove(blog1);
		daoCategoria.remove(categoria1);
		daoCategoria.remove(categoria2);

		LOGGER.info("delete:" + blog1.getTitulo());

	}
}