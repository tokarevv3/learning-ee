package flightApp.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;


// Lombok - библиотека для автогенерации кода
// Применяется перед классом/методом/атрибутом

@AllArgsConstructor // Генерирует конструктор класса со всеми полями
@Getter // Генерирует геттеры для полей класса
@Setter // Генерирует сеттеры
@EqualsAndHashCode // Генерирует Equals и HashCode методы
@ToString // Генерирует метод toString

// @Data - Исполняет все предыдущие аннотации
public class Ticket {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;


}
