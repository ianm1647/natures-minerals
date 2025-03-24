package ianm1647.naturesminerals.common.item;

import com.google.common.base.Suppliers;
import ianm1647.naturesminerals.common.registry.NMItems;
import ianm1647.naturesminerals.common.tag.NMCommonTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public enum NMTiers implements Tier {
    UVAROVITE(NMCommonTags.Blocks.INCORRECT_FOR_UVAROVITE_TOOL, 1500, 10.0F, 6.0F, 15,
            () -> Ingredient.of(NMItems.UVAROVITE_INGOT.get())),

    KUNZITE(NMCommonTags.Blocks.INCORRECT_FOR_KUNZITE_TOOL, 2000, 11.0F, 7.0F, 15,
            () -> Ingredient.of(NMItems.KUNZITE_INGOT.get())),

    STIBNITE(NMCommonTags.Blocks.INCORRECT_FOR_STIBNITE_TOOL, 2400, 12.0F, 8.0F, 15,
            () -> Ingredient.of(NMItems.STIBNITE_INGOT.get())),

    ASTRITE(NMCommonTags.Blocks.INCORRECT_FOR_ASTRITE_TOOL, 3200, 13.0F, 9.0F, 15,
            () -> Ingredient.of(NMItems.ASTRITE_INGOT.get())),

    THOUNITE(NMCommonTags.Blocks.INCORRECT_FOR_THOUNITE_TOOL, 5000, 14.0F, 12.0F, 25,
            () -> Ingredient.of(NMItems.THOUNITE_INGOT.get()));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    private NMTiers(TagKey incorrectBlockForDrops, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlockForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @Nullable TagKey<Block> getTag() {
        return getTagFromTier(this);
    }

    public Tool createToolProperties(TagKey<Block> block) {
        return new Tool(List.of(Tool.Rule.deniesDrops(this.getIncorrectBlocksForDrops()), Tool.Rule.minesAndDrops(block, this.getSpeed())), 1.0F, 1);
    }

    public static TagKey<Block> getTagFromTier(NMTiers tier) {

        return switch (tier) {
            case UVAROVITE -> NMCommonTags.Blocks.NEEDS_UVAROVITE_TOOL;
            case KUNZITE -> NMCommonTags.Blocks.NEEDS_KUNZITE_TOOL;
            case STIBNITE -> NMCommonTags.Blocks.NEEDS_STIBNITE_TOOL;
            case ASTRITE -> NMCommonTags.Blocks.NEEDS_ASTRITE_TOOL;
            case THOUNITE -> NMCommonTags.Blocks.NEEDS_THOUNITE_TOOL;
        };
    }
}
