package cn.nukkit.blockentity;

import cn.nukkit.block.BlockIds;
import cn.nukkit.level.chunk.Chunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class BlockEntityBanner extends BlockEntitySpawnable {

    public BlockEntityBanner(Chunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public boolean isBlockEntityValid() {
        return this.getBlock().getId() == BlockIds.WALL_BANNER || this.getBlock().getId() == BlockIds.STANDING_BANNER;
    }

    @Override
    public String getName() {
        return "Banner";
    }

    public int getBaseColor() {
        return this.namedTag.getInt("Base");
    }

    public void setBaseColor(int color) {
        this.namedTag.putInt("Base", color & 0x0f);
    }

    public int getType() {
        return this.namedTag.getInt("Type");
    }

    public void setType(int type) {
        this.namedTag.putInt("Type", type);
    }

    @Override
    public CompoundTag getSpawnCompound() {
        return getDefaultCompound(this, BANNER)
                .putInt("Base", getBaseColor())
                .putList(namedTag.getList("Patterns"))
                .putInt("Type", getType());
    }
}
