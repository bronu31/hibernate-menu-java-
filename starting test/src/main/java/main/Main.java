package main;

import main.model.Menu;
import main.model.MenuItem;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Menu m1=new Menu();
        m1.setDate(new Date(20180505));
        m1.setId(1L);
        m1.setTitle("Special");
        MenuItem i1= new MenuItem();
        i1.setId(1L);
        i1.setName("Soup");
        i1.setPrice(22.22);

        MenuItem i2= new MenuItem();
        i2.setId(2L);
        i2.setName("Salad");
        i2.setPrice(12.34);

        MenuItem i3= new MenuItem();
        i3.setId(0L);
        i3.setName("Steak");
        i3.setPrice(25.78);
        m1.addItem(i1);
        m1.addItem(i2);
        m1.addItem(i3);
        session.save(m1);
        session.save(i1);
        session.save(i2);
        session.save(i3);
       /* Author a = new Author("John", "Smith", LocalDate.of(1990,02,18));
        Author a1 = new Author("Isaak", "Asimov", LocalDate.of(1920,02,18));
        Book b = new Book("I, Robot");
        Book b1 = new Book("Good book");
        b1.addAuthor(a);
        b.addAuthor(a);
        b.addAuthor(a1);
        session.save(b);
        session.save(b1);
        //System.out.println(a);
        //session.save(a);
        //System.out.println(a);
        a.setBirth(LocalDate.of(2000,12,03));
        //System.out.println(a);*/
        session.getTransaction().commit();
        session.close();
        System.out.println("OK");
        System.exit(0);
    }
}
