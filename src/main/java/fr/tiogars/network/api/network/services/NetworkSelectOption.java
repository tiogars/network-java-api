package fr.tiogars.network.api.network.services;

import fr.tiogars.architecture.select.models.AbstractSelectOption;

public class NetworkSelectOption extends AbstractSelectOption {

    /**
     * Default constructor
     */
    public NetworkSelectOption(Long id, String label, boolean selected) {
        super(id, label, selected);
    }
}