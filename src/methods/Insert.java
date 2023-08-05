/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import entities.Departamento;
import entities.Empleado;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author ROZER
 */
public class Insert {

    public static void main(String[] args) {

	try ( //Abrimos conexión y sesion en hibernate
		Session session = HibernateUtil.getSessionFactory().openSession()) {
	    Transaction tx = session.beginTransaction();
	    
	    //Creamos un objeto Date para asignar la fecha actual en el que se da de alta al empleado
	    Date date = new Date();
	    
	    //Creamos un empleado para asignar un código de empleado sobre el cargo que ocupa dicho empleado
	    Empleado codJefe = new Empleado();
	    codJefe.setCodEmp("A11");
	    //Creamos un nuevo departamento para agregar el código del departamento a dicho empleado
	    Departamento dep = new Departamento();
	    dep.setCodDepto("01");
	    
	    //Creamos el nuevo empleado y añadimos sus datos
	    Empleado emp = new Empleado();
	    emp.setCodEmp("A22");
	    emp.setNomEmp("Pepe García");
	    emp.setFechaIngreso(date);
	    emp.setSalario(2000f);
	    emp.setEmpleado(codJefe);
	    emp.setDepartamento(dep);
	    
	    //Guardamos el empleado creado y cerramos la sesión
	    session.save(emp);
	    tx.commit();
	    HibernateUtil.getSessionFactory().close();
	}

    }

}
