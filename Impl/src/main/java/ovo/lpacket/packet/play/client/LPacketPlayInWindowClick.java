package ovo.lpacket.packet.play.client;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayInWindowClick extends LPacket {

    private final int windowId;
    private final int slotId;
    private final int usedButton;
    private final short actionNumber;
    private final ItemStack clickedItem;
    private final int mode;

    public LPacketPlayInWindowClick(PacketContainer packetContainer) {
        StructureModifier<Integer> integers = packetContainer.getIntegers();

        this.windowId = integers.read(0);
        this.slotId = integers.read(1);
        this.usedButton = integers.read(2);
        this.actionNumber = packetContainer.getShorts().read(0);
        this.clickedItem = packetContainer.getItemModifier().read(0);
        this.mode = integers.read(3);

    }
}