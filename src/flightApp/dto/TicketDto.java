package flightApp.dto;

import java.util.Objects;

public class TicketDto {

    private final Long id;
    private final Long flightId;
    private final String seatNo;

    public TicketDto(Long id, Long flightId, String seatNo) {
        this.seatNo = seatNo;
        this.flightId = flightId;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) && Objects.equals(flightId, ticketDto.flightId) && Objects.equals(seatNo, ticketDto.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, seatNo);
    }

    @Override
    public String toString() {
        return "TicketDto{" +
               "id=" + id +
               ", flightId=" + flightId +
               ", seatNo='" + seatNo + '\'' +
               '}';
    }
}
