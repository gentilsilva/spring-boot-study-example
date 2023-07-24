package br.com.gentil.api.studyexample;

public record NewCustomerRequest(
        String name,
        String email,
        Integer age
) {
}
