package br.guirre.WalletAPI.core.useCase;

import br.guirre.WalletAPI.core.domain.Wallet;
import br.guirre.WalletAPI.core.port.in.CreateWalletCase;
import br.guirre.WalletAPI.core.port.in.CreateWalletCommand;
import br.guirre.WalletAPI.core.port.out.SaveWalletPort;

public class CreateWalletHandler implements CreateWalletCase {
    private final SaveWalletPort saveWalletPort;

    public CreateWalletHandler(SaveWalletPort saveWalletPort) {
        this.saveWalletPort = saveWalletPort;
    }

    @Override
    public Wallet execute(CreateWalletCommand command) {
        Wallet wallet = Wallet.create(command.ownerId(), command.currency());
        return saveWalletPort.save(wallet);
    }
}
