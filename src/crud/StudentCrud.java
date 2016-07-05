package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Student;
import utils.PersistenceUtil;

public class StudentCrud {

	public List<Student> getLista() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Student> s = em.createQuery("select s from Student s").getResultList();
		return s;
	}

	public void insertStudent(Student s) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(s);
			em.flush();
			et.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (et != null) {
				et.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void updateStudent(Student s) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.merge(s);
			em.flush();
			et.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (et != null) {
				et.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void deleteStudent(Student s) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Student temp = em.merge(s);
			em.remove(temp);
			em.flush();
			et.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (et != null) {
				et.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public Student findStudent(int id){
		EntityManager em = PersistenceUtil.getEntityManager();
		Student stud = em.find(Student.class, id);
		em.close();
		return stud;
	}
}
