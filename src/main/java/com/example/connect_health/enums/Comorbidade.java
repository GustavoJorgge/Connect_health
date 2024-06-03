package com.example.connect_health.enums;

public enum Comorbidade {
    HIPERTENSAO("Hipertensão"),
    DIABETES("Diabetes"),
    DOENCAS_CARDIACAS("Doenças Cardíacas"),
    OBESIDADE("Obesidade"),
    DOENCAS_RESPIRATORIAS("Doenças Respiratórias"),
    DEPRESSAO("Depressão"),
    ANSIEDADE("Ansiedade"),
    DOENCAS_OSTEOMUSCULARES("Doenças Osteomusculares"),
    TUBERCULOSE("Tuberculose"),
    HEPATITES_VIRAIS("Hepatites Virais"),
    OUTROS("Outros");

    private final String displayName;

    Comorbidade(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
