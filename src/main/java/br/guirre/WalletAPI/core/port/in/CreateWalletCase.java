package br.guirre.WalletAPI.core.port.in;

import br.guirre.WalletAPI.core.domain.Wallet;

import java.util.UUID;

public interface CreateWalletCase {
    Wallet execute(CreateWalletCommand command);


}
