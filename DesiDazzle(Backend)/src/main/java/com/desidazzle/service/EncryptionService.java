package com.desidazzle.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class EncryptionService implements IEncryptionService {

	@Value("${encryption.salt.rounds}")
	private int saltRounds;
	private String salt;

	@PostConstruct
	public void postConstruct() {
		salt = BCrypt.gensalt(saltRounds);
	}

	@Override
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password, salt);
	}

	@Override
	public boolean verifyPassword(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
}
