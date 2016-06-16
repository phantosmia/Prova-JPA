package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Comentario {
public Comentario(){
	posts = new ArrayList<Post>();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}
@ManyToMany(mappedBy="comentarios")
@ElementCollection(targetClass=Post.class)
private List<Post> posts;
public String getConteudo() {
	return conteudo;
}
public void setConteudo(String conteudo) {
	this.conteudo = conteudo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public void addPost(Post post){
	posts.add(post);
}
private String autor;
private String data;
@Id 
@GeneratedValue 
private int id;
private String conteudo;
}
