package data.repository;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Residents implements ResidentsRepository{
    private static List<Resident> residents = new ArrayList<>();
    private static int currentId =0;

    public static void reset(){
        residents.clear();
        currentId = 0;
    }

    @Override
    public List<Resident> getResidents() {
        return residents;
    }

    @Override
    public long count() {
        return residents.size();
    }

    @Override
    public void deleteAllById() {

    }

    @Override
    public void deleteById(long id) {
        delete(findById(id).get());
    }

    @Override
    public boolean existsById(long id) {
        for (Resident resident : residents) {
            if (resident.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existResident(String name) {
        for (Resident resident : residents) {
            if (resident.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Resident> findById(long id) {
        for (Resident resident : residents) {
            if (resident.getId() == id) {
                return Optional.of(resident);
            }
        }

        return Optional.empty();

    }



    @Override
    public Resident save(Resident resident) {
        if(isNew(resident))saveResident(resident); else update(resident);

        return resident;
    }

    @Override
    public List<Resident> find(String name) {
        List<Resident> result = new ArrayList<>();
        for (Resident resident : residents) {
            if (resident.getName().equals(name)) result.add(resident);

        }
        return result;

    }

    @Override
    public boolean existResident(Resident resident) {
        return false;
    }

    @Override
    public void delete(Resident resident) {

    }
    private void update(Resident resident) {
        for (Resident oldresident: residents){
            if(oldresident.getId() == resident.getId()){
                residents.remove(oldresident);
                break;
            }
        }
        residents.add(resident);
    }

    private void saveResident(Resident resident) {
        resident.setId(createId());
        residents.add(resident);
    }

    private boolean isNew(Resident resident) {
        return resident.getId() == 0;
    }

    private long createId(){
      return ++currentId;
    }

}
