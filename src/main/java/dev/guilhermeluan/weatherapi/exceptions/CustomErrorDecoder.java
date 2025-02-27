package dev.guilhermeluan.weatherapi.exceptions;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        String errorMessage = null;
        try {
            errorMessage = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error");
        }

        return switch (response.status()) {
            case 400 -> new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
            case 401 -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, errorMessage);
            case 404 -> new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
            case 429 -> new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, errorMessage);
            default -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
        };
    }
}