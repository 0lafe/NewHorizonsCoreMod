
package com.dreammaster.modhazardousitems;


import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.google.common.collect.EvictingQueue;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;
import eu.usrv.yamcore.auxiliary.ItemDescriptor;
import eu.usrv.yamcore.auxiliary.LogHelper;
import eu.usrv.yamcore.gameregistry.DamageTypeHelper;
import eu.usrv.yamcore.gameregistry.PotionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fluids.IFluidContainerItem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


/**
 * Eventhandler to apply configured Damage Values to player, if they have
 * certain items in their inventory
 * 
 * @author Namikon
 * 
 */
public class HazardousItemsHandler
{
  private Random _mRnd = new Random();
  private LogHelper _mLogger = MainRegistry.Logger;
  private HazardousItems _mHazardItemsCollection;
  private String _mConfigFileName;
  private HazardousObjectFactory _mHazFactory = new HazardousObjectFactory();
  private boolean IsConfigDirty = false;
  private int _mExecuteChance;
  private boolean _mRunProfiler;

  private EvictingQueue<Long> _mTimingQueue = EvictingQueue.create( 20 );
  private long _mLastAverage = 0;

  public HazardousItemsHandler()
  {
    _mRunProfiler = true;
    _mExecuteChance = 20;
    _mConfigFileName = String.format( "config/%s/HazardousItems.xml", Refstrings.COLLECTIONID );
  }

  public boolean HasConfigChanged()
  {
    return IsConfigDirty;
  }

  @SubscribeEvent
  public void onPlayerTick( TickEvent.PlayerTickEvent event )
  {
    if( event.player.worldObj.isRemote ) {
        return;
    }

    long tStart = System.currentTimeMillis();
    CheckInventoryForItems( event.player );
    CheckPlayerTouchesBlock( event.player );
    long tEnd = System.currentTimeMillis();

    _mTimingQueue.add(tEnd - tStart);

    // Should be called once a second...
    if( tEnd + 1000 > _mLastAverage && _mRunProfiler )
    {
      // is 250 a good value? I mean, 250ms for ONE LOOP is still pretty insane...
      if( getAverageTiming() > 250 )
      {
        // lol wut...
        if( _mExecuteChance > 500 )
        {
          _mLogger.error( "Execution chance is over 500. Not going to increase wait-timer anymore. if it still lags, contact me and we'll find another way" );
          _mRunProfiler = false;
          _mLogger.error( "HazardousItems-Profiler is now disabled" );
          return;
        }

        _mLogger.warn( "WARNING: The HazardousItems loop has an average timing of > 250ms, which may cause lag. Increasing wait-time between inventory-scan calls" );
        _mExecuteChance += 1;
        _mTimingQueue.clear(); // Reset queue to prevent re-warn on next call
      }
      else
      {
        // All good, loop seems to be fast enough
        _mLastAverage = System.currentTimeMillis();
      }

    }
  }

  private long getAverageTiming()
  {
    if( _mTimingQueue == null || _mTimingQueue.isEmpty() ) {
        return 0;
    }

    // Only do average calc once we have 20 elements
    if( _mTimingQueue.remainingCapacity() != 0 ) {
        return 0;
    }

    long sum = 0;
    for( long time : _mTimingQueue ) {
        sum += time;
    }

    return sum / _mTimingQueue.size();
  }

  public void InitSampleConfig()
  {
    // Create new DamageEffect
    HazardousItems.ItmDamageEffect tFireEffect = _mHazFactory.createDamageEffect( 0.5F, "inFire" );

    // Create new Potioneffect
    HazardousItems.ItmPotionEffect tPoisonPotion = _mHazFactory.createPotionEffect( 100, Potion.poison.id, 1 );

    // Define a testitem to hold these effects
    HazardousItems.HazardousItem tHazItem = _mHazFactory.createHazardousItemsHazardousItem( "tfarcenim:stone", true, true, true );

    HazardousItems.HazardousFluid tHazFluid = _mHazFactory.createHazardousFluid( "tfarcenim:water", true, true, true );

    // Add both effects to our defined testItem
    tHazItem.getDamageEffects().add( tFireEffect );
    tHazItem.getPotionEffects().add( tPoisonPotion );

    tHazFluid.getDamageEffects().add( tFireEffect );
    tHazFluid.getPotionEffects().add( tPoisonPotion );

    _mHazardItemsCollection = new HazardousItems();
    _mHazardItemsCollection.getHazardousItems().add( tHazItem );
    _mHazardItemsCollection.getHazardousFluids().add( tHazFluid );
  }

  /**
   * Save hazardous items to disk, overwriting any existing xml file
   *
   * @return
   */
  public boolean SaveHazardousItems()
  {
    try
    {
      JAXBContext tJaxbCtx = JAXBContext.newInstance( HazardousItems.class );
      Marshaller jaxMarsh = tJaxbCtx.createMarshaller();
      jaxMarsh.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
      jaxMarsh.marshal( _mHazardItemsCollection, new FileOutputStream( _mConfigFileName, false ) );

      _mLogger.debug( "Config file written" );
      IsConfigDirty = false;
      return true;
    }
    catch( Exception e )
    {
      _mLogger.error( "Unable to create new HazardousItems.xml. What did you do??" );
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Add new DamageEffect to new or existing item (Must be exact-match)
   *
   * @param pItem
   * The item in question
   * @param pDamageSource
   * The source (must be a valid one)
   * @param pDamageAmount
   * The amount. 1.0F equals 1 Heart
   * @return
   */
  /*
   * public boolean AddDamageEffectToItem(ItemStack pItem, String
   * pDamageSource, float pDamageAmount) { boolean tResult = false; try { if
   * (!DamageTypeHelper.IsValidDamageSource(pDamageSource)) return false;
   * if (_mHazardItemsCollection == null) { _mLogger.info("It is .. null??");
   * return false; }
   * HazardousItem hi = _mHazardItemsCollection.FindHazardousItem(pItem); if
   * (hi == null) hi =
   * _mHazFactory.createHazardousItemsHazardousItem(pItem.getUnlocalizedName
   * (), true, true, true);
   * ItmDamageEffect tNewDE = _mHazFactory.createDamageEffect(pDamageAmount,
   * pDamageSource); hi.getDamageEffects().add(tNewDE);
   * _mHazardItemsCollection.getHazardousItems().add(hi); IsConfigDirty =
   * true;
   * _mLogger.info(String.format(
   * "Added new Item %s to HazardousItems list with DamageSource: %s DamageAmount: %s"
   * , pItem.getUnlocalizedName(), pDamageSource, pDamageAmount)); tResult =
   * true; } catch (Exception e) { _mLogger.error(String.format(
   * "Something went wrong while processing AddPotionEffectToItem for Item %s"
   * , pItem.getUnlocalizedName())); e.printStackTrace(); }
   * return tResult; }
   */

  /**
   * Add new PotionEffect to new or existing item (Must be exact-match)
   *
   * @param pItem
   * The item in question
   * @param pPotionID
   * The potionID (must be valid
   * @param pTickDuration
   * The number of ticks this potion will run, one the item is
   * dropped. 20 ticks equals 1 second
   * @param pLevel
   * The level. Note: Offset is 1, so pLevel = 0 equals Potion
   * Level I
   * @return
   */
  /*
   * public boolean AddPotionEffectToItem(ItemStack pItem, int pPotionID, int
   * pTickDuration, int pLevel) { boolean tResult = false; try { if
   * (!PotionHelper.IsValidPotionID(pPotionID)) return false;
   * HazardousItem hi = _mHazardItemsCollection.FindHazardousItem(pItem); if
   * (hi == null) hi =
   * _mHazFactory.createHazardousItemsHazardousItem(pItem.getUnlocalizedName
   * (), true, true, true);
   * ItmPotionEffect tNewPE = _mHazFactory.createPotionEffect(pTickDuration,
   * pPotionID, pLevel); hi.getPotionEffects().add(tNewPE);
   * _mHazardItemsCollection.getHazardousItems().add(hi); IsConfigDirty =
   * true;
   * _mLogger.info(String.format(
   * "Added new Item %s to HazardousItems list with PotionID: %d TickDuration: %d Level %d"
   * , pItem.getUnlocalizedName(), pPotionID, pTickDuration, pLevel)); tResult
   * = true; } catch (Exception e) { _mLogger.error(String.format(
   * "Something went wrong while processing AddPotionEffectToItem for Item %s"
   * , pItem.getUnlocalizedName())); e.printStackTrace(); }
   * return tResult; }
   */

  /**
   * Initial Loading of config with automatic creation of default xml
   */
  public void LoadConfig()
  {
    _mLogger.debug( "HazardousItems entering state: LOAD CONFIG" );
    File tConfigFile = new File( _mConfigFileName );
    if( !tConfigFile.exists() )
    {
      _mLogger.debug( "HazardousItems Config file not found, assuming first-start. Creating default one" );
      InitSampleConfig();
      SaveHazardousItems();
    }

    // Fix for broken XML file; If it can't be loaded on reboot, keep it
    // there to be fixed, but load
    // default setting instead, so an Op/Admin can do reload ingame
    if( !ReloadHazardousItems() )
    {
      _mLogger.warn( "Configuration File seems to be damaged, loading does-nothing-evil default config. You should fix your file and reload it" );
      MainRegistry.AddLoginError( "[HazardousItems] Config file not loaded due errors" );
      InitSampleConfig();
    }
  }

  /**
   * Reload item configuration from disk. Will overwrite current List without
   * restart, if the config file is valid
   *
   * @return
   */
  public boolean ReloadHazardousItems()
  {
    boolean tResult = false;

    _mLogger.debug( "HazardousItemsHandler will now try to load it's configuration" );
    try
    {
      JAXBContext tJaxbCtx = JAXBContext.newInstance( HazardousItems.class );
      File tConfigFile = new File( _mConfigFileName );
      Unmarshaller jaxUnmarsh = tJaxbCtx.createUnmarshaller();
      HazardousItems tNewItemCollection = (HazardousItems) jaxUnmarsh.unmarshal( tConfigFile );
      _mLogger.debug( "Config file has been loaded. Entering Verify state" );

      if( VerifyConfiguredDamageEffects( tNewItemCollection ) && VerifyConfiguredPotionEffects( tNewItemCollection ) )
      {
        _mHazardItemsCollection = tNewItemCollection; // Configuration verified, activate now
        IsConfigDirty = false;
        tResult = true;
      }

    }
    catch( Exception e )
    {
      e.printStackTrace();
    }

    return tResult;
  }

  /**
   * Verify defined DamageEffects in configfile
   *
   * @param pCollection
   * @return true if everything is ok
   */
  public boolean VerifyConfiguredDamageEffects( HazardousItems pItemCollection )
  {
    boolean tResult = true;
    for( HazardousItems.HazardousItem hi : pItemCollection.getHazardousItems() )
    {
      for( HazardousItems.ItmDamageEffect ide : hi.getDamageEffects() )
      {
        if( !DamageTypeHelper.IsValidDamageSource( ide.getDamageSource() ) )
        {
          _mLogger.warn( String.format( "HazardousItem [%s] has invalid DamageSource entry: [%s]", hi.getItemName(), ide.getDamageSource() ) );
          tResult = false;
        }
      }
    }
    for( HazardousItems.HazardousFluid hf : pItemCollection.getHazardousFluids() )
    {
      for( HazardousItems.ItmDamageEffect ide : hf.getDamageEffects() )
      {
        if( !DamageTypeHelper.IsValidDamageSource( ide.getDamageSource() ) )
        {
          _mLogger.warn( String.format( "HazardousFluid [%s] has invalid DamageSource entry: [%s]", hf.getFluidName(), ide.getDamageSource() ) );
          tResult = false;
        }
      }
    }

    return tResult;
  }

  /**
   * Verify defined potioneffects in configfile
   *
   * @param pCollection
   * @return true if everything is ok
   */
  public boolean VerifyConfiguredPotionEffects( HazardousItems pItemCollection )
  {
    boolean tResult = true;
    for( HazardousItems.HazardousItem hi : pItemCollection.getHazardousItems() )
    {
      for( HazardousItems.ItmPotionEffect ipe : hi.getPotionEffects() )
      {
        if( !PotionHelper.IsValidPotionID( ipe.getId() ) )
        {
          _mLogger.warn( String.format( "HazardousItem [%s] has invalid PotionID: [%s] (There is no such potion)", hi.getItemName(), ipe.getId() ) );
          tResult = false;
        }
      }
    }

    for( HazardousItems.HazardousFluid hf : pItemCollection.getHazardousFluids() )
    {
      for( HazardousItems.ItmPotionEffect ipe : hf.getPotionEffects() )
      {
        if( !PotionHelper.IsValidPotionID( ipe.getId() ) )
        {
          _mLogger.warn( String.format( "HazardousFluid [%s] has invalid PotionID: [%s] (There is no such potion)", hf.getFluidName(), ipe.getId() ) );
          tResult = false;
        }
      }
    }

    return tResult;
  }

  /**
   * Check if player actually swims in a fluid
   *
   * @param pPlayer
   */
  private void CheckPlayerTouchesBlock( EntityPlayer pPlayer )
  {
    if( _mRnd.nextInt( _mExecuteChance ) != 0 ) {
        return;
    }

    try
    {
      int blockX = MathHelper.floor_double( pPlayer.posX );
      int blockY = MathHelper.floor_double( pPlayer.boundingBox.minY );
      int blockZ = MathHelper.floor_double( pPlayer.posZ );
      Block pBlockContact = pPlayer.worldObj.getBlock( blockX, blockY, blockZ );
      Block pBlockUnderFeet = pPlayer.worldObj.getBlock( blockX, blockY - 1, blockZ );
      UniqueIdentifier tUidContact = GameRegistry.findUniqueIdentifierFor( pBlockContact );
      UniqueIdentifier tUidFeet = GameRegistry.findUniqueIdentifierFor( pBlockUnderFeet );

      // Skip air block and null results
      if( tUidContact != null && tUidContact.toString() != "minecraft:air" )
      {
        HazardousItems.HazardousFluid hf = _mHazardItemsCollection.FindHazardousFluidExact( tUidContact.toString() );
        if( hf != null && hf.getCheckContact() ) {
            DoHIEffects(hf, pPlayer);
        }
      }

      if( tUidFeet != null && tUidFeet.toString() != "minecraft:air" )
      {
        HazardousItems.HazardousItem hi = _mHazardItemsCollection.FindHazardousItemExact( tUidFeet.toString() );
        if( hi != null && hi.getCheckContact() ) {
            DoHIEffects(hi, pPlayer);
        }
      }
    }
    catch( Exception e )
    {
      _mLogger.error( "HazardousItemsHandler.CheckPlayerTouchesBlock.error", "Something bad happend while processing the onPlayerTick event" );
      e.printStackTrace();
    }
  }

  private void CheckInventoryForItems( EntityPlayer pPlayer )
  {
    if( _mRnd.nextInt( _mExecuteChance ) != 0 ) {
        return;
    }

    try
    {
      ItemStack[] tPlayerInventory = pPlayer.inventory.mainInventory;
      String tCurrIS = "";

      for( ItemStack is : tPlayerInventory )
      {
        try
        // Safe-loop to enforce dangerous items even if something bad
        // happens here
        {
          if( is == null ) {
              continue;
          }

          tCurrIS = ItemDescriptor.fromStack( is ).toString();

          // Check if item is a fluid container
          if( is.getItem() instanceof IFluidContainerItem )
          {
            HazardousItems.HazardousFluid hf = _mHazardItemsCollection.FindHazardousFluid( is );
            if( hf != null && hf.getCheckInventory() ) {
                DoHIEffects(hf, pPlayer);
            }
          }
          // Tinkers' construct smeltery tank
          else if("tconstruct.smeltery.itemblocks.LavaTankItemBlock".equals(is.getItem().getClass().getName()))
          {
            // _mLogger.info("Found lavatank");
            NBTTagCompound tNBT = is.getTagCompound();
            if( tNBT != null && tNBT.hasKey( "Fluid" ) )
            {
              // _mLogger.info("...Has NBT 'Fluid'...");
              NBTTagCompound tFluidCompound = tNBT.getCompoundTag( "Fluid" );
              if( tFluidCompound != null && tFluidCompound.hasKey( "FluidName" ) )
              {
                // _mLogger.info("...Has NBT 'FluidName'...");
                String tFluidName = tFluidCompound.getString( "FluidName" );
                if( tFluidName != null && !tFluidName.isEmpty())
                {
                  // _mLogger.info("...Finding Hazardous Fluids...");
                  HazardousItems.HazardousFluid hf = _mHazardItemsCollection.FindHazardousFluidExact( tFluidName );
                  if( hf != null && hf.getCheckInventory() )
                  {
                    // _mLogger.info("...Found Hazardous Fluids");
                    DoHIEffects( hf, pPlayer );
                  }
                  // else
                  // _mLogger.info("...Not found Hazardous Fluids");
                }
              }
              // else
              // _mLogger.info("...Has no NBT 'FluidName'");
            }
            // else
            // _mLogger.info("...Has no NBT 'Fluid'");
          }
          else
          {
            HazardousItems.HazardousItem hi = _mHazardItemsCollection.FindHazardousItem( is );
            if( hi != null && hi.getCheckInventory() ) {
                DoHIEffects(hi, pPlayer);
            }
          }
        }
        catch( Exception e )
        {
          _mLogger.debug( String.format( "Something weird happend with item %s", tCurrIS ) );
          // Silently catching exception and continue
          continue;
        }
      }
    }
    catch( Exception e )
    {
      _mLogger.error( "HazardousItemsHandler.CheckInventoryForItems.error", "Something bad happend while processing the onPlayerTick event" );
      e.printStackTrace();
    }
  }

  private void DoHIEffects( IDamageEffectContainer pHI, EntityPlayer pPlayer )
  {
    // Attack player based on all defined items
    for( HazardousItems.ItmDamageEffect iDE : pHI.getDamageEffects() ) {
        pPlayer.attackEntityFrom(DamageTypeHelper.ParseStringToDamageSource(iDE.getDamageSource()), iDE.getAmount());
    }

    for( HazardousItems.ItmPotionEffect iPE : pHI.getPotionEffects() ) {
        pPlayer.addPotionEffect(new PotionEffect(iPE.getId(), iPE.getDuration(), iPE.getLevel()));
    }
  }
  /*
   * public boolean RemoveItemFromList(ItemStack pInHand, boolean
   * pIncludeNonExact) { try { return
   * _mHazardItemsCollection.RemoveItemExact(pInHand, pIncludeNonExact); }
   * catch (Exception e) { e.printStackTrace(); return false; } }
   */
}
