package fr.tiogars.network.api.network.services;

import org.springframework.stereotype.Service;

import fr.tiogars.architecture.create.services.AbstractCreateService;
import fr.tiogars.network.Network;
import fr.tiogars.network.api.network.entities.NetworkEntity;
import fr.tiogars.network.api.network.forms.NetworkCreateForm;
import fr.tiogars.network.api.network.repository.NetworkRepository;

@Service
public class NetworkCreationService
        extends AbstractCreateService<NetworkCreateForm, NetworkEntity, Network, NetworkRepository> {

    public NetworkCreationService(NetworkRepository repository) {
        super(repository);
    }

    @Override
    public NetworkEntity toEntity(Network network) {
        NetworkEntity entity = new NetworkEntity();
        entity.setName(network.getName());
        return entity;
    }

    @Override
    public Network toModel(NetworkEntity networkEntity) {
        Network model = new Network();
        model.setId(networkEntity.getId());
        model.setName(networkEntity.getName());
        return model;
    }

    @Override
    public Network toModel(NetworkCreateForm networkCreateForm) {
        Network model = new Network();
        model.setName(networkCreateForm.getName());
        return model;
    }

    @Override
    public void validate(Network network) {

        // Nothing to validate
    }

}
