package br.guirre.WalletAPI.core.domain;

import java.util.Objects;
import java.util.UUID;

public record WalletId(UUID value) {
    public WalletId {
    Objects.requireNonNull(value, "Value não pode ser nulo");
    }
}
