package androidx.compose.animation.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: SpringSimulation.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0004\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "init", "", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SpringSimulation {
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float finalPosition) {
        this.finalPosition = finalPosition;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float value) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(value);
        this.initialized = false;
    }

    public final float getStiffness() {
        return (float) (this.naturalFreq * this.naturalFreq);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final void setDampingRatio(float value) {
        if (value < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = value;
        this.initialized = false;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        float adjustedDisplacement = lastDisplacement - this.finalPosition;
        double k = this.naturalFreq * this.naturalFreq;
        double c = this.naturalFreq * 2.0d * this.dampingRatio;
        return (float) (((-k) * adjustedDisplacement) - (lastVelocity * c));
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double dampingRatioSquared = this.dampingRatio * this.dampingRatio;
        if (this.dampingRatio > 1.0f) {
            double d = 1;
            this.gammaPlus = ((-this.dampingRatio) * this.naturalFreq) + (this.naturalFreq * Math.sqrt(dampingRatioSquared - d));
            this.gammaMinus = ((-this.dampingRatio) * this.naturalFreq) - (this.naturalFreq * Math.sqrt(dampingRatioSquared - d));
        } else if (this.dampingRatio >= 0.0f && this.dampingRatio < 1.0f) {
            this.dampedFreq = this.naturalFreq * Math.sqrt(1 - dampingRatioSquared);
        }
        this.initialized = true;
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m111updateValuesIJZedt4$animation_core_release(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double currentVelocity;
        double displacement;
        init();
        float adjustedDisplacement = lastDisplacement - this.finalPosition;
        double deltaT = timeElapsed / 1000.0d;
        if (this.dampingRatio > 1.0f) {
            double coeffA = adjustedDisplacement - (((this.gammaMinus * adjustedDisplacement) - lastVelocity) / (this.gammaMinus - this.gammaPlus));
            double coeffB = ((this.gammaMinus * adjustedDisplacement) - lastVelocity) / (this.gammaMinus - this.gammaPlus);
            displacement = (Math.exp(this.gammaMinus * deltaT) * coeffA) + (Math.exp(this.gammaPlus * deltaT) * coeffB);
            currentVelocity = (this.gammaMinus * coeffA * Math.exp(this.gammaMinus * deltaT)) + (this.gammaPlus * coeffB * Math.exp(this.gammaPlus * deltaT));
        } else {
            if (this.dampingRatio == 1.0f) {
                double coeffB2 = lastVelocity + (this.naturalFreq * adjustedDisplacement);
                displacement = (adjustedDisplacement + (coeffB2 * deltaT)) * Math.exp((-this.naturalFreq) * deltaT);
                currentVelocity = ((adjustedDisplacement + (coeffB2 * deltaT)) * Math.exp((-this.naturalFreq) * deltaT) * (-this.naturalFreq)) + (Math.exp((-this.naturalFreq) * deltaT) * coeffB2);
            } else {
                double sinCoeff = (1 / this.dampedFreq) * ((this.dampingRatio * this.naturalFreq * adjustedDisplacement) + lastVelocity);
                double displacement2 = Math.exp((-this.dampingRatio) * this.naturalFreq * deltaT) * ((adjustedDisplacement * Math.cos(this.dampedFreq * deltaT)) + (Math.sin(this.dampedFreq * deltaT) * sinCoeff));
                double d = (-this.naturalFreq) * displacement2 * this.dampingRatio;
                double d2 = -this.dampingRatio;
                double currentVelocity2 = this.naturalFreq;
                currentVelocity = d + (Math.exp(d2 * currentVelocity2 * deltaT) * (((-this.dampedFreq) * adjustedDisplacement * Math.sin(this.dampedFreq * deltaT)) + (this.dampedFreq * sinCoeff * Math.cos(this.dampedFreq * deltaT))));
                displacement = displacement2;
            }
        }
        float newValue = (float) (this.finalPosition + displacement);
        float newVelocity = (float) currentVelocity;
        return SpringSimulationKt.Motion(newValue, newVelocity);
    }
}
