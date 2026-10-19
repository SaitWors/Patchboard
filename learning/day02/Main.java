public class Main {
    public static void main(String[] args) {
        String gameName = "No Man's Sky";
        long steamAppId = 275850L;
        boolean trackingEnabled = true;
        int newsCount = 5;
        int addNewsToday = 1;
        boolean importantNews = true;

        newsCount += addNewsToday;

        boolean hasNewNews = addNewsToday > 0;
        
        System.out.println("Patchboard");
        System.out.println("Game: " + gameName);
        System.out.println("Steam appId: " + steamAppId);
        System.out.println("Tracking: " + trackingEnabled);
        if (!trackingEnabled) {
            System.out.println("Monitoring paused for " + gameName);
        } else {
            if (hasNewNews && (addNewsToday >= 3 || importantNews)) {
                System.out.println("New news available!");
                System.out.println("News count: " + newsCount);
            } else {
                System.out.println("No news alert today.");
            }
        }
    }
}