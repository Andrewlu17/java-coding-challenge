package com.mooveit.cars.tasks;

import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.repositories.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

@Slf4j
@Service
public class FordIngesterTask {

    @Value("${cars.ford.ingester.fileName}")
    private String fileName;

    @Autowired
    private ModelRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(FordIngesterTask.class);

    @Scheduled(cron = "${cars.ford.ingester.runCron}")
    public void ingestFile() {
        try {
            logger.info("Read the file named {} ", fileName);
            File file = ResourceUtils.getFile(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalogue.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            logger.info("Convert the excel file into an Object");
            Catalogue catalog = (Catalogue) unmarshaller.unmarshal(file);
            logger.info("Save all the data into database");
            repository.saveAll(catalog.getModels());
        } catch (JAXBException | FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
