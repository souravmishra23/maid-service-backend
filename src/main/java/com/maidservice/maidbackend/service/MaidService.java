package com.maidservice.maidbackend.service;

import com.maidservice.maidbackend.model.Maid;
import com.maidservice.maidbackend.repository.MaidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaidService {

    private final MaidRepository maidRepo;

    public MaidService(MaidRepository maidRepo) {
        this.maidRepo = maidRepo;
    }

    public Maid addMaid(Maid maid) {
        return maidRepo.save(maid);
    }

    public List<Maid> getAllMaids() {
        return maidRepo.findAll();
    }

    public Optional<Maid> getMaidById(String id) {
        return maidRepo.findById(id);
    }

    public List<Maid> searchMaids(String location, String service) {
        if (location != null && service != null) {
            return maidRepo.findByLocationContainingIgnoreCaseAndServicesContainingIgnoreCase(location, service);
        } else if (location != null) {
            return maidRepo.findByLocationContainingIgnoreCase(location);
        } else if (service != null) {
            return maidRepo.findByServicesContainingIgnoreCase(service);
        } else {
            return maidRepo.findAll();
        }
    }

    public Maid updateMaid(String id, Maid maid) {
        maid.setId(id);
        return maidRepo.save(maid);
    }

    public void deleteMaid(String id) {
        maidRepo.deleteById(id);
    }
}
