package ovo.lpacket.packet.play.server;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import ovo.lpacket.LPacket;

@Getter
public class LPacketPlayOutEntity extends LPacket {

    private byte X, Y, Z, Yaw, Pitch;
    private int EntityId;
    private boolean onGround, Rodation, hasPos, hasLook;

    public LPacketPlayOutEntity(PacketContainer packetContainer) {
        StructureModifier<Integer> ints = packetContainer.getIntegers();
        StructureModifier<Boolean> booleans = packetContainer.getBooleans();
        StructureModifier<Byte> bytes = packetContainer.getBytes();

        this.EntityId = ints.read(0);

        this.X = bytes.read(0);
        this.Y = bytes.read(1);
        this.Z = bytes.read(2);
        this.Yaw = bytes.read(3);
        this.Pitch = bytes.read(4);

        this.onGround = booleans.read(0);
        this.Rodation = booleans.read(1);

//        更好的方法已经发现且应用， 该方法 （ID） 注释以供后人参考
//        :P

//        请注意： ProtocolLib传递的 packet 不存在以下情况， 仅供参考！！！
/*
        switch (packetContainer.getId()) {

            //SPacketEntity
            case 245: {
                StructureModifier<Integer> ints = packetContainer.getIntegers();

                this.EntityId = ints.read(0);
            }

            //Entity$PacketPlayOutRelEntityMove
            case 43: {
                StructureModifier<Boolean> booleans = packetContainer.getBooleans();
                StructureModifier<Byte> bytes = packetContainer.getBytes();
                this.X = bytes.read(0);
                this.Y = bytes.read(1);
                this.Z = bytes.read(2);

                this.onGround = booleans.read(0);
                this.hasPos = true;
            }

            //Entity$PacketPlayOutRelEntityMoveLook
            case 44: {
                StructureModifier<Boolean> booleans = packetContainer.getBooleans();
                StructureModifier<Byte> bytes = packetContainer.getBytes();
                this.X = bytes.read(0);
                this.Y = bytes.read(1);
                this.Z = bytes.read(2);
                this.Yaw = bytes.read(3);
                this.Pitch = bytes.read(4);

                this.onGround = booleans.read(0);
                this.hasPos = this.hasLook = true;
            }

            //Entity$PacketPlayOutEntityLook
            case 45: {
                StructureModifier<Boolean> booleans = packetContainer.getBooleans();
                StructureModifier<Byte> bytes = packetContainer.getBytes();
                this.Yaw = bytes.read(0);
                this.Pitch = bytes.read(1);

                this.onGround = booleans.read(0);
                this.hasLook = true;
            }
        }*/
    }

    public LPacketPlayOutEntity (int id) {}

    public void accept(byte x, byte y, byte z, boolean ground) {
        this.X = x;
        this.Y = y;
        this.Z = z;

        this.onGround = ground;
        this.hasPos = true;
    }

    public void accept(byte yaw, byte pitch, boolean ground) {
        this.Yaw = yaw;
        this.Pitch = pitch;

        this.onGround = ground;
        this.hasLook = true;
    }

    public void accept(byte x, byte y, byte z, byte yaw, byte pitch, boolean ground) {
        this.X = x;
        this.Y = y;
        this.Z = z;
        this.Yaw = yaw;
        this.Pitch = pitch;

        this.onGround = ground;
        this.hasPos = this.hasLook = true;
    }
}

