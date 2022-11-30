package nttdata.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;
import nttdata.hibernate.services.implementations.ClienteManagementServiceImpl;
import nttdata.hibernate.services.implementations.ContractManagementServiceImpl;
import nttdata.hibernate.services.interfaces.ClienteManagementServiceI;
import nttdata.hibernate.services.interfaces.ContractManagementServiceI;

public class MainApp {
	
	public static void main(String[] args) {
		
		/** 
		 * La sesión se abre.
		 */
		final Session session = HibernateUtil.getSessionFactory().openSession();

		/** 
		 * Los servicios se inicializan.
		 */
		final ClienteManagementServiceI clientService = new ClienteManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		/**
		 * El cliente de muestra se evalúa.
		 */
		final String updatedUser = "PABLOAA";
		final Date updatedDate = new Date();
		
		/**
		 * Cliente de muestra 1.
		 */
		Client clientemuestra1 = new Client();
		clientemuestra1.setDni("11111111X");
		clientemuestra1.setName("Yassine");
		clientemuestra1.setSurname("Bounou");
		clientemuestra1.setUpdatedUser(updatedUser);
		clientemuestra1.setUpdatedDate(updatedDate);
		
		/**
		 * Cliente de muestra 2.
		 */
		Client clientemuestra2 = new Client();
		clientemuestra2.setDni("25252525Y");
		clientemuestra2.setName("Fernando");
		clientemuestra2.setSurname("Reges");
		clientemuestra2.setUpdatedUser(updatedUser);
		clientemuestra2.setUpdatedDate(updatedDate);
		
		/**
		 * Contrato de muestra 1.
		 */
		final Contract contrato1 = new Contract();
		contrato1.setClient(clientemuestra1);
		contrato1.setExpirationDate("2025-05-05");
		contrato1.setValidatyDate("2014-06-06");
		contrato1.setPriceMonth(10.8);
		contrato1.setUpdatedDate(updatedDate);
		contrato1.setUpdatedUser(updatedUser);
		
		/**
		 * Contrato de muestra 2.
		 */
		final Contract contrato2 = new Contract();
		contrato2.setClient(clientemuestra1);
		contrato2.setExpirationDate("2025-05-05");
		contrato2.setValidatyDate("2014-06-06");
		contrato2.setPriceMonth(12.9);
		contrato2.setUpdatedDate(updatedDate);
		contrato2.setUpdatedUser(updatedUser);
		
		/**
		 * Contrato de muestra 3.
		 */
		final Contract contrato3 = new Contract();
		contrato3.setClient(clientemuestra1);
		contrato3.setExpirationDate("2025-05-05");
		contrato3.setValidatyDate("2014-06-06");
		contrato3.setPriceMonth(14.5);
		contrato3.setUpdatedDate(updatedDate);
		contrato3.setUpdatedUser(updatedUser);
		
		/**
		 * Insertar contratos.
		 */
		contractService.insertNewContract(contrato1);
		contractService.insertNewContract(contrato2);
		contractService.insertNewContract(contrato3);
		
		/**
		 * Cliente1 lista de contratos.
		 */
		final List<Contract> contracts = new ArrayList<>();
		contracts.add(contrato1);
		contracts.add(contrato2);
				
		/**
		 * Fijar contratos a cliente1.
		 */
		clientemuestra1.setContracts(contracts);	
			
		/**
		 * Añadimos clientes.
		 */
		clientemuestra1 = clientService.insertNewCliente(clientemuestra1);
		clientemuestra2 = clientService.insertNewCliente(clientemuestra2);	
		
		/**
		 * Cambiamos cliente2.
		 */
		clientemuestra2.setName("NombreAsignado");
		clientService.updateCliente(clientemuestra2);
		
		/**
		 * Consultas de clientes con JPA Criteria.
		 */
		List<Client> clients = clientService.searchByNameAndSurname("Yassine Bounou", "B%");

		System.out.println("Clientes: ");
		for (final Client client : clients) {
			System.out.println(client.getName() + ", " + client.getSurname() + ", " + client.getDni());
		}
		System.out.println();
		
		List<Client> clients2 = clientService.searchAll();

		System.out.println("Total de clientes: ");
		for (final Client client : clients2) {
			System.out.println(client.getName() + ", " + client.getSurname() + ", " + client.getDni());
		}
		
		System.out.println("Cliente ID 1: ");
		Client clients3 = clientService.searchById(1L);
		System.out.println(clients3.toString());
		
		/**
		 * Consultas de contratos con JPA Criteria.
		 */
		List<Contract> contracts2 = contractService.searchByClientId(clientemuestra1);
		
		System.out.println("Contratos cliente 1: ");
		for (final Contract contract : contracts2) {
			System.out.println(contract.getId() + ", " + contract.getExpirationDate() + ", " + contract.getValidatyDate());
		
		/**
		 * La sesion se cierra.
		 */
		session.close();
	    }
	}
}
