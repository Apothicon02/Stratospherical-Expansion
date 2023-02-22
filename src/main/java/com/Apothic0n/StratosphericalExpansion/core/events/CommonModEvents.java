package com.Apothic0n.StratosphericalExpansion.core.events;

import com.Apothic0n.StratosphericalExpansion.StratosphericalExpansion;
import com.Apothic0n.StratosphericalExpansion.world.dimension.StratoDimensions;
import com.Apothic0n.StratosphericalExpansion.world.dimension.StratoITeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = StratosphericalExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonModEvents {

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        MinecraftServer minecraftServer = player.getServer();
        Level level = player.level;
        if (minecraftServer != null) { //Do something to the player from the server every tick
            ServerPlayer serverPlayer = ((ServerPlayer) event.player);
            if (Level.OVERWORLD.equals(level.dimension())) { //Do something to the player from the server as long as they are in the overworld
                if (player.blockPosition().getY() >= 420) {
                    ArrayList teleporterData = StratoITeleporter.acsendFromOverworld(serverPlayer);
                    ServerPlayer newServerPlayer = (ServerPlayer) teleporterData.get(0);
                    BlockPos newPlayerPosition = (BlockPos) teleporterData.get(1);
                    newServerPlayer.teleportTo(minecraftServer.getLevel(StratoDimensions.StratoDim), newPlayerPosition.getX(), newPlayerPosition.getY(), newPlayerPosition.getZ(), 0, 0);
                }
            } else if (StratoDimensions.StratoDim.equals(level.dimension())) { //Do something to the player from the server as long as they are in the strato dimension
                if (player.blockPosition().getY() <= -64) {
                    ArrayList teleporterData = StratoITeleporter.fallToOverworld(serverPlayer);
                    ServerPlayer newServerPlayer = (ServerPlayer) teleporterData.get(0);
                    BlockPos newPlayerPosition = (BlockPos) teleporterData.get(1);
                    newServerPlayer.teleportTo(minecraftServer.getLevel(Level.OVERWORLD), newPlayerPosition.getX(), newPlayerPosition.getY(), newPlayerPosition.getZ(), 0, 0);
                }
            }
        }
    }
}
