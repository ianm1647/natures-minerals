package com.ianm1647.naturesminerals.config;

import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;
public class NaturesMineralsConfig implements Config {
    @Comment(value = "The durability multiplier for hammers and excavators")
    public int durabilityMultiplier = 5;

    @Comment(value = "Uvarovite ore values")
    public int maxHeightU = 10;
    public int minHeightU = -40;
    public int veinSizeU = 5;
    public int chunkAmountU = 2;

    @Comment(value = "Kunzite ore values")
    public int maxHeightK = -20;
    public int minHeightK = -60;
    public int veinSizeK = 4;
    public int chunkAmountK = 2;

    @Comment(value = "Stibnite ore values")
    public int maxHeightS = 256;
    public int minHeightS = 0;
    public int veinSizeS = 4;
    public int chunkAmountS = 6;

    @Comment(value = "Astrite ore values")
    public int maxHeightA = 256;
    public int minHeightA = 0;
    public int veinSizeA = 4;
    public int chunkAmountA = 6;


    @Override
    public String getName() {
        return "naturesminerals";
    }
}
