package cn.nukkit.block;

import cn.nukkit.level.Level;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.Identifier;

import static cn.nukkit.block.BlockIds.AIR;

/**
 * Created by PetteriM1
 */
public class BlockWallBanner extends BlockBanner {

    public BlockWallBanner(Identifier id) {
        super(id);
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (this.getDamage() >= BlockFace.NORTH.getIndex() && this.getDamage() <= BlockFace.EAST.getIndex()) {
                if (this.getSide(BlockFace.fromIndex(this.getDamage()).getOpposite()).getId() == AIR) {
                    this.getLevel().useBreakOn(this);
                }
                return Level.BLOCK_UPDATE_NORMAL;
            }
        }
        return 0;
    }
}
