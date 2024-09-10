package flightApp.service;

import flightApp.dao.TIcketDao;
import flightApp.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TIcketDao ticketDao = TIcketDao.getInstance();

    private TicketService() {

    }

    public List<TicketDto> findAllById(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream().map(
                ticket -> new TicketDto(
                    ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                )).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
