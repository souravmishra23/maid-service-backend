package com.maidservice.maidbackend.controller;

import com.maidservice.maidbackend.model.Maid;
import com.maidservice.maidbackend.service.MaidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maids")
@CrossOrigin
public class MaidController {

    private final MaidService maidService;

    public MaidController(MaidService maidService) {
        this.maidService = maidService;
    }

    @PostMapping
    public ResponseEntity<Maid> addMaid(@RequestBody Maid maid) {
        return ResponseEntity.ok(maidService.addMaid(maid));
    }

    @GetMapping
    public ResponseEntity<List<Maid>> getAllMaids() {
        return ResponseEntity.ok(maidService.getAllMaids());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maid> getMaidById(@PathVariable String id) {
        return maidService.getMaidById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Maid>> searchMaids(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String service) {
        return ResponseEntity.ok(maidService.searchMaids(location, service));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maid> updateMaid(@PathVariable String id, @RequestBody Maid maid) {
        return ResponseEntity.ok(maidService.updateMaid(id, maid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaid(@PathVariable String id) {
        maidService.deleteMaid(id);
        return ResponseEntity.noContent().build();
    }
}
