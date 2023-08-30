package com.desidazzle.service;

/**
 * Interface for encrypting and verifying passwords.
 */
public interface IEncryptionService {

    /**
     * Encrypts the provided password using a secure hashing algorithm.
     *
     * @param password The password to encrypt.
     * @return The encrypted password.
     */
    String encryptPassword(String password);

    /**
     * Verifies whether the provided password matches the provided hash.
     *
     * @param password The password to verify.
     * @param hash     The hash to compare against.
     * @return True if the password matches the hash, false otherwise.
     */
    boolean verifyPassword(String password, String hash);

}