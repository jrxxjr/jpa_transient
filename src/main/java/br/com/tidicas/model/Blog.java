package br.com.tidicas.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe correspondente a tabela blog do banco de dados
 * 
 * @author Evaldo Junior
 *
 */
@Entity
@Table(name = "blog")
public class Blog implements Serializable {

	private static final long serialVersionUID = 7551953961461778499L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer codigo;
	private String conteudo;

	@Column(length = 20)
	private String titulo;

	@Temporal(TemporalType.DATE)
	private Date dtevento;
	private Integer contador;
	private Integer publicar;
		
	private transient Boolean flPublicar = false;

	@OneToOne(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "blog")
	private Categoria categoria;

	public Blog() {

	}

	public Blog(String conteudo, String titulo, Date dtevento, Integer contador, Integer publicar, boolean flPublicar,
			Categoria categoria) {

		this.conteudo = conteudo;
		this.titulo = titulo;
		this.dtevento = dtevento;
		this.contador = contador;
		this.publicar = publicar;
		this.flPublicar = flPublicar;
		this.categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDtevento() {
		return dtevento;
	}

	public void setDtevento(Date dtevento) {
		this.dtevento = dtevento;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Integer getPublicar() {
		return publicar;
	}

	public void setPublicar(Integer publicar) {
		this.publicar = publicar;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getFlPublicar() {
		flPublicar = false;		
		if (publicar != null) {
			if (publicar == 1) {
				flPublicar = true;
			}
		}
		return flPublicar;
	}

	public void setFlPublicar(Boolean flPublicar) {
		this.flPublicar = flPublicar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((contador == null) ? 0 : contador.hashCode());
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((dtevento == null) ? 0 : dtevento.hashCode());
		result = prime * result + (flPublicar ? 1231 : 1237);
		result = prime * result + ((publicar == null) ? 0 : publicar.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (contador == null) {
			if (other.contador != null)
				return false;
		} else if (!contador.equals(other.contador))
			return false;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (dtevento == null) {
			if (other.dtevento != null)
				return false;
		} else if (!dtevento.equals(other.dtevento))
			return false;
		if (flPublicar != other.flPublicar)
			return false;
		if (publicar == null) {
			if (other.publicar != null)
				return false;
		} else if (!publicar.equals(other.publicar))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}