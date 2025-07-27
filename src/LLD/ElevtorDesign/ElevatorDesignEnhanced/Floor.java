package LLD.ElevtorDesign.ElevatorDesignEnhanced;

import LLD.ElevtorDesign.ElevatorDesignEnhanced.ExternalRequest.ExternalButton;

public class Floor {
    private ExternalButton externalButton;

    public Floor(ExternalButton externalButton) {
        this.externalButton = externalButton;
    }

    public ExternalButton getExternalButton() {
        return externalButton;
    }

    public void setExternalButton(ExternalButton externalButton) {
        this.externalButton = externalButton;
    }
}
