package util;

public class EndGameUtil {

    private static boolean isCrystalShardCollected;
    private static boolean isEnchantedLeafCollected;
    private static boolean isAquaticPearlCollected;
    private static boolean isElementalGemstoneCollected;

    public static boolean checkEndGame() {
        return isCrystalShardCollected && isEnchantedLeafCollected
                && isAquaticPearlCollected && isElementalGemstoneCollected;
    }

    public static void setIsCrystalShardCollected(boolean isCrystalShardCollected) {
        EndGameUtil.isCrystalShardCollected = isCrystalShardCollected;
    }

    public static void setIsEnchantedLeafCollected(boolean isEnchantedLeafCollected) {
        EndGameUtil.isEnchantedLeafCollected = isEnchantedLeafCollected;
    }

    public static void setIsAquaticPearlCollected(boolean isAquaticPearlCollected) {
        EndGameUtil.isAquaticPearlCollected = isAquaticPearlCollected;
    }

    public static void setIsElementalGemstoneCollected(boolean isElementalGemstoneCollected) {
        EndGameUtil.isElementalGemstoneCollected = isElementalGemstoneCollected;
    }
}
