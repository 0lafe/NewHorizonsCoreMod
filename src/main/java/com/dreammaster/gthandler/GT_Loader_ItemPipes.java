package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.GT_MetaPipeEntity_Item;
import gregtech.api.util.GT_OreDictUnificator;


public class GT_Loader_ItemPipes {


    public static void registerPipes() {

        // These IDs are totally messed up. Watch out if you want to add or change something here!

        // Brass
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Brass), new GT_MetaPipeEntity_Item(5600, "GT_Pipe_Brass_Tiny", "Tiny %material Item Pipe", 0.25F, Materials.Brass, 1, 131072, false, 80).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Brass), new GT_MetaPipeEntity_Item(5601, "GT_Pipe_Brass_Small", "Small %material Item Pipe", 0.375F, Materials.Brass, 1, 65536, false, 40).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Brass), new GT_MetaPipeEntity_Item(5640, "GT_Pipe_Restrictive_Brass_Tiny", "Tiny Restrictive %material Item Pipe", 0.25F, Materials.Brass, 1, 13107200, true, 80).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Brass), new GT_MetaPipeEntity_Item(5641, "GT_Pipe_Restrictive_Brass_Small", "Small Restrictive %material Item Pipe", 0.375F, Materials.Brass, 1, 6553600, true, 40).getStackForm(1L));

        // Electrum
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Electrum), new GT_MetaPipeEntity_Item(5610, "GT_Pipe_Electrum_Tiny", "Tiny %material Item Pipe", 0.25F, Materials.Electrum, 1, 65536, false, 40).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Electrum), new GT_MetaPipeEntity_Item(5611, "GT_Pipe_Electrum_Small", "Small %material Item Pipe", 0.375F, Materials.Electrum, 1, 32768, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Electrum), new GT_MetaPipeEntity_Item(5642, "GT_Pipe_Restrictive_Electrum_Tiny", "Tiny Restrictive %material Item Pipe", 0.25F, Materials.Electrum, 1, 6553600, true, 40).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Electrum), new GT_MetaPipeEntity_Item(5643, "GT_Pipe_Restrictive_Electrum_Small", "Small Restrictive %material Item Pipe", 0.375F, Materials.Electrum, 1, 3276800, true).getStackForm(1L));

        // Platinum
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Platinum), new GT_MetaPipeEntity_Item(5620, "GT_Pipe_Platinum_Tiny", "Tiny %material Item Pipe", 0.25F, Materials.Platinum, 1, 32768, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Platinum), new GT_MetaPipeEntity_Item(5621, "GT_Pipe_Platinum_Small", "Small %material Item Pipe", 0.375F, Materials.Platinum, 2, 16384, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Platinum), new GT_MetaPipeEntity_Item(5644, "GT_Pipe_Restrictive_Platinum_Tiny", "Tiny Restrictive %material Item Pipe", 0.25F, Materials.Platinum, 1, 3276800, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Platinum), new GT_MetaPipeEntity_Item(5645, "GT_Pipe_Restrictive_Platinum_Small", "Small Restrictive %material Item Pipe", 0.375F, Materials.Platinum, 2, 1638400, true).getStackForm(1L));

        // Osmium
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Osmium), new GT_MetaPipeEntity_Item(5630, "GT_Pipe_Osmium_Tiny", "Tiny %material Item Pipe", 0.25F, Materials.Osmium, 2, 16384, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Osmium), new GT_MetaPipeEntity_Item(5631, "GT_Pipe_Osmium_Small", "Small %material Item Pipe", 0.375F, Materials.Osmium, 4, 8192, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Osmium), new GT_MetaPipeEntity_Item(5646, "GT_Pipe_Restrictive_Osmium_Tiny", "Tiny Restrictive %material Item Pipe", 0.25F, Materials.Osmium, 2, 1638400, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Osmium), new GT_MetaPipeEntity_Item(5647, "GT_Pipe_Restrictive_Osmium_Small", "Small Restrictive %material Item Pipe", 0.375F, Materials.Osmium, 4, 819200, true).getStackForm(1L));

        // Tin
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Tin), new GT_MetaPipeEntity_Item(5589, "GT_Pipe_Tin_Tiny", "Tiny %material Item Pipe", 0.25F, Materials.Tin, 1, 262144, false, 160).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Tin), new GT_MetaPipeEntity_Item(5590, "GT_Pipe_Tin_Small", "Small %material Item Pipe", 0.375F, Materials.Tin, 1, 131072, false, 80).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Tin), new GT_MetaPipeEntity_Item(5591, "GT_Pipe_Tin", "%material Item Pipe", 0.5F, Materials.Tin, 1, 65536, false, 40).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Tin), new GT_MetaPipeEntity_Item(5592, "GT_Pipe_Tin_Large", "Large %material Item Pipe", 0.75F, Materials.Tin, 1, 32768, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Tin), new GT_MetaPipeEntity_Item(5593, "GT_Pipe_Tin_Huge", "Huge %material Item Pipe", 0.875F, Materials.Tin, 2, 16384, false).getStackForm(1L));

        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Tin), new GT_MetaPipeEntity_Item(5594, "GT_Pipe_Restrictive_Tin_Tiny", "Tiny Restrictive %material Item Pipe", 0.25F, Materials.Tin, 1, 26214400, true, 160).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Tin), new GT_MetaPipeEntity_Item(5595, "GT_Pipe_Restrictive_Tin_Small", "Small Restrictive %material Item Pipe", 0.375F, Materials.Tin, 1, 13107200, true, 80).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(Materials.Tin), new GT_MetaPipeEntity_Item(5596, "GT_Pipe_Restrictive_Tin", "Restrictive %material Pipe", 0.5F, Materials.Tin, 1, 6553600, true, 40).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(Materials.Tin), new GT_MetaPipeEntity_Item(5597, "GT_Pipe_Restrictive_Tin_Large", "Large Restrictive %material Item Pipe", 0.75F, Materials.Tin, 1, 3276800, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(Materials.Tin), new GT_MetaPipeEntity_Item(5598, "GT_Pipe_Restrictive_Tin_Huge", "Huge Restrictive %material Item Pipe", 0.875F, Materials.Tin, 2, 1638400, true).getStackForm(1L));

        // Electrum Fluxed
        /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5650, "GT_Pipe_ElectrumFlux_Tiny", "Tiny Fluxed Electrum Item Pipe", 0.25F, Materials.ElectrumFlux, 4, 8192, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5651, "GT_Pipe_ElectrumFlux_Small", "Small Fluxed Electrum Item Pipe", 0.375F, Materials.ElectrumFlux, 8, 4096, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5652, "GT_Pipe_ElectrumFlux", "Fluxed Electrum Item Pipe", 0.5F, Materials.ElectrumFlux, 16, 2048, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5653, "GT_Pipe_ElectrumFlux_Large", "Large Fluxed Electrum Item Pipe", 0.75F, Materials.ElectrumFlux, 32, 1024, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5654, "GT_Pipe_ElectrumFlux_Huge", "Huge Fluxed Electrum Item Pipe", 0.875F, Materials.ElectrumFlux, 64, 512, false).getStackForm(1L));

        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5655, "GT_Pipe_Restrictive_ElectrumFlux_Tiny", "Tiny Restrictive Fluxed Electrum Item Pipe", 0.25F, Materials.ElectrumFlux, 4, 819200, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5656, "GT_Pipe_Restrictive_ElectrumFlux_Small", "Small Restrictive Fluxed Electrum Item Pipe", 0.375F, Materials.ElectrumFlux, 8, 409600, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5657, "GT_Pipe_Restrictive_ElectrumFlux", "Restrictive Fluxed Electrum Item Pipe", 0.5F, Materials.ElectrumFlux, 16, 204800, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5658, "GT_Pipe_Restrictive_ElectrumFlux_Large", "Large Restrictive Fluxed Electrum Item Pipe", 0.75F, Materials.ElectrumFlux, 32, 102400, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(Materials.ElectrumFlux), new GT_MetaPipeEntity_Item(5659, "GT_Pipe_Restrictive_ElectrumFlux_Huge", "Huge Restrictive Fluxed Electrum Item Pipe", 0.875F, Materials.ElectrumFlux, 64, 51200, true).getStackForm(1L));*/
        generateItemPipes(Materials.ElectrumFlux, Materials.ElectrumFlux.mName, 5650, 16);

        // Black Plutonium
        /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5660, "GT_Pipe_Black_Plutonium_Tiny", "Tiny Black Plutonium Item Pipe", 0.25F, Materials.BlackPlutonium, 8, 4096, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5661, "GT_Pipe_Black_Plutonium_Small", "Small Black Plutonium Item Pipe", 0.375F, Materials.BlackPlutonium, 16, 2048, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5662, "GT_Pipe_Black_Plutonium", "Black Plutonium Item Pipe", 0.5F, Materials.BlackPlutonium, 32, 1024, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5663, "GT_Pipe_Black_Plutonium_Large", "Large Black Plutonium Item Pipe", 0.75F, Materials.BlackPlutonium, 64, 512, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5664, "GT_Pipe_Black_Plutonium_Huge", "Huge Black Plutonium Item Pipe", 0.875F, Materials.BlackPlutonium, 128, 256, false).getStackForm(1L));

        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5665, "GT_Pipe_Restrictive_Black_Plutonium_Tiny", "Tiny Restrictive Black Plutonium Item Pipe", 0.25F, Materials.BlackPlutonium, 8, 409600, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5666, "GT_Pipe_Restrictive_Black_Plutonium_Small", "Small Restrictive Black Plutonium Item Pipe", 0.375F, Materials.BlackPlutonium, 16, 204800, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5667, "GT_Pipe_Restrictive_Black_Plutonium", "Restrictive Black Plutonium Item Pipe", 0.5F, Materials.BlackPlutonium, 32, 102400, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5668, "GT_Pipe_Restrictive_Black_Plutonium_Large", "Large Restrictive Black Plutonium Item Pipe", 0.75F, Materials.BlackPlutonium, 64, 51200, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(Materials.BlackPlutonium), new GT_MetaPipeEntity_Item(5669, "GT_Pipe_Restrictive_Black_Plutonium_Huge", "Huge Restrictive Black Plutonium Item Pipe", 0.875F, Materials.BlackPlutonium, 128, 25600, true).getStackForm(1L));*/
        generateItemPipes(Materials.BlackPlutonium, Materials.BlackPlutonium.mName, 5660, 32);

        // Bedrockium
        /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5670, "GT_Pipe_Bedrockium_Tiny", "Tiny Bedrockium Item Pipe", 0.25F, Materials.Bedrockium, 16, 2048, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5671, "GT_Pipe_Bedrockium_Small", "Small Bedrockium Item Pipe", 0.375F, Materials.Bedrockium, 32, 1024, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5672, "GT_Pipe_Bedrockium", "Bedrockium Item Pipe", 0.5F, Materials.Bedrockium, 64, 512, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5673, "GT_Pipe_Bedrockium_Large", "Large Bedrockium Item Pipe", 0.75F, Materials.Bedrockium, 128, 256, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5674, "GT_Pipe_Bedrockium_Huge", "Huge Bedrockium Item Pipe", 0.875F, Materials.Bedrockium, 256, 128, false).getStackForm(1L));

        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5675, "GT_Pipe_Restrictive_Bedrockium_Tiny", "Tiny Restrictive Bedrockium Item Pipe", 0.25F, Materials.Bedrockium, 16, 204800, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5676, "GT_Pipe_Restrictive_Bedrockiumm_Small", "Small Restrictive Bedrockium Item Pipe", 0.375F, Materials.Bedrockium, 32, 102400, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5677, "GT_Pipe_Restrictive_Bedrockium", "Restrictive Bedrockium Item Pipe", 0.5F, Materials.Bedrockium, 64, 51200, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5678, "GT_Pipe_Restrictive_Bedrockium_Large", "Large Restrictive Bedrockium Item Pipe", 0.75F, Materials.Bedrockium, 128, 25600, true).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(Materials.Bedrockium), new GT_MetaPipeEntity_Item(5679, "GT_Pipe_Restrictive_Bedrockium_Huge", "Huge Restrictive Bedrockium Item Pipe", 0.875F, Materials.Bedrockium, 256, 12800, true).getStackForm(1L));*/
        generateItemPipes(Materials.BlackPlutonium, Materials.BlackPlutonium.mName, 5670, 64);
    }

    private static void generateItemPipes(Materials aMaterial, String name, int startID, int baseInvSlots){
    	generateItemPipes(aMaterial, name, "%material", startID, baseInvSlots);
    }

    private static void generateItemPipes(Materials aMaterial, String name, String displayName, int startID, int baseInvSlots){
    	GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(aMaterial), 				new GT_MetaPipeEntity_Item(startID,		"GT_Pipe_" + displayName + "_Tiny", 			"Tiny " 	+ displayName + " Item Pipe", 			0.25F, aMaterial, baseInvSlots / 4, 131072  / baseInvSlots, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(aMaterial), 				new GT_MetaPipeEntity_Item(startID + 1, "GT_Pipe_" + displayName + "_Small", 			"Small "	+ displayName + " Item Pipe",			0.375F,aMaterial, baseInvSlots / 2,	65536   / baseInvSlots, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(aMaterial), 			new GT_MetaPipeEntity_Item(startID + 2,	"GT_Pipe_" + displayName, 									  displayName + " Item Pipe", 			0.50F, aMaterial, baseInvSlots, 	32768   / baseInvSlots, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(aMaterial), 				new GT_MetaPipeEntity_Item(startID + 3, "GT_Pipe_" + displayName + "_Large", 			"Large " 	+ displayName + " Item Pipe", 			0.75F, aMaterial, baseInvSlots * 2, 16384   / baseInvSlots, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(aMaterial), 				new GT_MetaPipeEntity_Item(startID + 4, "GT_Pipe_" + displayName + "_Huge", 			"Huge " 	+ displayName + " Item Pipe", 			0.875F,aMaterial, baseInvSlots * 4,	8192    / baseInvSlots, false).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveTiny.get(aMaterial), 	new GT_MetaPipeEntity_Item(startID + 5, "GT_Pipe_Restrictive_" + displayName + "_Tiny", "Tiny Restrictive "  + displayName + " Item Pipe", 	0.25F, aMaterial, baseInvSlots / 4, 13107200/ baseInvSlots, true ).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveSmall.get(aMaterial), 	new GT_MetaPipeEntity_Item(startID + 6, "GT_Pipe_Restrictive_" + displayName + "_Small","Small Restrictive " + displayName + " Item Pipe", 	0.375F,aMaterial, baseInvSlots / 2,	6553600 / baseInvSlots, true ).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveMedium.get(aMaterial), 	new GT_MetaPipeEntity_Item(startID + 7, "GT_Pipe_Restrictive_" + displayName, 			"Restrictive "       + displayName + " Item Pipe", 	0.50F, aMaterial, baseInvSlots, 	3276800 / baseInvSlots, true ).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveLarge.get(aMaterial), 	new GT_MetaPipeEntity_Item(startID + 8, "GT_Pipe_Restrictive_" + displayName + "_Large","Large Restrictive " + displayName + " Item Pipe", 	0.75F, aMaterial, baseInvSlots * 2, 1638400 / baseInvSlots, true ).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeRestrictiveHuge.get(aMaterial), 	new GT_MetaPipeEntity_Item(startID + 9, "GT_Pipe_Restrictive_" + displayName + "_Huge", "Huge Restrictive "  + displayName + " Item Pipe", 	0.875F,aMaterial, baseInvSlots * 4,	819200  / baseInvSlots, true ).getStackForm(1L));
    }
}
// Last ID  here: 5679

