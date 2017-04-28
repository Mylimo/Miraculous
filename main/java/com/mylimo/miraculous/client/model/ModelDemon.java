package com.mylimo.miraculous.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDemon extends ModelBiped
{
    public ModelRenderer demonRightHorn;
    public ModelRenderer demonLeftHorn;

    public ModelDemon()
    {
        this(0.0F, false);
    }

    public ModelDemon(float modelSize, boolean p_i46303_2_)
    {
        super(modelSize, 0.0F, 64, 32);

        if (!p_i46303_2_) {

            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, modelSize);
            this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
            this.bipedLeftArm = new ModelRenderer(this, 40, 16);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, modelSize);
            this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, modelSize);
            this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, modelSize);
            this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
            this.demonRightHorn = new ModelRenderer(this, 48, 16);
            this.demonRightHorn.addBox(-5.0F, -10.0F, -2.0F, 1, 4, 1, modelSize);
            this.demonRightHorn.setRotationPoint(0, 0, 0);
            this.demonLeftHorn = new ModelRenderer(this, 48, 16);
            this.demonLeftHorn.mirror = true;
            this.demonLeftHorn.addBox(4.0F, -10.0F, -2.0F, 1, 4, 1, modelSize);
            this.demonLeftHorn.setRotationPoint(0,0,0);
        }
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.bipedRightArm.render(scale);
        this.bipedLeftArm.render(scale);
        this.bipedRightLeg.render(scale);
        this.bipedLeftLeg.render(scale);
        this.bipedHead.render(scale);
        this.bipedBody.render(scale);
        this.demonRightHorn.render(scale);
        this.demonLeftHorn.render(scale);
    }

    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        copyModelAngles(this.bipedHead, this.demonRightHorn);
        copyModelAngles(this.bipedHead, this.demonLeftHorn);

    }
}
