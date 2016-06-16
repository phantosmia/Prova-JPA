package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id 
	@GeneratedValue 
	private int id;
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	} 
	@ManyToMany
	@ElementCollection(targetClass=Comentario.class)
	@JoinTable(name="layout_site")
	private List<Comentario> comentarios;
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Post(){
		comentarios = new ArrayList<Comentario>();
	}
	@ManyToOne
	private Blog blog;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataPostagem() {
		return dataPostagem;
	}
	public void setDataPostagem(String dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	private String assunto;
	private String titulo;
	private String dataPostagem;
	public void addComentario(Comentario comentario){
		 comentarios.add(comentario);
	}
	public Blog getBlog(){
		return blog;
	}
}
