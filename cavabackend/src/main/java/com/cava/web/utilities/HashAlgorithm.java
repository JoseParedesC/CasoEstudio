package com.cava.web.utilities;

public enum HashAlgorithm {
	 /**
     * String representation of PBKDF2WithHmacMD5 algorithm
     */
    PBKDF2WITHHMACMD5("PBKDF2WithHmacMD5"),
    
    /**
     * String representation of PBKDF2WithHmacSHA1 algorithm
     */
    PBKDF2WITHHMACSHA1("PBKDF2WithHmacSHA1"),
    
    /**
     * String representation of PBKDF2WithHmacSHA224 algorithm
     */
    PBKDF2WITHHMACSHA224("PBKDF2WithHmacSHA224"),
    
    /**
     * String representation of PBKDF2WithHmacSHA256 algorithm
     */
    PBKDF2WITHHMACSHA256("PBKDF2WithHmacSHA256"),
    
    /**
     * String representation of PBKDF2WithHmacSHA384 algorithm
     */
    PBKDF2WITHHMACSHA384("PBKDF2WithHmacSHA384"),
    
    /**
     * String representation of PBKDF2WithHmacSHA512 algorithm
     */
    PBKDF2WITHHMACSHA512("PBKDF2WithHmacSHA512");
    
    private HashAlgorithm(String s) {
        this.algorithm = s;
    }
  
    private String algorithm;
    
    /**
     * Getter method to get the string value of enum constant
     * 
     * @return String value of hash algorithm
     */
    public String getAlgorithm() {
        return this.algorithm;
    }
}