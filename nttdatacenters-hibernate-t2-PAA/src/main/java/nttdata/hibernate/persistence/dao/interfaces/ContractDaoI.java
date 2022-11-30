package nttdata.hibernate.persistence.dao.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;

public interface ContractDaoI extends CommonDaoI<Contract>{
	
	/**
	 * Obetener contratos ID de cliente.
	 * @param Long clientID
	 * @return List<Contract>
	 */
	public List<Contract> searchByClientId(final Client client);
}

