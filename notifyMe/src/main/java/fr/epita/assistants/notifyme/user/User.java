package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.NotificationSender;

import java.util.ArrayList;
import java.util.List;

public class User implements MultiNotificationSender {
    final String username;
    List<NotificationSender> notifiers;

    public User(final String username, final List<NotificationSender> parNotificationList) {
        this.username = username;
        this.notifiers = parNotificationList;
    }

    public User(final String username) {
        this.username = username;
        this.notifiers = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (NotificationSender notifier : notifiers) {
            notifier.notify(username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(NotificationSender parNotifier) {
        if (parNotifier == null)
            return;
        notifiers.add(parNotifier);
    }

    @Override
    public List<NotificationSender> getNotifiers() {
        return notifiers;
    }
}
