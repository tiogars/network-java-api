package fr.tiogars.network.api.network.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tiogars.architecture.select.models.SelectRequest;
import fr.tiogars.architecture.select.models.SelectResponse;
import fr.tiogars.network.Network;
import fr.tiogars.network.api.network.forms.NetworkCreateForm;
import fr.tiogars.network.api.network.services.NetworkCreationService;
import fr.tiogars.network.api.network.services.NetworkSelectOption;
import fr.tiogars.network.api.network.services.NetworkSelectService;

@RestController
@RequestMapping("/network")
public class NetworkController {

    private final NetworkCreationService networkCreationService;

    private final NetworkSelectService networkSelectService;


    public NetworkController(NetworkCreationService networkCreationService, NetworkSelectService networkSelectService) {
        this.networkCreationService = networkCreationService;
        this.networkSelectService = networkSelectService;
    }

    @PostMapping
    public ResponseEntity<Network> createNetwork(@RequestBody NetworkCreateForm form) {
        Network createdNetwork = networkCreationService.create(form);
        return ResponseEntity.ok(createdNetwork);
    }

    @PostMapping("/select")
    public ResponseEntity<List<NetworkSelectOption>> selectNetworks(@RequestBody SelectRequest request) {
         
        SelectResponse<NetworkSelectOption> options = networkSelectService.select(request);
        return ResponseEntity.ok(options.getRows());
    }
}
