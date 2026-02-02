package fr.epita.assistants.notifyme.notify;

public interface NotificationSender {
    /**
    * Entrypoint to send notifications
    * @param parSender the identifier of the notification sender
    * @param parReceiver the identifier of the notification receiver
    * @param parMessage the message to use for the notification - may be discarded by the implementation
    */
    void notify(final String parSender, final String parReceiver, final String parMessage);
}
