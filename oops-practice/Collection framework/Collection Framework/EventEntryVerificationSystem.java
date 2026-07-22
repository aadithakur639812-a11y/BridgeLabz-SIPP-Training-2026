import java.util.HashSet;

public class EventEntryVerificationSystem {
    private final HashSet<String> participantEmails = new HashSet<>();

    public boolean registerParticipant(String email) {
        boolean registered = participantEmails.add(email);
        System.out.println(registered ? email + " registered successfully." : email + " is already registered.");
        return registered;
    }

    public void displayParticipants() {
        System.out.println("Unique registered participants: " + participantEmails);
        System.out.println("Eligible attendees: " + participantEmails.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();
        event.registerParticipant("aisha@example.com");
        event.registerParticipant("rohan@example.com");
        event.registerParticipant("aisha@example.com");
        event.displayParticipants();
    }
}
