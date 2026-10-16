public class Main {
    public static void main(String[] args) {
        String gameName = "No Man's Sky";
        long steamAppId = 275850L;
        boolean trackingEnabled = false;
        int newsCount = 5;
        int addNewsToday = 4;

        newsCount += addNewsToday;
        
        System.out.println("Patchboard");
        System.out.println("Game: " + gameName);
        System.out.println("Steam appId: " + steamAppId);
        System.out.println("Tracking: " + trackingEnabled);
        System.out.println("News count: " + newsCount);
    }
}