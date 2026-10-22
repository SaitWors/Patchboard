package ru.mcg.patchboard;

public record Game(
        long steamAppId,
        String name,
        boolean trackingEnabled
) {
    
}