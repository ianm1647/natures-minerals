package ianm1647.naturesminerals.data.recipe.builder;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConditionalShapedRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final int count;
    private final ItemStack resultStack;
    private final List<String> rows;
    private final Map<Character, Ingredient> key;
    private final Map<String, Criterion<?>> criteria;
    private ICondition condition;
    @Nullable
    private String group;
    private boolean showNotification;

    public ConditionalShapedRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
        this(category, new ItemStack(result, count));
    }

    public ConditionalShapedRecipeBuilder(RecipeCategory p_249996_, ItemStack result) {
        this.rows = Lists.newArrayList();
        this.key = Maps.newLinkedHashMap();
        this.criteria = new LinkedHashMap();
        this.showNotification = true;
        this.category = p_249996_;
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
    }

    public static ConditionalShapedRecipeBuilder shaped(RecipeCategory category, ItemLike result) {
        return shaped(category, result, 1);
    }

    public static ConditionalShapedRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count) {
        return new ConditionalShapedRecipeBuilder(category, result, count);
    }

    public static ConditionalShapedRecipeBuilder shaped(RecipeCategory p_251325_, ItemStack result) {
        return new ConditionalShapedRecipeBuilder(p_251325_, result);
    }

    public ConditionalShapedRecipeBuilder define(Character symbol, TagKey<Item> tag) {
        return this.define(symbol, Ingredient.of(tag));
    }

    public ConditionalShapedRecipeBuilder define(Character symbol, ItemLike item) {
        return this.define(symbol, Ingredient.of(new ItemLike[]{item}));
    }

    public ConditionalShapedRecipeBuilder define(Character symbol, Ingredient ingredient) {
        if (this.key.containsKey(symbol)) {
            throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
        } else if (symbol == ' ') {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        } else {
            this.key.put(symbol, ingredient);
            return this;
        }
    }

    public ConditionalShapedRecipeBuilder pattern(String pattern) {
        if (!this.rows.isEmpty() && pattern.length() != this.rows.get(0).length()) {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        } else {
            this.rows.add(pattern);
            return this;
        }
    }

    public ConditionalShapedRecipeBuilder conditions(ICondition condition) {
        this.condition = condition;
        return this;
    }

    public ConditionalShapedRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public ConditionalShapedRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    public ConditionalShapedRecipeBuilder showNotification(boolean showNotification) {
        this.showNotification = showNotification;
        return this;
    }

    public Item getResult() {
        return this.result;
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        ShapedRecipePattern shapedrecipepattern = this.ensureValid(id);
        ShapedRecipe shapedrecipe = new ShapedRecipe(Objects.requireNonNullElse(this.group, ""), RecipeBuilder.determineBookCategory(this.category), shapedrecipepattern, this.resultStack, this.showNotification);
        recipeOutput.accept(id, shapedrecipe, null, this.condition);
    }

    private ShapedRecipePattern ensureValid(ResourceLocation loaction) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(loaction));
        } else {
            return ShapedRecipePattern.of(this.key, this.rows);
        }
    }
}
