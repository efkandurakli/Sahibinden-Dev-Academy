package com.sahibinden.devakademi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahibinden.devakademi.domain.Advertisement;
import com.sahibinden.devakademi.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DevAkademiApplication implements CommandLineRunner {


	@Autowired
	private AdvertisementRepository advertisementRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevAkademiApplication.class, args);
	}

	private static String readLineByLine(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		String cwd = System.getProperty("user.dir");
		String file_sepetator = System.getProperty("file.separator");

		String filepath = cwd + file_sepetator + "src" + file_sepetator + "main" + file_sepetator +
				"resources" + file_sepetator + "initial_data" + file_sepetator + "bulkV2.json";

		String jsonString = readLineByLine(filepath);
		List<Advertisement> advertisementList = objectMapper.readValue(jsonString, new TypeReference<List<Advertisement>>(){});
		advertisementRepository.saveAll(advertisementList);
	}
}
