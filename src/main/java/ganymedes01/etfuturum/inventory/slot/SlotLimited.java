package ganymedes01.etfuturum.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public class SlotLimited extends Slot {
    private final Predicate<ItemStack> limit;
    public SlotLimited(IInventory inv, int index, int x, int y, Predicate<ItemStack> limit) {
        super(inv, index, x, y);
        this.limit = limit;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return limit.test(stack);
    }
}
