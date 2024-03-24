import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NSK", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("NSK", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("NSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("NSK", "MSK", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "MSK", 800, 4, 9);
        Ticket ticket6 = new Ticket("NSK", "MSK", 200, 6, 10);
        Ticket ticket7 = new Ticket("MSK", "NSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("NSK", "MSK", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("NSK", "MSK");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NSK", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("NSK", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("NSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("NSK", "MSK", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "MSK", 800, 4, 9);
        Ticket ticket6 = new Ticket("NSK", "MSK", 200, 6, 10);
        Ticket ticket7 = new Ticket("MSK", "NSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("NSK", "MSK", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("MSK", "UFA");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NSK", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("NSK", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("NSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("NSK", "MSK", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "MSK", 800, 4, 9);
        Ticket ticket6 = new Ticket("NSK", "MSK", 200, 6, 10);
        Ticket ticket7 = new Ticket("MSK", "NSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("NSK", "MSK", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("UFA", "MSK");
        Ticket[] expected = {ticket5};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = new Ticket[]{ticket4, ticket8, ticket1, ticket2, ticket6};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortZeroTicketsComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NSK", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("NSK", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("NSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("NSK", "MSK", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "MSK", 800, 4, 9);
        Ticket ticket6 = new Ticket("NSK", "MSK", 200, 6, 10);
        Ticket ticket7 = new Ticket("MSK", "NSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("NSK", "MSK", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "UFA", comparator);
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NSK", "MSK", 200, 10, 12);
        Ticket ticket2 = new Ticket("NSK", "MSK", 100, 11, 14);
        Ticket ticket3 = new Ticket("NSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("NSK", "MSK", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "MSK", 800, 4, 9);
        Ticket ticket6 = new Ticket("NSK", "MSK", 200, 6, 10);
        Ticket ticket7 = new Ticket("MSK", "NSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("NSK", "MSK", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("UFA", "MSK", comparator);
        Ticket[] expected = {ticket5};
        assertArrayEquals(expected, actual);
    }
}