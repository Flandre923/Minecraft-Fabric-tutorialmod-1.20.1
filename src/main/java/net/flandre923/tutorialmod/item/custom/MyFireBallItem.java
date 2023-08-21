package net.flandre923.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MyFireBallItem extends Item {
    public MyFireBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // 判断是否右键点击
        if (!world.isClient) {
            // 判断是否蓄力
            if (player.isUsingItem()) {
                int useTime = player.getItemUseTime();
                // 计算蓄力等级
                int chargeLevel = Math.min(20, useTime); // 最大蓄力时间为20 ticks
                // 计算火球发射的距离和攻击力
                double distance = chargeLevel * 0.5; // 假设每个tick增加0.5格距离
                float explosionPower = chargeLevel * 0.1f; // 假设每个tick增加0.1的爆炸威力

                // 创建火球实体并设置属性
                FireballEntity fireball = new FireballEntity(world, player, 1, 1, 1,6);
//                fireball.setProperties(player, player.pitch, player.yaw, 0.0F, (float) distance, 0.0F);

                // 发射火球
                world.spawnEntity(fireball);

                // 重置玩家的蓄力状态
                player.clearActiveItem();
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }
}
