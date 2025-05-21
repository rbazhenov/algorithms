package concurrency.vlad_zuev._26_semaphoreAndPool;

import java.util.Objects;

public final class Connection {
    private final long id;
    private boolean autoCommit;

    public Connection(long id, boolean autoCommit) {
        this.id = id;
        this.autoCommit = autoCommit;
    }

    public long getId() {
        return id;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }
        final Connection other = (Connection) otherObject;
        return this.id == other.id && this.autoCommit == other.autoCommit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.autoCommit);
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + ", " + getClass().getSimpleName() + "[id = " + this.id + ", autocommit = " + this.autoCommit + "]";
    }
}
