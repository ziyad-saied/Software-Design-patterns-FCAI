package src;

import src.Users.Professor;

public interface subject {

    void notifyAllUsers(String [] msg);
    void subscribeObserverForEmailNotification(CourseObserver observer);
    void subscribeObserverForSMSNotification(CourseObserver observer);
}

