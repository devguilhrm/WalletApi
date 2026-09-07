package br.guirre.WalletAPI.core.domain;

import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

public final class Wallet {
    private UUID id;
    private UUID ownerId;
    private Currency currency;
    private WalletStatus status;
    private UUID ledgerAccountId;
    private long version;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;


    private Wallet(UUID ownerId, UUID id, Currency currency, WalletStatus status,
                   long version, UUID ledgerAccountId, LocalDateTime createdAt, LocalDateTime closedAt) {
        this.ownerId = ownerId;
        this.id = id;
        this.currency = currency;
        this.status = status;
        this.version = version;
        this.ledgerAccountId = ledgerAccountId;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
    }


    public static Wallet create(UUID ownerId, Currency currency) {
        return new Wallet( ownerId,  UUID.randomUUID(), currency,
                         WalletStatus.ACTIVE,0L, null,
                         LocalDateTime.now(), null);
    }

    public static Wallet restore(UUID id, UUID ownerId, Currency currency, WalletStatus status,
                                 UUID ledgerAccountId, long version, LocalDateTime createdAt, LocalDateTime closedAt) {
        return new Wallet(ownerId, id, currency,status,version,ledgerAccountId,createdAt,closedAt);
    }


    public UUID getId() { return id; }
    public UUID getOwnerId() { return ownerId; }
    public Currency getCurrency() { return currency; }
    public WalletStatus getStatus() { return status; }
    public UUID getLedgerAccountId() { return ledgerAccountId; }
    public long getVersion() { return version; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getClosedAt() { return closedAt; }




}
