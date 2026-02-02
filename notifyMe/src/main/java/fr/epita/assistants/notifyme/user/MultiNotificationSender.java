package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.NotificationSender;

import java.util.List;

public interface MultiNotificationSender {
    /**
     * Sends a notification to all registered notifiers
     * @param parRecipient the recipient of the notification
     * @param parMessage the message to send
     */
    void sendNotifications(String parRecipient, String parMessage);

    /**
     * Adds a notification sender to the list of possible recipients
     * @param parNotifier the new notifier to add, should be ignored if null
     */
    void addNotifier(NotificationSender parNotifier);

    /**
     * Returns the list of notifiers
     * @return the list of notifiers
     */
    List<NotificationSender> getNotifiers();
}
