package pl.project.generator;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nd4j.common.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.project.movie_generator_result.MovieGeneratorDataEntity;
import pl.project.movie_generator_result.MovieGeneratorDataService;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class InitGeneratorMovieData {
    Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    MovieGeneratorDataService movieGeneratorDataService;

    @PostConstruct
    public void init() {
        if (movieGeneratorDataService.isNotEmpty()) {
            return;
        }
        List<MovieGeneratorDataEntity> objectList = loadObjectList(MovieGeneratorDataEntity.class, "model_movie_generator_data.csv");
        Iterable<MovieGeneratorDataEntity> result = movieGeneratorDataService.saveAllMovieGeneratorData(objectList);
        if (result != null) {
            log.info("Import generate ai model data successful");
        } else {
            log.info("Import generate ai model data failed");
        }
    }

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(type).withHeader().withColumnReordering(true);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).with(schema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
