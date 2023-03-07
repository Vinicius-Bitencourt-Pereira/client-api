package br.com.vinicius.clientapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.clientapi.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

}
