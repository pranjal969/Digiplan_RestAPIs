package com.digiplan.services;

import com.digiplan.entities.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Optional<Notification> getNotificationById(Long id);
    Notification saveNotification(Notification notification);
    Notification updateNotification(Long id, Notification notification);
    Notification deleteNotification(Long id);

List<Object[]> callNotificationList(String fromDate, String toDate);

}
