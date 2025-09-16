package it.petraccino.hroauth.utility;

import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

public final class Jwks {
    Jwks() {}

    public static RSAKey generateRsa() {
        try {
            return new RSAKeyGenerator(2048)
                    .keyID(java.util.UUID.randomUUID().toString())
                    .algorithm(com.nimbusds.jose.JWSAlgorithm.RS256)
                    .generate();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to generate RSA JWK", e);
        }
    }
}
