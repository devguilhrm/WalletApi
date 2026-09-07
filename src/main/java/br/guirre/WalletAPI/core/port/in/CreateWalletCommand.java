package br.guirre.WalletAPI.core.port.in;

import java.util.Currency;
import java.util.UUID;

public record CreateWalletCommand(UUID ownerId, Currency currency) { }
