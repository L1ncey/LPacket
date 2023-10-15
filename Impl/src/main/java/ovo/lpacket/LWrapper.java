package ovo.lpacket;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import lombok.SneakyThrows;
import ovo.lpacket.packet.play.client.*;
import ovo.lpacket.packet.play.server.*;
import ovo.lpacket.utils.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class LWrapper {
    private static final Map<PacketType, Constructor<? extends LPacket>> PACKET_MAP = new HashMap<>();

    static {
//        Packet.Play.Client
        PACKET_MAP.put(PacketType.Play.Client.ABILITIES, getConstructor(LPacketPlayInAbilities.class));
        PACKET_MAP.put(PacketType.Play.Client.KEEP_ALIVE, getConstructor(LPacketPlayInKeepAlive.class));
        PACKET_MAP.put(PacketType.Play.Client.ARM_ANIMATION, getConstructor(LPacketPlayInArmAnimation.class));
        PACKET_MAP.put(PacketType.Play.Client.BLOCK_DIG, getConstructor(LPacketPlayInBlockDig.class));
        PACKET_MAP.put(PacketType.Play.Client.BLOCK_PLACE, getConstructor(LPacketPlayInBlockPlace.class));
        PACKET_MAP.put(PacketType.Play.Client.CHAT, getConstructor(LPacketPlayInChat.class));
        PACKET_MAP.put(PacketType.Play.Client.CLIENT_COMMAND, getConstructor(LPacketPlayInClientCommand.class));
        PACKET_MAP.put(PacketType.Play.Client.CLOSE_WINDOW, getConstructor(LPacketPlayInCloseWindow.class));
        PACKET_MAP.put(PacketType.Play.Client.ENCHANT_ITEM, getConstructor(LPacketPlayInEnchantItem.class));
        PACKET_MAP.put(PacketType.Play.Client.ENTITY_ACTION, getConstructor(LPacketPlayInEntityAction.class));
        PACKET_MAP.put(PacketType.Play.Client.FLYING, getConstructor(LPacketPlayInFlying.class));
        PACKET_MAP.put(PacketType.Play.Client.LOOK, getConstructor(LPacketPlayInLook.class));
        PACKET_MAP.put(PacketType.Play.Client.POSITION, getConstructor(LPacketPlayInPosition.class));
        PACKET_MAP.put(PacketType.Play.Client.POSITION_LOOK, getConstructor(LPacketPlayInPositionLook.class));
        PACKET_MAP.put(PacketType.Play.Client.RESOURCE_PACK_STATUS, getConstructor(LPacketPlayInResourcePackStatus.class));
        PACKET_MAP.put(PacketType.Play.Client.SET_CREATIVE_SLOT, getConstructor(LPacketPlayInSetCreativeSlot.class));
        PACKET_MAP.put(PacketType.Play.Client.SETTINGS, getConstructor(LPacketPlayInSettings.class));
        PACKET_MAP.put(PacketType.Play.Client.STEER_VEHICLE, getConstructor(LPacketPlayInSteerVehicle.class));
        PACKET_MAP.put(PacketType.Play.Client.TAB_COMPLETE, getConstructor(LPacketPlayInTabComplete.class));

//        in modern version (1.12+ idk), itz PONG not TRANSLATION
        PACKET_MAP.put(PacketType.Play.Client.TRANSACTION, getConstructor(LPacketPlayInTransaction.class));
//        PACKET_MAP.put(PacketType.Play.Client.TRANSACTION, getConstructor(LPacketPlayInTransaction.class));

        PACKET_MAP.put(PacketType.Play.Client.UPDATE_SIGN, getConstructor(LPacketPlayInUpdateSign.class));
        PACKET_MAP.put(PacketType.Play.Client.USE_ENTITY, getConstructor(LPacketPlayInUseEntity.class));
        PACKET_MAP.put(PacketType.Play.Client.WINDOW_CLICK, getConstructor(LPacketPlayInWindowClick.class));
        PACKET_MAP.put(PacketType.Play.Client.HELD_ITEM_SLOT, getConstructor(LPacketPlayInHeldItemSlot.class));

//        Packet.Play.Server
        PACKET_MAP.put(PacketType.Play.Server.ENTITY_VELOCITY, getConstructor(LPacketPlayOutEntityVelocity.class));
        PACKET_MAP.put(PacketType.Play.Server.KEEP_ALIVE, getConstructor(LPacketPlayOutKeepAlive.class));
        PACKET_MAP.put(PacketType.Play.Server.NAMED_ENTITY_SPAWN, getConstructor(LPacketPlayOutNamedEntitySpawn.class));
        PACKET_MAP.put(PacketType.Play.Server.POSITION, getConstructor(LPacketPlayOutPosition.class));

//        in modern version (1.12+ idk), itz PING not TRANSLATION
        PACKET_MAP.put(PacketType.Play.Server.TRANSACTION, getConstructor(LPacketPlayOutTransaction.class));
//        PACKET_MAP.put(PacketType.Play.Server.TRANSACTION, getConstructor(LPacketPlayOutTransaction.class));

        PACKET_MAP.put(PacketType.Play.Server.ABILITIES, getConstructor(LPacketPlayOutAbilities.class));
        PACKET_MAP.put(PacketType.Play.Server.ENTITY_DESTROY, getConstructor(LPacketPlayOutDestoryEntity.class));
        PACKET_MAP.put(PacketType.Play.Server.OPEN_WINDOW, getConstructor(LPacketPlayOutOpenWindow.class));
        PACKET_MAP.put(PacketType.Play.Server.HELD_ITEM_SLOT, getConstructor(LPacketPlayOutHeldItemSlot.class));
        PACKET_MAP.put(PacketType.Play.Server.CLOSE_WINDOW, getConstructor(LPacketPlayOutCloseWindow.class));


//        更新在7/8/2023
//        使用了相对较好的解决办法 (LPacketPlayOutEntity)

//        更新在8/8/2023
//        使用了更好的方法， 原方法注释以供参考
        PACKET_MAP.put(PacketType.Play.Server.ENTITY, getConstructor(LPacketPlayOutEntity.class));
        PACKET_MAP.put(PacketType.Play.Server.REL_ENTITY_MOVE, getConstructor(PacketPlayOutRelEntityMove.class));
        PACKET_MAP.put(PacketType.Play.Server.REL_ENTITY_MOVE_LOOK, getConstructor(PacketPlayOutRelEntityMoveLook.class));
        PACKET_MAP.put(PacketType.Play.Server.ENTITY_LOOK, getConstructor(PacketPlayOutEntityLook.class));

        PACKET_MAP.put(PacketType.Play.Server.ENTITY_TELEPORT, getConstructor(LPacketPlayOutEntityTeleport.class));
        PACKET_MAP.put(PacketType.Play.Server.EXPLOSION, getConstructor(LPacketPlayOutExplosion.class));
    }

    @SneakyThrows
    private static <T extends LPacket> Constructor<T> getConstructor(Class<T> clazz) {return clazz.getDeclaredConstructor(PacketContainer.class);}

//    将能用到的包打个包传递出去，从ProtocolLib获得。
    public static PacketType[] getProcessedPackets() {return PACKET_MAP.keySet().toArray(new PacketType[0]);}

    @SneakyThrows
    public static LPacket wrap(PacketType packetType, PacketContainer packetContainer) {
        LPacket packet = null;

        try {

            packet = PACKET_MAP.get(packetType).newInstance(packetContainer);

        } catch (InvocationTargetException exception) {

            StringUtil.consoleMsg.alert("&cLPacket error!");
            StringUtil.consoleMsg.alert("&bReason: &fPacket type didn't match the class file");
            StringUtil.consoleMsg.alert("&bTarget: &f" + packetContainer.getType().toString());

        } catch (ClassCastException exception) {

            StringUtil.consoleMsg.alert("&cLPacket error!");
            StringUtil.consoleMsg.alert("&bReason: &fData type exception  | eg.( Long -> int )");
            StringUtil.consoleMsg.alert("&bTarget: &f" + packetContainer.getType().toString());

        }
        return packet;
    }
}