package fr.epita.assistants.notifyme.notify;

public class StandardOutputNotifier implements NotificationSender {
    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        System.out.printf("[StandardOutputNotifier] Notification from %s to %s received: %s\n", parSender, parReceiver,
                parMessage);
    }
}
