package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.BlockPosition;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInBlockPlace extends LPacket {

    private final BlockPosition blockPosition;
    private final int face;
    private final ItemStack itemStack;
    private final float facingX;
    private final float facingY;
    private final float facingZ;

    public LPacketPlayInBlockPlace(PacketContainer packetContainer) {
        this.blockPosition = packetContainer.getBlockPositionModifier().read(0);
        this.face = packetContainer.getIntegers().read(0);
        this.itemStack = packetContainer.getItemModifier().read(0);

        StructureModifier<Float> floats = packetContainer.getFloat();

        this.facingX = floats.read(0);
        this.facingY = floats.read(1);
        this.facingZ = floats.read(2);
    }
}
