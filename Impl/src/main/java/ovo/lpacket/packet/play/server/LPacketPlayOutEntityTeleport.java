package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutEntityTeleport extends LPacket {

    private final byte Yaw, Pitch;
    private final int EntityId, X, Y, Z;
    private final boolean OnGround;

    public LPacketPlayOutEntityTeleport(PacketContainer packetContainer) {
        StructureModifier<Boolean> booleans = packetContainer.getBooleans();
        StructureModifier<Byte> bytes = packetContainer.getBytes();
        StructureModifier<Integer> ints = packetContainer.getIntegers();

        this.X = ints.read(1);
        this.Y = ints.read(2);
        this.Z = ints.read(3);
        this.Yaw = bytes.read(0);
        this.Pitch = bytes.read(1);
        this.EntityId = ints.read(0);
        this.OnGround = booleans.read(0);
    }

    public double getValueX() {
        return X / 32.D;
    }

    public double getValueY() {
        return Y / 32.D;
    }

    public double getValueZ() {
        return Z / 32.D;
    }

    public float getValueYaw() {
        return (Yaw * 360.0F / 256.0F);
    }

    public float getValuePitch() {
        return (Pitch * 360.0F / 256.0F);
    }
}
