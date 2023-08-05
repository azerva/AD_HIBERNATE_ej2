/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import entities.Empleado;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author ROZER
 */
public class Delete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	try ( //Abrimos sesión con hibernate
		Session session = HibernateUtil.getSessionFactory().openSession()) {
	    Transaction tx = session.beginTransaction();

	    //Creamos la consulta para eliminar un Empleado
	    String hql = "from Empleado where codEmp='A22'";
	    Query hqlDelete = session.createQuery(hql);

	    Empleado emp = (Empleado) hqlDelete.uniqueResult();

	    session.delete(emp);//Eliminamos al empleado
	    tx.commit();
	    HibernateUtil.getSessionFactory().close();

	}
    }

}
