package br.com.vinicius.clientapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<ClientEntity> result = clientRepository.findById(id);
		ClientEntity entity = result.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return  new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		ClientEntity entity = new ClientEntity();
		copyDtoToEntity(dto, entity);
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
		
	}
	
	@Transactional
	private void copyDtoToEntity(ClientDTO dto, ClientEntity entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			ClientEntity entity = clientRepository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found" + id);
		}
	}
}
