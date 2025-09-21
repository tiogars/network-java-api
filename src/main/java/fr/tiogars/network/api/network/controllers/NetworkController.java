package fr.tiogars.network.api.network.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tiogars.network.Network;
import fr.tiogars.network.api.network.forms.NetworkCreateForm;
import fr.tiogars.network.api.network.services.NetworkCreationService;

@RestController
@RequestMapping("/network")
public class NetworkController {

    private final NetworkCreationService networkCreationService;

    public NetworkController(NetworkCreationService networkCreationService) {
        this.networkCreationService = networkCreationService;
    }

    @PostMapping
    public ResponseEntity<Network> createNetwork(@RequestBody NetworkCreateForm form) {
        Network createdNetwork = networkCreationService.create(form);
        return ResponseEntity.ok(createdNetwork);
    }
}
