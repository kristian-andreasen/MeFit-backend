package noroff.mefit.services;

import noroff.mefit.models.SetCount;
import noroff.mefit.repositories.SetCountRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class SetCountServiceImpl implements SetCountService{
    private final SetCountRepository setCountRepository;

    public SetCountServiceImpl(SetCountRepository setCountRepository) {
        this.setCountRepository = setCountRepository;
    }

    @Override
    public SetCount findById(Integer id) {
        return setCountRepository.findById(id).get();
    }

    @Override
    public Collection<SetCount> findAll() {
        return setCountRepository.findAll();
    }

    @Override
    public SetCount add(SetCount entity) {
        return setCountRepository.save(entity);
    }

    @Override
    public SetCount update(SetCount entity) {
        return setCountRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        SetCount setCount = findById(id);
        if(setCount != null){
            setCount.getWorkouts().forEach(s -> {
                Set tempSet = s.getSetCounts();
                tempSet.remove(setCount);
                s.setSetCounts(tempSet);
            });
            setCountRepository.delete(setCount);
        }
    }
}
