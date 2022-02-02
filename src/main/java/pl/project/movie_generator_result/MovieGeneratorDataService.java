package pl.project.movie_generator_result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieGeneratorDataService {
    @Autowired
    MovieGeneratorDataRepository movieGeneratorDataRepository;

    public boolean isNotEmpty(){
       return movieGeneratorDataRepository.existsById(1);
    }
    public Integer getMovieGenerateOutputId(Integer id) {
        Optional<MovieGeneratorDataEntity> result = movieGeneratorDataRepository.findById(id);
        return result.isPresent() ? result.get().getIdMovieOutput() : null;
    }

    public Iterable<MovieGeneratorDataEntity> saveAllMovieGeneratorData(List<MovieGeneratorDataEntity> list){
        return movieGeneratorDataRepository.saveAll(list);
    }
}
