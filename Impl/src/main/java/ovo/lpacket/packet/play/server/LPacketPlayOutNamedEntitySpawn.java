package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutNamedEntitySpawn extends LPacket {

    private final int entityId;
    private final int posX;
    private final int posY;
    private final int posZ;

    public LPacketPlayOutNamedEntitySpawn(PacketContainer packetContainer) {
        StructureModifier<Integer> integers = packetContainer.getIntegers();

        this.entityId = integers.read(0);
        this.posX = integers.read(1);
        this.posY = integers.read(2);
        this.posZ = integers.read(3);
    }
}
