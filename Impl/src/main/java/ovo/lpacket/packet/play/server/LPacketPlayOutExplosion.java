package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.BlockPosition;
import lombok.Getter;
import ovo.lpacket.LPacket;

import java.util.List;

@Getter
public class LPacketPlayOutExplosion extends LPacket {

    private double posX;
    private double posY;
    private double posZ;
    private float strength;
    private List<BlockPosition> affectedBlockPositions;
    private float motionX;
    private float motionY;
    private float motionZ;

    public LPacketPlayOutExplosion(PacketContainer packetContainer) {
        StructureModifier<Double> doubles = packetContainer.getDoubles();
        StructureModifier<Float> floats = packetContainer.getFloat();
        StructureModifier<List<BlockPosition>> blocks = packetContainer.getBlockPositionCollectionModifier();

        this.posX = doubles.read(0);
        this.posY = doubles.read(1);
        this.posZ = doubles.read(2);

        this.affectedBlockPositions = blocks.read(0);

        this.strength = floats.read(0);
        this.motionX = floats.read(1);
        this.motionY = floats.read(2);
        this.motionZ = floats.read(3);



    }
}
