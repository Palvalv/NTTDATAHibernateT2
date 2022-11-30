package nttdata.hibernate.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.implementations.ContractDaoImpl;
import nttdata.hibernate.persistence.dao.interfaces.ContractDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;
import nttdata.hibernate.services.interfaces.ContractManagementServiceI;

public class ContractManagementServiceImpl implements ContractManagementServiceI {

	private ContractDaoI contractDao;

	/**
	 * Metodo constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract nuevoContrato) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (nuevoContrato != null && nuevoContrato.getId() == null) {

		/**
		 * Insertar nuevo contrato.
		 */
			contractDao.insert(nuevoContrato);
		}

	}

	@Override
	public void updateContract(Contract actualizarContrato) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (actualizarContrato != null && actualizarContrato.getId() != null) {

		/**
		 * Actualizar contrato.
		 */
			contractDao.update(actualizarContrato);
		}

	}

	@Override
	public void deleteContract(Contract eliminarContrato) {
		
		/**
		 * Comprobacion de existencia y nulidad.
		 */
		if (eliminarContrato != null && eliminarContrato.getId() != null) {

		/**
		 * Eliminar cliente.
		 */
			contractDao.delete(eliminarContrato);
		}

	}

	@Override
	public Contract searchById(Long contractID) {
		
		Contract contrato = null;

		/**
		 * Comprobacion de nulidad.
		 */
		if (contractID != null) {

		/**
		 * Localizacion contrato por ID.
		 */
			contrato = contractDao.searchById(contractID);
		}

		return contrato;
	}

	@Override
	public List<Contract> searchAll() {
		
		List<Contract> listaContrato = new ArrayList<>();

		/**
		 * Localizacion de contratos.
		 */
		listaContrato = contractDao.searchAll();

		return listaContrato;
	}

	@Override
	public List<Contract> searchByClientId(Client cliente) {
		
		List<Contract> listaContrato = new ArrayList<>();

		/**
		 * Comprobacion de nulidad.
		 */
		if (cliente != null) {

		/**
		* Localizacion de contratos por ID de cliente.
	    */
			listaContrato = contractDao.searchByClientId(cliente);
		}

		return listaContrato;
	}

}