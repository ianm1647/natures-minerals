package ianm1647.naturesminerals.data.recipe.builder;

import net.minecraft.advancements.Criterion;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConditionalCookingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final CookingBookCategory bookCategory;
    private final Item result;
    private final ItemStack stackResult;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final Map<String, Criterion<?>> criteria;
    @Nullable
    private String group;
    private final AbstractCookingRecipe.Factory<?> factory;
    private ICondition condition;

    private ConditionalCookingRecipeBuilder(RecipeCategory category, CookingBookCategory bookCategory, ItemLike result, Ingredient ingredient, float experience, int cookingTime, AbstractCookingRecipe.Factory<?> factory) {
        this(category, bookCategory, new ItemStack(result), ingredient, experience, cookingTime, factory);
    }

    private ConditionalCookingRecipeBuilder(RecipeCategory recipeCategory, CookingBookCategory bookCategory, ItemStack result, Ingredient ingredient, float exp, int cookingTime, AbstractCookingRecipe.Factory<?> factory) {
        this.criteria = new LinkedHashMap();
        this.category = recipeCategory;
        this.bookCategory = bookCategory;
        this.result = result.getItem();
        this.stackResult = result;
        this.ingredient = ingredient;
        this.experience = exp;
        this.cookingTime = cookingTime;
        this.factory = factory;
        this.condition = condition;
    }

    public static <T extends AbstractCookingRecipe> ConditionalCookingRecipeBuilder generic(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> factory) {
        return new ConditionalCookingRecipeBuilder(category, determineRecipeCategory(cookingSerializer, result), result, ingredient, experience, cookingTime, factory);
    }

    public static ConditionalCookingRecipeBuilder campfireCooking(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        return new ConditionalCookingRecipeBuilder(category, CookingBookCategory.FOOD, result, ingredient, experience, cookingTime, CampfireCookingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder blasting(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        return new ConditionalCookingRecipeBuilder(category, determineBlastingRecipeCategory(result), result, ingredient, experience, cookingTime, BlastingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder smelting(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        return new ConditionalCookingRecipeBuilder(category, determineSmeltingRecipeCategory(result), result, ingredient, experience, cookingTime, SmeltingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder smoking(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        return new ConditionalCookingRecipeBuilder(category, CookingBookCategory.FOOD, result, ingredient, experience, cookingTime, SmokingRecipe::new);
    }

    public static <T extends AbstractCookingRecipe> ConditionalCookingRecipeBuilder generic(Ingredient p_250999_, RecipeCategory p_248815_, ItemStack result, float p_251320_, int p_248693_, RecipeSerializer<T> p_250921_, AbstractCookingRecipe.Factory<T> p_312657_) {
        return new ConditionalCookingRecipeBuilder(p_248815_, determineSmeltingRecipeCategory(result.getItem()), result, p_250999_, p_251320_, p_248693_, p_312657_);
    }

    public static ConditionalCookingRecipeBuilder campfireCooking(Ingredient p_249393_, RecipeCategory p_249372_, ItemStack result, float p_252321_, int p_251916_) {
        return new ConditionalCookingRecipeBuilder(p_249372_, CookingBookCategory.FOOD, result, p_249393_, p_252321_, p_251916_, CampfireCookingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder blasting(Ingredient p_252115_, RecipeCategory p_249421_, ItemStack result, float p_250383_, int p_250476_) {
        return new ConditionalCookingRecipeBuilder(p_249421_, determineBlastingRecipeCategory(result.getItem()), result, p_252115_, p_250383_, p_250476_, BlastingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder smelting(Ingredient p_249223_, RecipeCategory p_251240_, ItemStack result, float p_249452_, int p_250496_) {
        return new ConditionalCookingRecipeBuilder(p_251240_, determineSmeltingRecipeCategory(result.getItem()), result, p_249223_, p_249452_, p_250496_, SmeltingRecipe::new);
    }

    public static ConditionalCookingRecipeBuilder smoking(Ingredient p_248930_, RecipeCategory p_250319_, ItemStack result, float p_252329_, int p_250482_) {
        return new ConditionalCookingRecipeBuilder(p_250319_, CookingBookCategory.FOOD, result, p_248930_, p_252329_, p_250482_, SmokingRecipe::new);
    }

    public ConditionalCookingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public ConditionalCookingRecipeBuilder conditions(ICondition condition) {
        this.condition = condition;
        return this;
    }

    public ConditionalCookingRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    public Item getResult() {
        return this.result;
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        this.ensureValid(id);
        AbstractCookingRecipe abstractcookingrecipe = this.factory.create(Objects.requireNonNullElse(this.group, ""), this.bookCategory, this.ingredient, this.stackResult, this.experience, this.cookingTime);
        recipeOutput.accept(id, abstractcookingrecipe, null, this.condition);
    }

    private static CookingBookCategory determineSmeltingRecipeCategory(ItemLike result) {
        if (result.asItem().components().has(DataComponents.FOOD)) {
            return CookingBookCategory.FOOD;
        } else {
            return result.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
        }
    }

    private static CookingBookCategory determineBlastingRecipeCategory(ItemLike result) {
        return result.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
    }

    private static CookingBookCategory determineRecipeCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemLike result) {
        if (serializer == RecipeSerializer.SMELTING_RECIPE) {
            return determineSmeltingRecipeCategory(result);
        } else if (serializer == RecipeSerializer.BLASTING_RECIPE) {
            return determineBlastingRecipeCategory(result);
        } else if (serializer != RecipeSerializer.SMOKING_RECIPE && serializer != RecipeSerializer.CAMPFIRE_COOKING_RECIPE) {
            throw new IllegalStateException("Unknown cooking recipe type");
        } else {
            return CookingBookCategory.FOOD;
        }
    }

    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(id));
        }
    }
}
