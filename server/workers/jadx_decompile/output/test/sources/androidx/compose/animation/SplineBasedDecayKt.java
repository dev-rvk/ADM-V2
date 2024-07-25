package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplineBasedDecay.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EndTension", "", "Inflection", "P1", "P2", "StartTension", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void computeSplineInfo(float[] splinePositions, float[] splineTimes, int nbSamples) {
        float f;
        float x;
        float f2;
        float coef;
        float y;
        float coef2;
        float xMin = 0.0f;
        float yMin = 0.0f;
        for (int i = 0; i < nbSamples; i++) {
            float alpha = i / nbSamples;
            float xMax = 1.0f;
            while (true) {
                f = 2.0f;
                x = xMin + ((xMax - xMin) / 2.0f);
                f2 = 3.0f;
                coef = x * 3.0f * (1.0f - x);
                float tx = ((((1.0f - x) * P1) + (x * P2)) * coef) + (x * x * x);
                if (Math.abs(tx - alpha) < 1.0E-5d) {
                    break;
                } else if (tx > alpha) {
                    xMax = x;
                } else {
                    xMin = x;
                }
            }
            splinePositions[i] = ((((1.0f - x) * 0.5f) + x) * coef) + (x * x * x);
            float yMax = 1.0f;
            while (true) {
                y = yMin + ((yMax - yMin) / f);
                coef2 = y * f2 * (1.0f - y);
                float dy = ((((1.0f - y) * 0.5f) + y) * coef2) + (y * y * y);
                float yMax2 = yMax;
                if (Math.abs(dy - alpha) >= 1.0E-5d) {
                    if (dy > alpha) {
                        yMax = y;
                        f2 = 3.0f;
                        f = 2.0f;
                    } else {
                        yMin = y;
                        yMax = yMax2;
                        f2 = 3.0f;
                        f = 2.0f;
                    }
                }
            }
            splineTimes[i] = ((((1.0f - y) * P1) + (y * P2)) * coef2) + (y * y * y);
        }
        splineTimes[nbSamples] = 1.0f;
        splinePositions[nbSamples] = splineTimes[nbSamples];
    }

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
