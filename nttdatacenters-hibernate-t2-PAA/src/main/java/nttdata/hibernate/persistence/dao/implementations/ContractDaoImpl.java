package nttdata.hibernate.persistence.dao.implementations;

import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.ContractDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** 
    * Conexion a Base de Datos.
    */
	private Session session;

	/**
	 * Metodo constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByClientId(final Client client) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Contract WHERE client = " + client.getId()).list();

	}
}
