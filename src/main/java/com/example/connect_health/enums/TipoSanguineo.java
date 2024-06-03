package com.example.connect_health.enums;

public enum TipoSanguineo {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private final String displayName;

    TipoSanguineo(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
