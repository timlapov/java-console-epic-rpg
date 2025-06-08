package art.lapov.rpg.enums;

public enum HeroActions {
    ATTACK("🗡️ Attack"),
    POTION("🧪 Take your medicine"),
    USE_SPECIAL_ABILITY("✨Use special ability"),
    SKIP("☮️ Skip"),;

    private final String displayName;

    HeroActions(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
