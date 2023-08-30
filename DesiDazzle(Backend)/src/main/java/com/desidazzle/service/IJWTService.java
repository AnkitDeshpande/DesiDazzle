package com.desidazzle.service;

import com.desidazzle.model.Customer;

/**
 * Interface for generating and processing JSON Web Tokens (JWT).
 */
public interface IJWTService {

	/**
	 * Generates a JWT for the given user.
	 *
	 * @param user The user for whom the JWT is generated.
	 * @return The generated JWT.
	 */
	String generateJWT(Customer user);

	/**
	 * Extracts the username from the given JWT token.
	 *
	 * @param token The JWT token.
	 * @return The extracted username.
	 */
	String getUsername(String token);

}
