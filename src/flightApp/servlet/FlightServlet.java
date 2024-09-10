package flightApp.servlet;

import flightApp.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (var printWriter = resp.getWriter()) {
            printWriter.println("<h1>Список перелетов:</h1>");
            printWriter.println("<ul>");
            // ul - список
            // li - элемент списка
            flightService.findAll().forEach(flightDto -> {
                printWriter.write("""
                        <li>
                          <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription() ));
            });
            printWriter.println("</ul>");
        }
    }
}
