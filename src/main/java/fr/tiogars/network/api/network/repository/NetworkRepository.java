package fr.tiogars.network.api.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tiogars.network.api.network.entities.NetworkEntity;

public interface NetworkRepository extends JpaRepository<NetworkEntity, Long> {

}