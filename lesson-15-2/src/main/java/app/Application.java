package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Comment;
import entity.Post;

public class Application {
	public static void main (String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();
		
		Post post = new Post();
		post.setTitle("New Post");
		
		Comment comment = new Comment();
		comment.setAuthorName("Ivan");
		comment.setPost(post);
		Comment comment2 = new Comment();
		comment2.setAuthorName("Arsen");
		comment2.setPost(post);
		
		Set<Comment> comments = new HashSet<>(Arrays.asList(comment, comment2));
		post.setComments(comments);
		
		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();
		

		Post postFromDB = (Post) session.get(Post.class, 1);
		System.out.println(postFromDB + " " + postFromDB.getComments());
		
		Comment commentFromDB = (Comment) session.get(Comment.class, 1);
		System.out.println(commentFromDB + " " + commentFromDB.getPost());
	}
}
