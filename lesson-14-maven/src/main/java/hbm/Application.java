package hbm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
	public static void main(String[] args) {
		//Configuration configuration = new Configuration();
		//configuration.configure("hibernate.cnfg.xml");

		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		//		.applySettings(configuration.getProperties()).build();

		//SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		//Session session = factory.openSession();

		//Transaction transaction = session.beginTransaction();
		//Item item = new Item(55);
		//Item item2 = new Item(100);
		//Item item3 = new Item(8);
		//Item item4 = new Item(4215);
		//session.persist(item);
		//session.persist(item2);
		//session.persist(item3);
		//session.persist(item4);
		//transaction.commit();
		//session.close();
		
		addCart(5, "a", 1, 2, 3, 4);
		
	}
	
	public static void addCart(Integer total, String name, Integer itemId, Integer itemId2, Integer itemId3, Integer itemId4) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cnfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Item item1 = (Item) session.get(Item.class, itemId);
		Item item2 = (Item) session.get(Item.class, itemId2);
		Item item3 = (Item) session.get(Item.class, itemId3);
		Item item4 = (Item) session.get(Item.class, itemId4);
		
		Set<Item> items = new HashSet<Item>(Arrays.asList(item1, item2, item3, item4));
		
		Cart cart = new Cart(total, name, items);
		session.persist(cart);
		
		transaction.commit();
		session.close();
	}

}
