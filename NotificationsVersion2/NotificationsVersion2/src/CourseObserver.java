package src;

public interface CourseObserver {
    void notify(String message);
    String getEmail();
    String getPhone();
}
