package com.adrianodts.springframework.factorybeans.enumerator;

import java.util.Arrays;

public enum Language {

    ENGLISH("en"),
    PORTUGUESE("pt"),
    SPANISH("es");

    private String mnemonic;

    Language(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public static Language of(String languageMnemonic) throws Exception {
        return Arrays.stream(Language.values())
            .filter(language -> language.getMnemonic().equals(languageMnemonic)).findFirst().orElseThrow(() -> new Exception("Enum value not found"));
    }
    
}
