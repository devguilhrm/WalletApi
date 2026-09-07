package br.guirre.WalletAPI.core.port.out;

import br.guirre.WalletAPI.core.domain.Wallet;

public interface SaveWalletPort {
    Wallet save(Wallet wallet);
}
