/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.learninghibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author giovanni
 */
public class App
{
    public static void main(String[] args)
    {
        Configuration config = new Configuration();
        config.configure();
        ServiceRegistry serviceReg = new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sFactory = config.buildSessionFactory(serviceReg);
        
        // Create and save message
        QuickMessage qmsg1 = new QuickMessage("Mensaje de prueba");
        QuickMessage qmsg2 = new QuickMessage("Hibernate Rocks");

        Session session = sFactory.openSession();
        session.beginTransaction();
        session.save(qmsg1);
        session.save(qmsg2);
        session.getTransaction().commit();
        
        // Retrieve Messages
        List msgs = session.createQuery("from QuickMessage").list();
        Iterator iterator = msgs.iterator();
        System.out.println("\n\n\n*** *** ***\n");
        while(iterator.hasNext())
        {
            QuickMessage qmessage = (QuickMessage) iterator.next();
            System.out.println("The message is: " + qmessage.getMsg());
        }
        System.out.println("\n\n*** *** *** \n\n\n\n\n");
        session.close();
        sFactory.close();
    }
}
