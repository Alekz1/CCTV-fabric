package net.lechkata.cctv.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import qouteall.imm_ptl.core.portal.Portal;
import qouteall.q_misc_util.MiscHelper;


public class TabletItem extends Item {
    public TabletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            createPortal((ServerWorld) world, user);

        }
        return super.use(world, user, hand);
    }
    public static void createPortal(ServerWorld world, PlayerEntity user){
        Portal portal = Portal.entityType.create(world);
        portal.setOriginPos(user.getPos());
        portal.setDestinationDimension(World.NETHER);
        portal.setDestination(new Vec3d(1000, 70, 1000));
        portal.setOrientationAndSize(
                new Vec3d(1, 0, 0), // axisW
                new Vec3d(0, 1, 0), // axisH
                4, // width
                4 // height
        );
        portal.world.spawnEntity(portal);
    }

}

