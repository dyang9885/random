package edu.usc.csci310.project.security;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;

@Converter
@Component
public class CryptoConverter implements AttributeConverter<String, String> {

    private static final String AES = "AES";
    public Key key;
    public Cipher cipher;

    @Value("${app.encryption.secret}")
    public String secret;

    @PostConstruct
    public void init() throws Exception {
        key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), AES);
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    }
}
