package br.guirre.WalletAPI.core.domain;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

public final class Wallet {
    private WalletId id;
    private OwnerId ownerId;
    private Currency currency;
    private WalletStatus status;
    private long version;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;


    private Wallet(OwnerId ownerId, WalletId id, Currency currency, WalletStatus status,
                   long version, LocalDateTime createdAt, LocalDateTime closedAt) {
        this.ownerId = ownerId;
        this.id = id;
        this.currency = currency;
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
    }


    public static Wallet create(OwnerId ownerId, Currency currency) {
        return new Wallet(ownerId, new WalletId(UUID.randomUUID()), currency,
                WalletStatus.ACTIVE, 0L, LocalDateTime.now(), null);
    }

    public static Wallet restore(WalletId id, OwnerId ownerId, Currency currency, WalletStatus status,
                                 long version, LocalDateTime createdAt, LocalDateTime closedAt) {
        return new Wallet(ownerId, id, currency, status, version, createdAt, closedAt);
    }


    public WalletId getId() { return id; }
    public OwnerId getOwnerId() { return ownerId; }
    public Currency getCurrency() { return currency; }
    public WalletStatus getStatus() { return status; }
    public long getVersion() { return version; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getClosedAt() { return closedAt; }
}
