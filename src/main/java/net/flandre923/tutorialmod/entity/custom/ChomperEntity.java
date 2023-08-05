package net.flandre923.tutorialmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ChomperEntity extends HostileEntity implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    public ChomperEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.4f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1,new SwimGoal(this));
        this.goalSelector.add(2,new MeleeAttackGoal(this,1.2D,false));
        this.goalSelector.add(3,new WanderAroundFarGoal(this,0.75f,1));
        this.goalSelector.add(4,new LookAroundGoal(this));

        this.targetSelector.add(2,new ActiveTargetGoal<>(this, PlayerEntity.class,true));
        this.targetSelector.add(2,new ActiveTargetGoal<>(this, MerchantEntity.class,true));
        this.targetSelector.add(3,new ActiveTargetGoal<>(this, ChickenEntity.class,true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState){
       if (tAnimationState.isMoving()){
           tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.chomper.walk",
                   Animation.LoopType.LOOP));
           return PlayState.CONTINUE;
       }
       tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.chomper.idle",
               Animation.LoopType.LOOP));
       return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP,0.15f,1.0f);
    }


}
