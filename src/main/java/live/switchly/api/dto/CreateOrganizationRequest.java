package live.switchly.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateOrganizationRequest(@NotBlank String name) {}

//{"id":"2bf5af8b-13b2-4bcb-be27-4d323ba06590","name":"Zomato"}