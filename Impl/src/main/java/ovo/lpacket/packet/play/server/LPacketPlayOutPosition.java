package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutPosition extends LPacket {

    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;

    public LPacketPlayOutPosition(PacketContainer packetContainer) {
        StructureModifier<Double> doubles = packetContainer.getDoubles();
        StructureModifier<Float> floats = packetContainer.getFloat();

        this.x = doubles.read(0);
        this.y = doubles.read(1);
        this.z = doubles.read(2);
        this.yaw = floats.read(0);
        this.pitch = floats.read(1);
    }
}
