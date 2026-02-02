package fr.epita.assistants.notifyme.notify;

public class StandardErrorNotifier implements NotificationSender {
    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        System.err.printf("[StandardErrorNotifier] Notification from %s to %s received: %s\n", parSender, parReceiver,
                parMessage);
    }
}