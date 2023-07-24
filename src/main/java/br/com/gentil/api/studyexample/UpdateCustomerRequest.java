package br.com.gentil.api.studyexample;

public record UpdateCustomerRequest(
        Long id,
        String name,
        String email,
        Integer age
) {
}
