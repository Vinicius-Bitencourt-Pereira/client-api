package br.com.vinicius.clientapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.clientapi.dtos.ClientDTO;
import br.com.vinicius.clientapi.entities.ClientEntity;
import br.com.vinicius.clientapi.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<ClientEntity> clients = clientRepository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
	}
}
