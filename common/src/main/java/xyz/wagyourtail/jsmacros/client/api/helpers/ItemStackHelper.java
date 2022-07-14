package xyz.wagyourtail.jsmacros.client.api.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.wagyourtail.jsmacros.core.helpers.BaseHelper;

/**
 * @author Wagyourtail
 *
 */
@SuppressWarnings("unused")
public class ItemStackHelper extends BaseHelper<ItemStack> {
    protected static final Minecraft mc = Minecraft.getInstance();
    
    public ItemStackHelper(ItemStack i) {
        super(i);
    }
    
    /**
     * Sets the item damage value.
     * 
     * You may want to use {@link ItemStackHelper#copy()} first.
     * 
     * @since 1.2.0
     * 
     * @param damage
     * @return
     */
    public ItemStackHelper setDamage(int damage) {
        base.setDamage(damage);
        return this;
    }
    
    /**
     * @since 1.2.0
     * @return
     */
    public boolean isDamageable() {
        return base.isDamageable();
    }
    
    /**
     * @since 1.2.0
     * @return
     */
    public boolean isEnchantable() {
        return base.isEnchantable();
    }
    
    /**
     * @return
     */
    public int getDamage() {
        return base.getDamage();
    }
    
    /**
     * @return
     */
    public int getMaxDamage() {
        return base.getMaxDamage();
    }
    
    /**
     * @since 1.2.0
     * @return was string before 1.6.5
     */
    public TextHelper getDefaultName() {
        return new TextHelper(base.getItem().getDisplayName(base));
    }
    
    /**
     * @return was string before 1.6.5
     */
    public TextHelper getName() {
        return new TextHelper(base.getName());
    }
    
    /**
     * @return
     */
    public int getCount() {
        return base.count;
    }
    
    /**
     * @return
     */
    public int getMaxCount() {
        return base.getMaxCount();
    }

    /**
     * @since 1.1.6, was a {@link String} until 1.5.1
     * @return
     */
    public NBTElementHelper<?> getNBT() {
        NBTTagCompound tag = base.getTag();
        if (tag != null) return NBTElementHelper.resolve(tag);
        else return null;
    }
    
    /**
     * @since 1.1.3
     * @return
     */
    public String getCreativeTab() {
        CreativeTabs g = base.getItem().getItemGroup();
        if (g != null)
            return g.getTranslationKey();
        else
            return null;
    }
    
    /**
     * @return
     */
     @Deprecated
    public String getItemID() {
        return getItemId();
    }

    /**
     * @since 1.6.4
     * @return
     */
    public String getItemId() {
        return Item.REGISTRY.getIdentifier(base.getItem()).toString();
    }
    
    /**
     * @return
     */
    public boolean isEmpty() {
        return base.isEmpty();
    }
    
    public String toString() {
        return String.format("ItemStack:{\"id\":\"%s\", \"damage\": %d, \"count\": %d}", this.getItemId(), base.getDamage(), base.count);
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param ish
     * @return
     */
    public boolean equals(ItemStackHelper ish) {
        return base.equals(ish.getRaw());
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param is
     * @return
     */
    public boolean equals(ItemStack is) {
        return base.equals(is);
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param ish
     * @return
     */
    public boolean isItemEqual(ItemStackHelper ish) {
        return base.equalsIgnoreTags(ish.getRaw()) && base.getDamage() == ish.getRaw().getDamage();
    } 
    
    /**
     * @since 1.1.3 [citation needed]
     * @param is
     * @return
     */
    public boolean isItemEqual(ItemStack is) {
        return base.equalsIgnoreTags(is) && base.getDamage() == is.getDamage();
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param ish
     * @return
     */
    public boolean isItemEqualIgnoreDamage(ItemStackHelper ish) {
        return this.base == ish.base;
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param is
     * @return
     */
    public boolean isItemEqualIgnoreDamage(ItemStack is) {
        return base == is;
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param ish
     * @return
     */
    public boolean isNBTEqual(ItemStackHelper ish) {
        return ItemStack.equalsIgnoreDamage(base, ish.getRaw());
    }
    
    /**
     * @since 1.1.3 [citation needed]
     * @param is
     * @return
     */
    public boolean isNBTEqual(ItemStack is) {
        return ItemStack.equalsIgnoreDamage(base, is);
    }

    /**
     * @since 1.6.5
     * @return
     */
    public boolean isOnCooldown() {
        return false;
    }

    /**
     * @since 1.6.5
     * @return
     */
    public float getCooldownProgress() {
        return 1f;
    }

    /**
     * @since 1.2.0
     * @return
     */
    public ItemStackHelper copy() {
        return new ItemStackHelper(base.copy());
    }
}
