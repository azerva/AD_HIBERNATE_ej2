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
public class Update {

    public static void main(String[] args) {

	//Abrimos la sesión con hibernate
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = session.beginTransaction();

	//Inicializamos la query localizar al empleado A22
	String hql = "from Empleado where codEmp='A22'";

	Query hqlUpdate = session.createQuery(hql);
	//Modificamos el salario del empleado
	Empleado emp = (Empleado) hqlUpdate.uniqueResult();
	emp.setSalario(2500f);

	//Guardamos los datos y cerramos la sesión
	session.save(emp);
	tx.commit();
	HibernateUtil.getSessionFactory().close();
    }

}
