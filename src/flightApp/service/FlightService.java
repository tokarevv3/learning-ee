package flightApp.service;

import flightApp.dao.FlightDao;
import flightApp.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {

    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream().map(flight -> new FlightDto(
                flight.getId(),
                """
                        %s - %s - %s
                        """.formatted(flight.getDepartureAirportCode(),
                        flight.getArrivalAirportCode(),
                        flight.getStatus())
        )).collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
