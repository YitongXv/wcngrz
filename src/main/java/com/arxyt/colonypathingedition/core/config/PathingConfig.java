package com.arxyt.colonypathingedition.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PathingConfig {
    public static ForgeConfigSpec.DoubleValue RAIL_COST_MULTIPLIER;
    public static ForgeConfigSpec.DoubleValue WATER_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue JUMP_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue DROP_COST_MULTIPLIER;
    public static ForgeConfigSpec.DoubleValue ROAD_COST_MULTIPLIER;
    public static ForgeConfigSpec.DoubleValue INSHAPE_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue DOORS_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue DIVE_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue CAVE_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue RAILEXIT_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue PANEL_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue SHINGLE_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue FARMLAND_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue LEAF_COST_DEFINER;
    public static ForgeConfigSpec.DoubleValue BERRY_COST_DEFINER;

    public static ForgeConfigSpec.DoubleValue ONRAIL_CALLBACK_MULTIPLIER;
    public static ForgeConfigSpec.DoubleValue ONROAD_CALLBACK_MULTIPLIER;
    public static ForgeConfigSpec.DoubleValue ONRAIL_PREFERENCE;
    public static ForgeConfigSpec.DoubleValue ONROAD_PREFERENCE;
    public static ForgeConfigSpec.IntValue CALLBACK_TIMES_TOLERANCE;

    public static ForgeConfigSpec.IntValue MAX_PATHING_DISTANCE;
    public static ForgeConfigSpec.BooleanValue MAX_ANIMAL_MODIFIER;

    public static ForgeConfigSpec init(ForgeConfigSpec.Builder builder) {
        builder.push("Pathing Cost Modifier #寻路Cost相关设置#");
        builder.push("Multiplier #乘子系数#");
        RAIL_COST_MULTIPLIER = builder
                .comment("Rail path cost multiplier (default: 0.1, ordinary:0.1) #铁轨Cost乘数 (默认 : 0.1 殖民地原设置 : 0.1)#")
                .defineInRange("railCostMultiplier", 0.1, 0.0, 2.0);
        ROAD_COST_MULTIPLIER = builder
                .comment("Road path cost multiplier (default: 0.4, ordinary:1/6) #路径Cost乘数 (默认 : 0.4 殖民地原设置 : 1/6)#")
                .defineInRange("roadCostMultiplier", 0.4, 0.0, 2.0);
        DROP_COST_MULTIPLIER = builder
                .comment("Drop cost multiplier (default: 1.0, ordinary:1.0) #掉落Cost乘数 (默认 : 1.0 殖民地原设置 : 1.0)#\n" +
                        "Notice: The base formula for falling cost has been modified from |dY|³ to (|dY| - 2/5)³ - 8/125. #注意:下落Cost基础公式已经从|dY|³修改为(|dY|-2/5)³-8/125.#")
                .defineInRange("dropCostMultiplier", 1.0, 0.0, 10.0);
        builder.pop();
        builder.push("Basic Cost Definer #基础Cost定义#");
        WATER_COST_DEFINER = builder
                .comment("Water path cost addon (default: 8.0, ordinary:2.0) #水路Cost (默认 : 8.0 殖民地原设置 : 2.0)#")
                .defineInRange("waterCostAddon", 8.0, 0.0, 24.0);
        JUMP_COST_DEFINER = builder
                .comment("Jump cost addon (default: 2.0, ordinary:2.0) #跳跃(准确来说是非梯子爬升)Cost (默认 : 2.0 殖民地原设置 : 2.0)#")
                .defineInRange("jumpCostAddon", 2.0, 0.0, 24.0);
        INSHAPE_COST_DEFINER = builder
                .comment("In shape cost addon (default: 2.0, ordinary:2.0) #实体方块内部行走的Cost (默认 : 2.0 殖民地原设置 : 2.0)#")
                .defineInRange("inShapeCostAddon", 2.0, 0.0, 24.0);
        DOORS_COST_DEFINER = builder
                .comment("Door and trapdoor’s cost addon (default: 3.0, ordinary:3.0) #穿过各种\"门\"的Cost (默认 : 3.0 殖民地原设置 : 3.0)#")
                .defineInRange("doorsCostAddon", 3.0, 0.0, 24.0);
        DIVE_COST_DEFINER = builder
                .comment("Dive cost addon (default: 24.0, ordinary:4.0) #潜水(潜多了会淹死)的Cost (默认 : 24.0 殖民地原设置 : 4.0)#")
                .defineInRange("diveCostAddon", 24.0, 0.0, 24.0);
        CAVE_COST_DEFINER = builder
                .comment("Breathing cave air cost addon (default: 0.3, ordinary:3.0) #钻洞(人工的也算)的Cost,(默认 : 0.3 殖民地原设置 : 3.0)#")
                .defineInRange("caveCostAddon", 0.3, 0.0, 24.0);
        RAILEXIT_COST_DEFINER = builder
                .comment("Exit railway cost addon (default: 4.0, ordinary:4.0) #下铁路(人工的也算)的Cost(探测铁轨为”站点“，不计cost) (默认 : 4.0 殖民地原设置 : 4.0)#")
                .defineInRange("railExitAddon", 4.0, 0.0, 24.0);
        builder.pop();
        builder.push("Typical Cost Definer #针对性Cost定义#");
        PANEL_COST_DEFINER = builder
                .comment("Walk into panel cost addon (default: 4.0) #走在面板方块中(会不停的跳)的Cost (默认 : 4.0)#")
                .defineInRange("panelCostAddon", 4.0, 0.0, 24.0);
        SHINGLE_COST_DEFINER = builder
                .comment("Walk on shingle cost addon (default: 3.0, ordinary:3.0) #上房揭瓦(走在屋瓦上)的Cost (默认 : 3.0 殖民地原设置 : 3.0)#")
                .defineInRange("shingleCostAddon", 3.0, 0.0, 24.0);
        FARMLAND_COST_DEFINER = builder
                .comment("Jump in farmland or drop onto farmland cost addon (default: 8.0) #在农田中跳上跳下的Cost (默认 : 8.0)#")
                .defineInRange("farmlandCostAddon", 8.0, 0.0, 24.0);
        LEAF_COST_DEFINER = builder
                .comment("Walk on leaves cost addon (default: 4.0) #爬树(走在树叶上)的Cost (默认 : 4.0)#")
                .defineInRange("leafCostAddon", 4.0, 0.0, 24.0);
        BERRY_COST_DEFINER = builder
                .comment("Walk in sweet berry bush cost addon (default: 24.0) #被浆果丛扎的Cost (默认 : 24.0)#")
                .defineInRange("berryCostAddon", 24.0, 0.0, 24.0);
        builder.pop();
        builder.push("Advanced Pathfinding Constant Definer #进阶寻路算法常数定义(警告：慎重修改！会对全局寻路产生极大影响！)#");
        ONRAIL_CALLBACK_MULTIPLIER = builder
                .comment("""
                        When traversing callback nodes, there is a heuristic reduction on artificial roads. This value is used to control the rate at which the heuristic for railway callback nodes increases, and its formula is: RAIL_COST_MULTIPLIER * ONRAIL_CALLBACK_MULTIPLIER (default: 1.0)\s
                        走回头路(其节点暂定义为回扣节点)时在人工道路上会有启发值减免,这是用来控制铁路回扣节点启发值增加速度的数值，其算式为 RAIL_COST_MULTIPLIER * ONRAIL_CALLBACK_MULTIPLIER (默认 : 1.0)""")
                .defineInRange("onRailCallbackMutiplier", 1.0, 0.0, 2.0);
        ONROAD_CALLBACK_MULTIPLIER = builder
                .comment("""
                        This value is used to control the rate at which the heuristic for callback nodes on road blocks increases, and its formula is: ROAD_COST_MULTIPLIER * ONROAD_CALLBACK_MULTIPLIER (default: 1.2)\s
                        用来控制道路方块上回扣节点启发值增加速度的数值，其算式为 ROAD_COST_MULTIPLIER * ONROAD_CALLBACK_MULTIPLIER (默认 : 1.2)""")
                .defineInRange("onRoadCallbackMutiplier", 1.2, 0.0, 2.0);
        ONRAIL_PREFERENCE = builder
                .comment("""
                        This is a global heuristic reduction, representing how much villagers prefer railways when pathfinding far away from the target point. The smaller the value, the stronger the preference. (default: 0.85)
                        是一个全局的启发值减免，表现为村民在远离目标点处寻路时对铁路的信任程度，数值越小越信任(默认 : 0.85)""")
                .defineInRange("onRailPreference", 0.85, 0.5, 2.0);
        ONROAD_PREFERENCE = builder
                .comment("""
                        This is a global heuristic reduction, representing how much villagers prefer path blocks when pathfinding far away from the target point. The smaller the value, the stronger the preference. (default: 0.92)
                        是一个全局的启发值减免，表现为村民在远离目标点处寻路时对道路方块的信任程度，数值越小越信任(默认 : 0.92)""")
                .defineInRange("onRoadPreference", 0.92, 0.5, 2.0);
        CALLBACK_TIMES_TOLERANCE = builder
                .comment("Tolerates how many times callback nodes can be expanded during each pathfinding process. (default: 2) #能容忍每次寻路中回扣节点被扩展几次，数值过大可能会造成扩展的无用节点增加 (默认 : 2)#")
                .defineInRange("callbackTimesTolerance", 2, 1, 25);
        builder.pop();
        builder.pop();
        builder.push("Basic Logic Modifier #基础逻辑修改#");
        MAX_PATHING_DISTANCE = builder
                .comment("Max pathing distance (default: 1000, ordinary:500) #市民最大寻路距离,(默认 : 1000 殖民地原设置 : 500)#")
                .defineInRange("pathingDistance", 1000, 500, 4095);
        MAX_ANIMAL_MODIFIER = builder
                .comment("Max animal modifier, would you like to modify the max animals to 2^(building level)? (default: false)\n #养殖场最大生物数是否改为 2^建筑等级 原为 2*建筑等级(动物数目过大会导致卡顿，所以不默认开启),(默认 : false)#")
                .define("increaceMaxAnimal",false);
        builder.pop();
        return builder.build(); // 返回构建结果
    }
}