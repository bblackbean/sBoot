package com.bblackbean.sboot.service;

import com.bblackbean.sboot.data.entity.Listener;

public interface ListenerService {
    Listener getEntity(Long id);

    void saveEntity(Listener listener);

    void updateEntity(Listener listener);

    void removeEntity(Listener listener);
}
