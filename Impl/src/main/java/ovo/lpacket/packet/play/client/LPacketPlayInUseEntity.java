package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.util.Vector;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInUseEntity extends LPacket {

    private final int entityId;
    private final EnumWrappers.EntityUseAction action;
    private final Vector hitVec;

    public LPacketPlayInUseEntity(PacketContainer packetContainer) {
        this.entityId = packetContainer.getIntegers().read(0);
        this.action = packetContainer.getEntityUseActions().read(0);
        this.hitVec = packetContainer.getVectors().read(0);
    }
}
