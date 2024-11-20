package org.pogonin.hibernatetable;

import lombok.RequiredArgsConstructor;
import org.pogonin.hibernatetable.entity.Aircraft;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;

    @Transactional(readOnly = true)
    public Aircraft findById(String id) {
        return aircraftRepository.findById(id).orElseThrow(() -> new RuntimeException("Aircraft not found"));
    }
}
