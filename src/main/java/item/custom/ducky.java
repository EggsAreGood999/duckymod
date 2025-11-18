package item.custom;

import net.eggsaregood.duckymod.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

class ducky extends Item {

    // Correct constructor
    public ducky(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Play sound at the player's position
            level.playSound(
                    null,
                    player.blockPosition(),
                    ModSounds.DUCKY_RIGHTCLICK.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}