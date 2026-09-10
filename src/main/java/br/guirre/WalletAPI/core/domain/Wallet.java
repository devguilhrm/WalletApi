package br.guirre.WalletAPI.core.domain;

import java.time.OffsetDateTime;
import java.util.Currency;
import java.util.UUID;

public final class Wallet {
    private WalletId id;
    private OwnerId ownerId;
    private Currency currency;
    private WalletStatus status;
    private long version;
    private OffsetDateTime createdAt;
    private OffsetDateTime closedAt;


    private Wallet(OwnerId ownerId, WalletId id, Currency currency, WalletStatus status,
                   long version, OffsetDateTime createdAt, OffsetDateTime closedAt) {
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
                WalletStatus.ACTIVE, 0L, OffsetDateTime.now(), null);
    }

    public static Wallet restore(WalletId id, OwnerId ownerId, Currency currency, WalletStatus status,
                                 long version, OffsetDateTime createdAt, OffsetDateTime closedAt) {
        return new Wallet(ownerId, id, currency, status, version, createdAt, closedAt);
    }


    public WalletId getId() { return id; }
    public OwnerId getOwnerId() { return ownerId; }
    public Currency getCurrency() { return currency; }
    public WalletStatus getStatus() { return status; }
    public long getVersion() { return version; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getClosedAt() { return closedAt; }
}
