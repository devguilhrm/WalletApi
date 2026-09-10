package br.guirre.WalletAPI.core.port.in;

import br.guirre.WalletAPI.core.domain.OwnerId;

import java.util.Currency;

public record CreateWalletCommand(OwnerId ownerId, Currency currency) { }
