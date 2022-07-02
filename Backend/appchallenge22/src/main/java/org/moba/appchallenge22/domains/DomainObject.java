package org.moba.appchallenge22.domains;

import java.io.Serial;
import java.io.Serializable;

public interface DomainObject<T extends Serializable> {
    T getId();

    void setId(T id);
}
