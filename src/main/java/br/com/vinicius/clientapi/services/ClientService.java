package br.com.vinicius.clientapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.clientapi.dtos.ClientDTO;
import br.com.vinicius.clientapi.entities.ClientEntity;
import br.com.vinicius.clientapi.repositories.ClientRepository;
import br.com.vinicius.clientapi.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<ClientEntity> clients = clientRepository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
	}

	public ClientDTO findById(Long id) {
		Optional<ClientEntity> result = clientRepository.findById(id);
		ClientEntity entity = result.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return  new ClientDTO(entity);
	}
}
