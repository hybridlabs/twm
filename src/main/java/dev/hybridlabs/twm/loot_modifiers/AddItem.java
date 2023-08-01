package dev.hybridlabs.twm.loot_modifiers;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class AddItem extends LootModifier {
  public static final Supplier<Codec<AddItem>> CODEC = Suppliers.memoize(()
    -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
      inst.group(
        ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
        Codec.INT.fieldOf("count").forGetter(m -> m.countOfTries),
        Codec.DOUBLE.fieldOf("chance").forGetter(m -> m.chance)))
    .apply(inst, AddItem::new)));
  
  private final Item item;
  private final int countOfTries;
  private final double chance;
  
  public AddItem(LootItemCondition[] conditionsIn, Item item, int count, double chance) {
    super(conditionsIn);
    this.item = item;
    this.countOfTries = count;
    this.chance = chance;
  }
  
  @Override
  protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
    for(int i = 0; i<countOfTries; i++) {
      if(context.getRandom().nextDouble() <= chance) generatedLoot.add(item.getDefaultInstance());
    }
    return generatedLoot;
  }
  
  @Override
  public Codec<? extends IGlobalLootModifier> codec() {
    return CODEC.get();
  }
}
