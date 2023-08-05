/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import entities.Empleado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author ROZER
 */
public class Consulta {

    public static void main(String[] args) {

	//Abrimos sesión con hibernate
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = session.beginTransaction();

	//Creamos la consulta
//	String hql = "select emp.nomEmp, emp.salario, emp.departamento.codDepto "
//		+ "from Empleado emp where emp.salario>1000";
	String hql = "from Empleado where salario > 1000";
	Query hqlConsulta = session.createQuery(hql);
	List<Empleado> listaEmpleados = hqlConsulta.list();

	tx.commit();
	session.close();//No cierra la sesion
	HibernateUtil.getSessionFactory().close();//Forma para cerrar sesión

	for (Empleado listaEmpleado : listaEmpleados) {

	    System.out.printf("Nombre: %-20s", listaEmpleado.getNomEmp());
	    System.out.printf("Salario: %5.2f ", listaEmpleado.getSalario());

	    /*
	    Generamos el try/catch para evitar los posibles problemas que podemos encontrar si un 
	    valor de la lista es nulo
	     */
	    try {
		System.out.printf("Departamento: %s\n", listaEmpleado.getDepartamento().getCodDepto());
	    } catch (Exception ex) {
		System.out.println("Departamento: null");
	    }
	}

    }

}
