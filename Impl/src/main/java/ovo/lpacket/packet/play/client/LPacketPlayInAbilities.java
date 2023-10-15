package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInAbilities extends LPacket {

    private final boolean invulnerable;
    private final boolean flying;
    private final boolean canFly;
    private final boolean canInstantlyBuild;
    private final float flySpeed;
    private final float walkSpeed;

    public LPacketPlayInAbilities(PacketContainer packetContainer) {
        StructureModifier<Boolean> booleans = packetContainer.getBooleans();
        StructureModifier<Float> floats = packetContainer.getFloat();

        this.invulnerable = booleans.read(0);
        this.flying = booleans.read(1);
        this.canFly = booleans.read(2);
        this.canInstantlyBuild = booleans.read(3);
        this.flySpeed = floats.read(0);
        this.walkSpeed = floats.read(1);
    }
}
