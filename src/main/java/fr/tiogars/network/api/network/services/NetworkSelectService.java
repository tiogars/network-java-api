package fr.tiogars.network.api.network.services;

import org.springframework.stereotype.Service;

import fr.tiogars.architecture.select.services.AbstractSelectService;
import fr.tiogars.network.Network;
import fr.tiogars.network.api.network.entities.NetworkEntity;
import fr.tiogars.network.api.network.repository.NetworkRepository;

@Service
public class NetworkSelectService
        extends AbstractSelectService<NetworkEntity, Network, NetworkSelectOption, NetworkRepository> {

    public NetworkSelectService(NetworkRepository repository) {
        super(repository);
    }

    @Override
    protected Iterable<NetworkEntity> findAll() {
        return repository.findAll();
    }

    @Override
    protected Iterable<NetworkEntity> findBy(String name) {
        return repository.findByName(name);
    }

    @Override
    protected Iterable<NetworkEntity> findByCode(String code) {
        throw new UnsupportedOperationException("Unimplemented method 'findByCode'");
    }

    @Override
    public Network toModel(NetworkEntity entity) {
        Network network = new Network();
        network.setId(entity.getId());
        network.setName(entity.getName());
        return network;
    }

    @Override
    public NetworkSelectOption toSelectOptions(Network network) {
        NetworkSelectOption option = new NetworkSelectOption(network.getId(), network.getName(), false);
        return option;
    }
}
