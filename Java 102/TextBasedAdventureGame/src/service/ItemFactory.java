package service;

import model.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    private final Random random;

    public ItemFactory(Random random) {
        this.random = random;
    }

    public List<Item> createDrops(int minItems, int maxItems, int minDamage, int maxDamage, int minArmorRating,
                                  int maxArmorRating, int minHealthBonus, int maxHealthBonus) {
        List<Item> shopItems = new ArrayList<>();
        int numItems = random.nextInt(maxItems - minItems + 1) + minItems;

        for (int i = 0; i < numItems; i++) {
            if (random.nextBoolean()) {
                // Generate a random weapon and add it to the shop items
                Weapon weapon = createRandomWeapon(minDamage, maxDamage);
                shopItems.add(weapon);
            } else {
                // Generate a random armor and add it to the shop items
                Armor armor = createRandomArmor(minArmorRating, maxArmorRating, minHealthBonus, maxHealthBonus);
                shopItems.add(armor);
            }
        }

        return shopItems;
    }

    public List<Item> createShopItems(int minItems, int maxItems) {
        List<Item> shopItems = new ArrayList<>();
        int numItems = random.nextInt(maxItems - minItems + 1) + minItems;

        for (int i = 0; i < numItems; i++) {
            if (random.nextBoolean()) {
                // Generate a random weapon and add it to the shop items
                int minDamage = random.nextInt(100) + 15;
                int maxDamage = random.nextInt(200) + minDamage;
                Weapon weapon = createRandomWeapon(minDamage, maxDamage);
                shopItems.add(weapon);
            } else {
                // Generate a random armor and add it to the shop items
                int minArmorRating = random.nextInt(100) + 5;
                int maxArmorRating = random.nextInt(200) + minArmorRating;
                int minHealthBonus = random.nextInt(100) + 10;
                int maxHealthBonus = random.nextInt(200) + minHealthBonus;
                Armor armor = createRandomArmor(minArmorRating, maxArmorRating, minHealthBonus, maxHealthBonus);
                shopItems.add(armor);
            }
        }

        return shopItems;
    }

    public Weapon createRandomWeapon(int minDamage, int maxDamage) {
        int randomMaxDamage = random.nextInt(maxDamage - minDamage + 1) + minDamage;

        WeaponType[] weaponTypes = WeaponType.values();
        WeaponType randomWeaponType = weaponTypes[random.nextInt(weaponTypes.length)];

        int averageDamage = (minDamage + randomMaxDamage) / 2;
        int weaponValue = (int) (averageDamage * 1.5);

        String weaponName = generateWeaponName(randomWeaponType);

        return new Weapon(weaponName, weaponValue, minDamage, randomMaxDamage, randomWeaponType);
    }

    public Armor createRandomArmor(int minArmorRating, int maxArmorRating, int minHealthBonus, int maxHealthBonus) {
        int randomArmorRating = random.nextInt(maxArmorRating - minArmorRating + 1) + minArmorRating;
        int randomHealthBonus = random.nextInt(maxHealthBonus - minHealthBonus + 1) + minHealthBonus;

        ArmorType[] armorTypes = ArmorType.values();
        ArmorType randomArmorType = armorTypes[random.nextInt(armorTypes.length)];

        String armorName = generateArmorName(randomArmorType);

        // Calculate the value based on armor rating and health bonus
        int armorValue = randomArmorRating + randomHealthBonus; // Adjust multipliers as needed

        return new Armor(armorName, armorValue, randomArmorRating, randomHealthBonus, randomArmorType);
    }

    private String generateWeaponName(WeaponType weaponType) {
        String baseName = switch (weaponType) {
            case SWORD -> "Sword";
            case BOW -> "Bow";
            case STAFF -> "Staff";
            // Add more cases for other weapon types if needed

        };

        String[] prefixes = {"Iron", "Steel", "Silver", "Golden", "Enchanted"};
        String prefix = prefixes[random.nextInt(prefixes.length)];

        return prefix + " " + baseName;
    }

    private String generateArmorName(ArmorType armorType) {
        String type = "";
        String prefix = "";

        type = switch (armorType) {
            case LIGHT -> "Leather";
            case MEDIUM -> "Steel";
            case HEAVY -> "Plate";
            // Add more cases for additional armor types
        };

        // Generate random suffixes or additional modifiers
        String[] randomPrefixes = {"Thief's", "Enchanted", "Blessed", "Cursed", "Fortified"};
        prefix = randomPrefixes[random.nextInt(randomPrefixes.length)];

        return prefix + " " + type + " Armor";
    }
}
