package com.cava.web.utilities;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import java.util.stream.IntStream;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PasswordUtil {
	
	private static final int HASH_SECTION_SIZE = 3;
    private static final int HASH_SECTION_ALGORITHM_INDEX = 0;
    private static final int HASH_SECTION_SALT_INDEX = 1;
    private static final int DEFAULT_SALT_SEED_SIZE = 16;
    private static final int DEFAULT_RANDOM_PASSWORD_LENGTH = 10;
    private static final int DEFAULT_HASH_ITERATION_COUNT = 99999;
    private static final int DEFAULT_HASH_KEY_LENGTH = 300;    
    private static final String SECTION_SEPARATOR = ":";
    private static final String ERROR_NULL_PASSWORD = "Password is null or empty!";
    private static final SeedAlgorithm DEFAULT_RANDOM_SEED_ALGORITHM = SeedAlgorithm.SHA1PRNG;
    private static final HashAlgorithm DEFAULT_HASH_ALGORITHM = HashAlgorithm.PBKDF2WITHHMACSHA256;
    private static final int LOWER_CASE_LETTER_UTF_CODE_START = 97;
    private static final int LOWER_CASE_LETTER_UTF_CODE_END = 122;
    private static final int UPPER_CASE_LETTER_UTF_CODE_START = 65;
    private static final int UPPER_CASE_LETTER_UTF_CODE_END = 90;
    private static final int DIGIT_UTF_CODE_START = 48;
    private static final int DIGIT_UTF_CODE_END = 57;
    private static final char[] SPECIAL_CHARACTER_UTF_CODE_ARRAY = { 0x0021, 0x0022, 0x0023, 0x0024, 0x0025, 0x0026,
            0x0027, 0x0028, 0x0029, 0x002A, 0x002B, 0x002C, 0x002D, 0x002E, 0x002F, 0x003A, 0x003B, 0x003C, 0x003F,
            0x0040, 0x005B, 0x005C, 0x005D, 0x005E, 0x005F, 0x0060, 0x007B, 0x007C, 0x007D, 0x007E };

    /**
     * Generates a random password of default length
     * 
     * <p>To make the generated password readable, 'space' character 
     * is excluded.</p> 
     * 
     * @return randomly generated password with default length
     */
    public static String generateRandomPassword() {
        return generateRandomPassword(DEFAULT_RANDOM_PASSWORD_LENGTH);
    }
    
    /**
     * Generates a random password with a given length
     * 
     * <p>Random passwords are created from a combination of
     * alphabet letters, numbers and special characters. To make the generated 
     * password readable, 'space' character is excluded.</p> 
     * 
     * @param length    Desired length of password
     * 
     * @return  randomly generated password  
     */
    public static String generateRandomPassword(int length) {

        // Simple order of character types for randomizing/shuffling
        final int lowerCaseLetter = 0;
        final int upperCaseLetter = 1;
        final int specialCharacter = 2;
        final int digit = 3;

        if (length <= 0) {
            length = DEFAULT_RANDOM_PASSWORD_LENGTH;
        }
        
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        IntStream stream = random.ints(length, lowerCaseLetter, digit + 1);
        stream.forEach((IntStream) -> {
            switch (IntStream) {
            case lowerCaseLetter:
                result.append(getRandomSingleCharacterFromRange(random, LOWER_CASE_LETTER_UTF_CODE_START,
                        LOWER_CASE_LETTER_UTF_CODE_END));
                break;
            case upperCaseLetter:
                result.append(getRandomSingleCharacterFromRange(random, UPPER_CASE_LETTER_UTF_CODE_START,
                        UPPER_CASE_LETTER_UTF_CODE_END));
                break;
            case digit:
                result.append(getRandomSingleCharacterFromRange(random, DIGIT_UTF_CODE_START, DIGIT_UTF_CODE_END));
                break;
            case specialCharacter:
                result.append(getRandomSpecialCharacterFromArray(random));
                break;
            }
        });
        return result.toString();
    }
    
    public static byte[] generateRandomSalt(SeedAlgorithm seedAlgorithm, final int seedSize)
            throws IllegalArgumentException {
        try {
            return SecureRandom.getInstance(seedAlgorithm.name()).generateSeed(seedSize);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    public static String hashPassword(final String rawPassword) throws IllegalArgumentException {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_PASSWORD);
        }
        return hashPassword(rawPassword, DEFAULT_HASH_ALGORITHM);
    }

    public static String hashPassword(final String rawPassword, HashAlgorithm algorithm)
            throws IllegalArgumentException {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_PASSWORD);
        }
        byte[] salt = generateRandomSalt();
        String hash = createHashedPassword(rawPassword.toCharArray(), salt, algorithm);
        return generateFormattedHash(hash, Base64.getEncoder().encodeToString(salt), algorithm);
    }

    public static boolean verifyPassword(final String rawPassword, final String hashedPassword) 
            throws IllegalArgumentException {
        if (rawPassword == null || rawPassword.isEmpty() || hashedPassword == null || hashedPassword.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_PASSWORD);
        }                
        boolean result = false;
        String[] suppliedPasswordArray = hashedPassword.split(SECTION_SEPARATOR);
        if (suppliedPasswordArray.length != HASH_SECTION_SIZE) {
            
        }
        HashAlgorithm algorithm = HashAlgorithm.valueOf(suppliedPasswordArray[HASH_SECTION_ALGORITHM_INDEX]);
        byte[] salt = Base64.getDecoder().decode(suppliedPasswordArray[HASH_SECTION_SALT_INDEX]);
        String hash = createHashedPassword(rawPassword.toCharArray(), salt, algorithm);
        String tempHashedPassword = generateFormattedHash(hash, Base64.getEncoder().encodeToString(salt), algorithm);
        if (tempHashedPassword.equals(hashedPassword)) {
            result = true;
        }
        return result;
    }
    
    private static String createHashedPassword(final char[] rawPassword, final byte[] salt, HashAlgorithm algorithm) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm.getAlgorithm());
            KeySpec keySpec = new PBEKeySpec(rawPassword, salt, DEFAULT_HASH_ITERATION_COUNT, DEFAULT_HASH_KEY_LENGTH);
            Key secretKey = keyFactory.generateSecret(keySpec);
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String generateFormattedHash(final String hash, final String salt, HashAlgorithm algorithm) {
        StringBuilder result = new StringBuilder(algorithm.name());
        result.append(SECTION_SEPARATOR).append(salt).append(SECTION_SEPARATOR).append(hash);
        return result.toString();
    }

    /**
     * Generates a salt value using the default seed size provided in this class.
     * 
     * <p>Note: To preserve consistency seed size should not be changed.</p>
     * 
     * This method uses "SHA1PRNG" algorithm to generate the salt
     * 
     * @return Base64 encoded salt value
     * 
     * @throws IllegalArgumentException
     *          If seed algorithm does not exist
     */
    private static byte[] generateRandomSalt() throws IllegalArgumentException {
        return generateRandomSalt(DEFAULT_RANDOM_SEED_ALGORITHM, DEFAULT_SALT_SEED_SIZE);
    }

    /*
     * Character range: 
     * 
     * [A to Z]  Range:
     *           hex: [0x0041 to 0x005A]
     *           dec: [65 to 90]
     *           
     * [a to z] Range: 
     *          hex: [0x0061 to 0x007A]
     *          dec: [97 to 122]
     *          
     * [0 to 9] Range:
     *          hex: [0x0030 to 0x0039]
     *          dec: [48 to 57]
     */
    private static char getRandomSingleCharacterFromRange(final Random random, final int startInclusive,
            final int endInclusive) {
        int randomValue = random.nextInt(endInclusive - startInclusive);
        // type casting is safe here, result is 100% within char range
        return (char) (randomValue + startInclusive);
    }
    
    private static char getRandomSpecialCharacterFromArray(final Random random) {
        int randomValue = random.nextInt(SPECIAL_CHARACTER_UTF_CODE_ARRAY.length);
        return SPECIAL_CHARACTER_UTF_CODE_ARRAY[randomValue];
    }
}