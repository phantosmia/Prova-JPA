package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Blog;
import entities.Comentario;
import entities.Post;

public class testeBlog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prova2");
		EntityManager em = factory.createEntityManager();
		Blog b = new Blog();
		Blog b1 = new Blog();
		Blog b2 = new Blog();
		Blog b3 = new Blog();
		Blog b4 = new Blog();
		b.setAutor("Rakel Natali");
		b.setTitulo("Programando em Java");
		b1.setAutor("Rita Amelia");
		b1.setTitulo("Cozinhando que nem um master chef");
		b2.setAutor("Lucas Rogerio");
		b2.setTitulo("A arte de observar a lua");
		b3.setAutor("Regina Peretti");
		b3.setTitulo("Trabalhando com Costura");
		b4.setAutor("Marcos Bustamante");
		b4.setTitulo("Como gabaritar a Maratona");
		Post p = new Post();
		Comentario c = new Comentario();
		Post p1 = new Post();
		Comentario c1 = new Comentario();
		Post p2 = new Post();
		Comentario c2 = new Comentario();
		Post p3 = new Post();
		Comentario c3 = new Comentario();
		Post p4 = new Post();
		Comentario c4 = new Comentario();
		p.setBlog(b);
		p.setAssunto("Gostaria de iniciar este post falando que java eh um maximo");
		p.setTitulo("Primeiro post do blog");
		p.setDataPostagem("14/06/2014");
		c.setAutor("Fulaninho");
		c.setConteudo("Seu blog esta demais");
		c.setData("14/06/2014");
		p.addComentario(c);
		c.addPost(p);
		b.adicionarPost(p);
		/* -- */
		p1.setBlog(b1);
		p1.setAssunto("Como foi o meu dia hj");
		p1.setTitulo("Batman");
		p1.setDataPostagem("15/04/2016");
		c1.setAutor("Anonymous");
		c1.setConteudo("Hacking");
		c1.setData("14/06/2017");
		p1.addComentario(c1);
		c1.addPost(p1);
		b1.adicionarPost(p1);
		/* -- */
		p2.setBlog(b2);
		p2.setAssunto("Como contar ate 3 eh dificil");
		p2.setTitulo("Matematica");
		p2.setDataPostagem("12/04/2034");
		c2.setAutor("Raquel Natali");
		c2.setConteudo("Sei como eh");
		c2.setData("13/04/2034");
		p2.addComentario(c2);
		c2.addPost(p2);
		b2.adicionarPost(p2);
		/* -- */
		p3.setBlog(b3);
		p3.setAssunto("Ponto sem no");
		p3.setTitulo("Ano novo, vida nova");
		p3.setDataPostagem("14/05/2014");
		c3.setAutor("Eustacio");
		c3.setConteudo("Demais");
		c3.setData("14/05/2014");
		p3.addComentario(c3);
		c3.addPost(p3);
		b3.adicionarPost(p3);
		/* -- */
		p4.setBlog(b4);
		p4.setAssunto("As maratonas sao faceis demais");
		p4.setTitulo("Bla bla bla");
		p4.setDataPostagem("14/04/2014");
		c4.setAutor("Menina Louca");
		c4.setConteudo("Agora vou comecar a gabaritar tbm, Marcos-senpai!!");
		c4.setData("14/04/2014");
		p4.addComentario(c4);
		c4.addPost(p4);
		b4.adicionarPost(p4);
		/* -- */
		em.getTransaction().begin();
		em.persist(b);
		em.persist(p);
		em.persist(c);
		em.persist(b1);
		em.persist(p1);
		em.persist(c1);
		em.persist(b2);
		em.persist(p2);
		em.persist(c2);
		em.persist(b3);
		em.persist(p3);
		em.persist(c3);
		em.persist(b4);
		em.persist(p4);
		em.persist(c4);
		em.getTransaction().commit();
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Post> q = qb.createQuery(Post.class);
		Root<Post> root = q.from(Post.class);
		q.where(qb.equal(root.get("dataPostagem"), "14/06/2014"));
		List<Post> resultado = em.createQuery(q).getResultList();
		for(Post post: resultado){
			System.out.println(post.getAssunto());
		}
		CriteriaQuery<Blog> q1 = qb.createQuery(Blog.class);
		Root <Blog>root1 = q1.from(Blog.class);
		q1.where(qb.equal(root1.get("autor"), "Rakel Natali"));
		List<Blog> resultado1 = em.createQuery(q1).getResultList();
		for(Blog blog: resultado1){
			System.out.println(blog.getTitulo());
		}
		CriteriaQuery<Comentario> q2 = qb.createQuery(Comentario.class);
		Root <Comentario>root2 = q2.from(Comentario.class);
		q2.where(qb.equal(root2.get("autor"), "Fulaninho"));
		List<Comentario> resultado2 = em.createQuery(q2).getResultList();
		for(Comentario comentario: resultado2){
			System.out.println(comentario.getConteudo());
		}
		
	}

}
