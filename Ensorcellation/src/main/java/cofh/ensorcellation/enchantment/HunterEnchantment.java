package cofh.ensorcellation.enchantment;

import cofh.core.enchantment.EnchantmentCoFH;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static cofh.core.util.helpers.ArcheryHelper.validBow;

public class HunterEnchantment extends EnchantmentCoFH {

    public static int chance = 50;

    public HunterEnchantment() {

        super(Rarity.VERY_RARE, EnchantmentType.BOW, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 2;
        treasure = true;
    }

    @Override
    public int getMinEnchantability(int level) {

        return 10 + (level - 1) * 9;
    }

    @Override
    protected int maxDelegate(int level) {

        return getMinEnchantability(level) + 50;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {

        Item item = stack.getItem();
        return enable && (item instanceof BowItem || validBow(stack) || supportsEnchantment(stack));
    }

}
