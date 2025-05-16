package data.models;

import data.repository.ResidentsRepository;

import java.util.Optional;

public class Residents implements ResidentsRepository {
private long count=0;

    @Override
    public long count() {
        return count;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAllById() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public boolean existsById() {
        return false;
    }

    @Override
    public Iterable<Residents> findAll() {
        return null;
    }

    @Override
    public Optional<Residents> findById() {
        return Optional.empty();
    }

    @Override
    public void save(Residents resident) {
     this.count++;

    }
}
