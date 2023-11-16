package christmas.domain.Info;

public class EventBadgeInfo {
    /**
     * eventBadge: 이벤트 배지
     */
    private String eventBadge;

    public EventBadgeInfo() {
        this.eventBadge = "없음";
    }

    public void setEventBadge(String eventBadge) {
        this.eventBadge = eventBadge;
    }

    public String getEventBadge() {
        return eventBadge;
    }
}
