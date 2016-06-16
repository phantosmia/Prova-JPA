package entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Blogs")
public class Blog {
	@Id 
	@GeneratedValue 
	private int id;
	@OneToMany(mappedBy="blog")
	private List<Post> posts;
	public Blog(){
		posts = new ArrayList();
	}
	//@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="blog")
	public List<Post> getPost() {
		return posts;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	private String titulo;
	private String autor;
	public void adicionarPost(Post post){
		post.setBlog(this);
		posts.add(post);
	}
	
}
