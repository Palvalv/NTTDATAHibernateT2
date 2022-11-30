package nttdata.hibernate.services.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;

public interface ContractManagementServiceI {
	/**
	 * Insertar nuevo contrato.
	 * @param nuevoContrato
	 */
	public void insertNewContract(final Contract nuevoContrato);

	/**
	 * Actualizar contrato.
	 * @param actualizarContrato
	 */
	public void updateContract(final Contract actualizarContrato);

	/**
	 * Eliminar contrato.
	 * @param eliminarContrato
	 */
	public void deleteContract(final Contract eliminarContrato);

	/**
	 * Obtener contrato por ID.
	 * @param contractID
	 */
	public Contract searchById(final Long contractID);

	/**
	 * Obtener total de contratos.
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

	/**
	 * Obtener contrato por clienteID.
	 * @param clienteID
	 * @return List<Contract>
	 */
	public List<Contract> searchByClientId(final Client client);
}
