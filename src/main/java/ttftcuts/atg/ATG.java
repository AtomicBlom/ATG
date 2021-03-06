package ttftcuts.atg;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ATG.MODID, version = ATG.VERSION)
public class ATG
{
    public static final String MODID = "atg";
    public static final String VERSION = "2";

    public static final Logger logger = LogManager.getLogger(MODID);

    @Mod.Instance(MODID)
    public static ATG instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new WorldTypeATG("atg");

        ATGBiomes.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
