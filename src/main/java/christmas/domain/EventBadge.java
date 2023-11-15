package christmas.domain;

public class EventBadge {
    /**
     * eventBadge: 이벤트 배지
     */
    private String eventBadge;

    public EventBadge() {
        this.eventBadge = "없음";
    }

    public void setEventBadge(String eventBadge) {
        this.eventBadge = eventBadge;
    }

    public String getEventBadge() {
        return eventBadge;
    }
}
