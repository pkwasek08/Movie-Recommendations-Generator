package pl.project.generator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.common.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ModelAI {
    Logger log = LogManager.getLogger(this.getClass());

    //@PostConstruct
    public void generate() throws IOException, InvalidKerasConfigurationException, UnsupportedKerasConfigurationException {
        // load the model
        String simpleMlp = new ClassPathResource(
                "silnik_rekomendacyjny.h5").getFile().getPath();
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);
    }
}
