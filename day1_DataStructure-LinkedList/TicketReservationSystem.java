
class TicketReservationSystem {
    private static class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head;
    private TicketNode tail;
    private int ticketCount;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.ticketCount = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head; 
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; 
        }
        ticketCount++;
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode temp = head;
        TicketNode prev = null;

        if (temp.ticketId == ticketId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; 
            }
            ticketCount--;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.ticketId == ticketId) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                ticketCount--;
                return;
            }
        } while (temp != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String searchQuery) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchQuery) || temp.movieName.equalsIgnoreCase(searchQuery)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for the given search query.");
        }
    }

    public int getTotalTickets() {
        return ticketCount;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "John Doe", "Avatar", "A1", "2025-04-16 18:00");
        system.addTicket(2, "Jane Smith", "Inception", "B3", "2025-04-16 19:00");
        system.addTicket(3, "Alice Johnson", "Avengers", "C5", "2025-04-17 20:00");

        system.displayTickets();

        system.searchTicket("Jane Smith");

        system.searchTicket("Avatar");

        System.out.println("Total booked tickets: " + system.getTotalTickets());

        system.removeTicket(2);

        system.displayTickets();

        System.out.println("Total booked tickets after removal: " + system.getTotalTickets());
    }
}



