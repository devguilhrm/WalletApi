package br.guirre.WalletAPI.core.port.in;

import br.guirre.WalletAPI.core.domain.OwnerId;

import java.util.Currency;
import java.util.Objects;

public record CreateWalletCommand(OwnerId ownerId, Currency currency) {
    public CreateWalletCommand {
        Objects.requireNonNull(ownerId);
        Objects.requireNonNull(currency);
    }
}
