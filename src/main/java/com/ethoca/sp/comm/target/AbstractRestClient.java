package com.ethoca.sp.comm.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 *
 */
public abstract class AbstractRestClient<D> {
    @Autowired
    private RestTemplate restTemplate;

    private String resouceUrl;

    public String getResouceUrl() {
        return resouceUrl;
    }

    public void setResouceUrl(String resouceUrl) {
        this.resouceUrl = resouceUrl;
    }

    public AbstractRestClient(String resouceUrl) {
        setResouceUrl(resouceUrl);
    }

    public AbstractRestClient() {
        throw new AssertionError();
    }

    protected URI composeTargetUri(String targetUrl, Object... uriVariableValues) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
            .fromUriString(targetUrl);
        //
        UriComponents uriComponents = uriBuilder.build();
        return uriComponents.expand(uriVariableValues).toUri();
    }

    protected List<D> getAll(URI targetUri) {
        ResponseEntity<List<D>> responseEntity = restTemplate.exchange(
            targetUri,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<D>>() {
            });
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed for get all");
        }
    }

    protected D get(URI targetUri, Class<D> clazz) {
        ResponseEntity<D> responseEntity = restTemplate.exchange(
            targetUri,
            HttpMethod.GET,
            null,
            clazz
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed for get");
        }
    }

    protected D post(URI targetUri, Class<D> clazz, D body) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<D> responseEntity = restTemplate.exchange(
            targetUri,
            HttpMethod.POST,
            new HttpEntity(body, headers),
            clazz
        );
        if (responseEntity.getStatusCode() == HttpStatus.CREATED ||
            responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed for post");
        }
    }

    protected D put(URI targetUri, Class<D> clazz) {
        ResponseEntity<D> responseEntity = restTemplate.exchange(
            targetUri,
            HttpMethod.PUT,
            null,
            clazz
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed for put");
        }
    }

    protected void delete(URI targetUri) {
        restTemplate.delete(targetUri);
    }
}
