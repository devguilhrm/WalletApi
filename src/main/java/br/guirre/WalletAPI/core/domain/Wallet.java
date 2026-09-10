package br.guirre.WalletAPI.core.domain;

import java.time.OffsetDateTime;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public final class Wallet {
    private WalletId id;
    private OwnerId ownerId;
    private Currency currency;
    private WalletStatus status;
    private long version;
    private OffsetDateTime createdAt;
    private OffsetDateTime closedAt;


    private Wallet( WalletId id,OwnerId ownerId, Currency currency, WalletStatus status,
                   long version, OffsetDateTime createdAt, OffsetDateTime closedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.ownerId = Objects.requireNonNull(ownerId, "ownerid cannot be null");
        this.currency = Objects.requireNonNull(currency, "currency cannot be null");
        this.status = Objects.requireNonNull(status, "status cannot be null");
        this.version = version;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
        this.closedAt = closedAt;

        ValidadeInvariants();
    }


    public static Wallet create(OwnerId ownerId, Currency currency) {
        return new Wallet(
                new WalletId(UUID.randomUUID()),
                ownerId,
                currency,
                WalletStatus.ACTIVE,
                0L,
                OffsetDateTime.now(),
                null
        );
    }

    public static Wallet restore(WalletId id,
                                 OwnerId ownerId,
                                 Currency currency,
                                 WalletStatus status,
                                 long version,
                                 OffsetDateTime createdAt,
                                 OffsetDateTime closedAt) {

        return new Wallet(id,ownerId, currency, status, version, createdAt, closedAt);
    }


    public WalletId getId() { return id; }
    public OwnerId getOwnerId() { return ownerId; }
    public Currency getCurrency() { return currency; }
    public WalletStatus getStatus() { return status; }
    public long getVersion() { return version; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getClosedAt() { return closedAt; }


    private void ValidadeInvariants() {
        if (version < 0) {
            throw new IllegalArgumentException("version cannot be less than zero");
        }
        if (status == WalletStatus.CLOSED && closedAt == null) {
            throw new IllegalArgumentException("An closed wallet needs to have a closedat");
        }
        if(status != WalletStatus.CLOSED && closedAt != null) {
            throw new IllegalArgumentException("Only a closed wallet have a closedAt time");
        }
        if(closedAt != null && closedAt.isBefore(createdAt)) {
            throw new IllegalArgumentException("Invalid closed time");
        }
    }



}
