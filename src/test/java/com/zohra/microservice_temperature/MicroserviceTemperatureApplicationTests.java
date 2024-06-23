package com.zohra.microservice_temperature;

import com.zohra.microservice_temperature.entity.Sonde;
import com.zohra.microservice_temperature.repository.SondeRepository;
import com.zohra.microservice_temperature.service.SondeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@SpringBootTest
class MicroserviceTemperatureApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private SondeRepository sondeRepository;

	@InjectMocks
	private SondeService sondeService;

	@Test
	public void testGetTemperatureByPeriodForSonde1() {
		/*LocalDateTime startDate = LocalDateTime.of(2024, 5, 16, 15, 40);
		LocalDateTime endDate = LocalDateTime.of(2024, 5, 16, 17, 20);

		Sonde sonde1 = new Sonde();
		sonde1.setDate(LocalDateTime.of(2024, 5, 16, 15, 49));
		sonde1.setTemperature(21.80);
		sonde1.setTensionBatterie(2.900);
		sonde1.setRssi(-67.00);
		sonde1.setConcentrateur("7231");
		sonde1.setHeureReception(LocalDateTime.of(2024, 5, 16, 15, 55));
		sonde1.setArchivage(false);
		sonde1.setIntervalleMesure(600);

		List<Sonde> expectedTemperatures = Arrays.asList(sonde1);

		when(sondeRepository.findByDateBetween(startDate, endDate)).thenReturn(expectedTemperatures);

		List<Sonde> actualTemperatures = sondeService.getTemperaturesByPeriodForSonde(startDate, endDate);

		assertFalse(actualTemperatures.isEmpty());
		assertEquals(expectedTemperatures, actualTemperatures);
	*/}
}