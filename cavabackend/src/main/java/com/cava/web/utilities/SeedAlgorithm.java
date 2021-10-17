package com.cava.web.utilities;

public enum SeedAlgorithm {
	/**
     * String representation of NativePRNG algorithm
     */
    NATIVEPRNG("NativePRNG"),

    /**
     * String representation of NativePRNGBlocking algorithm
     */
    NATIVEPRNGBLOCKING("NativePRNGBlocking"),

    /**
     * String representation of NativePRNGNonBlocking algorithm
     */
    NATIVEPRNGNonBLOCKING("NativePRNGNonBlocking"),

    /**
     * String representation of PKCS11 algorithm
     */
    PKCS11("PKCS11"),

    /**
     * String representation of SHA1PRNG algorithm
     */
    SHA1PRNG("SHA1PRNG"),

    /**
     * String representation of Windows-PRNG algorithm
     */
    WINDOWSPRNG("Windows-PRNG");
    
    private SeedAlgorithm(String s) {
        this.algorithm = s;
    }
  
    private String algorithm;
    
    /**
     * Getter method to get the string value of enum constant
     * 
     * @return String value of seed algorithm
     */
    public String getAlgorithm() {
        return this.algorithm;
    }
}